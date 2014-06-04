package com.bridea.siak.util;

public enum DaysEnum {

	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY;
	
	private static String SUNDAY_DESCRIPTION="Sunday";
	private static String MONDAY_DESCRIPTION="Monday";
	private static String TUESDAY_DESCRIPTION="Tuesday";
	private static String WEDNESDAY_DESCRIPTION="Wednesday";
	private static String THURSDAY_DESCRIPTION="Thursday";
	private static String FRIDAY_DESCRIPTION="Friday";
	private static String SATURDAY_DESCRIPTION="Saturday";
	private static String MINGGU_DESCRIPTION="Minggu";
	private static String SENIN_DESCRIPTION="Senin";
	private static String SELASA_DESCRIPTION="Selasa";
	private static String RABU_DESCRIPTION="Rabu";
	private static String KAMIS_DESCRIPTION="Kamis";
	private static String JUMAT_DESCRIPTION="Jumat";
	private static String SABTU_DESCRIPTION="Sabtu";

	
	public String getEnglishDescription() {
		switch (this) {
		case SUNDAY:
			return SUNDAY_DESCRIPTION;
		case MONDAY:
			return MONDAY_DESCRIPTION;
		case TUESDAY:
			return TUESDAY_DESCRIPTION;
		case WEDNESDAY:
			return WEDNESDAY_DESCRIPTION;
		case THURSDAY:
			return THURSDAY_DESCRIPTION;
		case FRIDAY:
			return FRIDAY_DESCRIPTION;
		case SATURDAY:
			return SATURDAY_DESCRIPTION;		
		default:
			return "";
		}
	}
	
	public String getIndonesiaDescription() {
		switch (this) {		
		case SUNDAY:
			return MINGGU_DESCRIPTION;
		case MONDAY:
			return SENIN_DESCRIPTION;
		case TUESDAY:
			return SELASA_DESCRIPTION;
		case WEDNESDAY:
			return RABU_DESCRIPTION;
		case THURSDAY:
			return KAMIS_DESCRIPTION;
		case FRIDAY:
			return JUMAT_DESCRIPTION;
		case SATURDAY:
			return SABTU_DESCRIPTION;		
		default:
			return "";
		}
	}
		
}
