package com.wirtz.ecommerce.model.userprofile;

import com.wirtz.ecommerce.modelutil.dao.GenericDao;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

public interface UserProfileDao extends GenericDao<UserProfile, Long>{

    /**
     * Returns an UserProfile by login name (not user identifier)
     *
     * @param loginName the user identifier
     * @return the UserProfile
     */
    public UserProfile findByLoginName(String loginName) throws InstanceNotFoundException;
}

