package com.wirtz.ecommerce.model.util;

import java.util.Calendar;


public  class CalendarUtil {

	public static boolean compare (Calendar date1, Calendar date2){
		if (date1.get(Calendar.DAY_OF_MONTH)!= date2.get(Calendar.DAY_OF_MONTH))
			return false;
		if (date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH))
			return false;
		if (date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR))
			return false;
		if (date1.get(Calendar.HOUR) != date2.get(Calendar.HOUR))
			return false;
		if (date1.get(Calendar.MINUTE) != date2.get(Calendar.MINUTE))
			return false;
		if (date1.get(Calendar.SECOND) != date2.get(Calendar.SECOND))
			return false;
		return true;
	}
}
