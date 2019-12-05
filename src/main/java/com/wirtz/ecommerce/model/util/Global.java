package com.wirtz.ecommerce.model.util;

public class Global {
	public static final String USER_PROFILE_ID = "userProfileId";

	public static final String USER_FIRST_NAME = "userFirstName";

	public static String RedirectTo(String view) {
		return "redirect:" + view;
	}
	
	public static final int PAGE_SIZE=2;
}
