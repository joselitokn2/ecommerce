package com.wirtz.ecommerce.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wirtz.ecommerce.model.userprofile.LoginUserGroupValidator;
import com.wirtz.ecommerce.model.userprofile.RegisterUserGroupValidator;
import com.wirtz.ecommerce.model.userprofile.UserProfile;
import com.wirtz.ecommerce.model.userservice.IncorrectPasswordException;
import com.wirtz.ecommerce.model.userservice.LoginResult;
import com.wirtz.ecommerce.model.userservice.UserProfileDetails;
import com.wirtz.ecommerce.model.userservice.UserService;
import com.wirtz.ecommerce.model.util.FeedbackMessage;
import com.wirtz.ecommerce.model.util.Global;
import com.wirtz.ecommerce.modelutil.exceptions.DuplicateInstanceException;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;
import com.wirtz.ecommerce.modelutil.exceptions.PasswordMissmatchException;

@Controller

public class UserProfileController {

	private static final String REGISTER_VIEW = "Registration";
	private static final String LOGIN_VIEW = "Login";	
	

	private static final String USER_ATT = "user";
	private static final String ERROR_ATT = "feedback";

	
	private static final String LOGIN_ACTION= "login";	
	private static final String PRODUCTS_ACTION = "/products";
	@Autowired
	UserService userService;

	@GetMapping("/register")
	public String getForm(Model m) {
		m.addAttribute(USER_ATT, new UserProfile());
		return REGISTER_VIEW;
	}

	@PostMapping("/register")
	public String createUser(@Validated(RegisterUserGroupValidator.class) @ModelAttribute(USER_ATT) UserProfile user,

			BindingResult result,

			Model m, HttpSession session) {

		if (result.hasErrors()) {
			return REGISTER_VIEW;
		} else {
			try {
				 userService.registerUser(user.getLoginName(), user.getPassword(),
						user.getPasswordConfirm(),
						new UserProfileDetails(user.getFirstName(), user.getLastName(), user.getEmail()));
			

				return Global.RedirectTo(LOGIN_ACTION);
			}

			catch (PasswordMissmatchException ex) {
				System.out.println(ex.getMessage());

				m.addAttribute(ERROR_ATT, createErrorMessage(ex.getMessage()));
				return REGISTER_VIEW;

			} catch (DuplicateInstanceException ex) {
				System.out.println(ex.getMessage());

				m.addAttribute(ERROR_ATT, createErrorMessage(ex.getMessage()));
				return REGISTER_VIEW;

			}

			catch (Exception ex) {

				System.out.println(ex.getMessage());
				m.addAttribute(ERROR_ATT, createErrorMessage(ex.getMessage()));
				return REGISTER_VIEW;
			}
		}

	}

	@GetMapping("/login")
	public String Login(Model m) {
		m.addAttribute(USER_ATT, new UserProfile());
		return LOGIN_VIEW;
	}

	@PostMapping("/login")
	public String Login(@Validated(LoginUserGroupValidator.class) @ModelAttribute("user") UserProfile user,
			BindingResult result, Model m, HttpSession session) {

		if (result.hasErrors()) {
			return LOGIN_VIEW;
		} else {
			try {
				LoginResult loginResult = userService.login(user.getLoginName(), user.getPassword(), false);
				storeInSession(loginResult.getUserProfileId(), loginResult.getFirstName(), session);
				return Global.RedirectTo(PRODUCTS_ACTION);
				
			} catch (IncorrectPasswordException ex) {
				m.addAttribute(ERROR_ATT, createErrorMessage(ex.getMessage()));
				return LOGIN_VIEW;

			} catch (InstanceNotFoundException ex) {
				m.addAttribute(ERROR_ATT, createErrorMessage(ex.getMessage()));
				return LOGIN_VIEW;
			}
			catch (Exception e) {
				m.addAttribute(ERROR_ATT, createErrorMessage(e.getMessage()));
				return LOGIN_VIEW;
			}
		}

	}
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		
		session.removeAttribute(Global.USER_FIRST_NAME);
		session.removeAttribute(Global.USER_PROFILE_ID);
		return Global.RedirectTo(PRODUCTS_ACTION);
	}

	private FeedbackMessage createErrorMessage(String msg) {
		FeedbackMessage fbMsg = new FeedbackMessage();
		fbMsg.setError(true);

		fbMsg.setMessage(msg);
		return fbMsg;
	}

	private void storeInSession(long userProfileId, String firstName, HttpSession session) {
		session.setAttribute(Global.USER_FIRST_NAME, firstName);
		session.setAttribute(Global.USER_PROFILE_ID, userProfileId);

	}
	
	
	

}
