package com.wirtz.ecommerce.model.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wirtz.ecommerce.model.userprofile.UserProfile;
import com.wirtz.ecommerce.model.userprofile.UserProfileDao;
import com.wirtz.ecommerce.modelutil.exceptions.DuplicateInstanceException;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;
import com.wirtz.ecommerce.modelutil.exceptions.PasswordMissmatchException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired //++19
	private UserProfileDao userProfileDao;

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	


	public Long registerUser(String loginName, String clearPassword,
			String confirmPassword,
			UserProfileDetails userProfileDetails)
			throws DuplicateInstanceException, PasswordMissmatchException {

		try {
					
			userProfileDao.findByLoginName(loginName);
			throw new DuplicateInstanceException(loginName, UserProfile.class
					.getName());
		} catch (InstanceNotFoundException e) {
			
			
						
			//++19
			if(clearPassword.compareTo(confirmPassword)==0) {
			
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String encryptedPassword = encoder.encode(clearPassword);
			//String encryptedPassword = PasswordEncrypter.crypt(clearPassword);
			
			UserProfile userProfile = new UserProfile(
					loginName, encryptedPassword, userProfileDetails.getFirstName(),
					userProfileDetails.getLastName(), userProfileDetails
							.getEmail());

			userProfileDao.create(userProfile);
			return userProfile.getUserProfileId();
			}
			else{
				throw new PasswordMissmatchException(clearPassword, UserProfile.class
					.getName());
			}
		}

	}

	@Transactional(readOnly = true)
	public LoginResult login(String loginName, String password,
			boolean passwordIsEncrypted) throws InstanceNotFoundException,
			IncorrectPasswordException {

		UserProfile userProfile = userProfileDao.findByLoginName(loginName);
		String storedPassword = userProfile.getEncryptedPassword();

		if (passwordIsEncrypted) {
			if (!password.equals(storedPassword)) {
				throw new IncorrectPasswordException(loginName);
			}
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if(!encoder.matches(password, storedPassword)) {
			//if (!PasswordEncrypter.isClearPasswordCorrect(password,
				//	storedPassword)) {
				throw new IncorrectPasswordException(loginName);
			}
		}
		return new LoginResult(userProfile.getUserProfileId(), userProfile
				.getFirstName(), storedPassword);

	}

	@Transactional(readOnly = true)
	public UserProfileDetails findUserProfileDetails(Long userProfileId)
			throws InstanceNotFoundException {
		UserProfile userProfile;

		userProfile = userProfileDao.find(userProfileId);

		return new UserProfileDetails(userProfile.getFirstName(), userProfile
				.getLastName(), userProfile.getEmail());
	}



	





}
