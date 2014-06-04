package com.bridea.siak.util;

import java.util.Date;


public class DateUtil {
	
	public static DaysEnum getDays(int days) {
				
		switch (days) {
			case 0: return DaysEnum.SUNDAY;
			case 1: return DaysEnum.MONDAY;
			case 2: return DaysEnum.TUESDAY;
			case 3: return DaysEnum.WEDNESDAY;
			case 4: return DaysEnum.THURSDAY;
			case 5: return DaysEnum.FRIDAY;
			case 6: return DaysEnum.SATURDAY;
			default : return null;
		}
	}
	
	public static String getEnglishDate(Date date) {
		StringBuilder dateString = new StringBuilder();
		dateString.append(DateUtil.getDays(date.getDay()).getEnglishDescription()).append(", ").append(date.getYear()+1900).append("-").append(date.getMonth()).append("-").append(date.getDate());
		return dateString.toString(); 
	}
	
	public static String getIndonesianDate(Date date) {
		StringBuilder dateString = new StringBuilder();
	    dateString.append(DateUtil.getDays(date.getDay()).getIndonesiaDescription()).append(", ").append(date.getDate()).append("-").append(date.getMonth()).append("-").append(date.getYear()+1900);
		return dateString.toString(); 
	}

	
}

