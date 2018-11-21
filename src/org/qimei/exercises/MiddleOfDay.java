package org.qimei.exercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MiddleOfDay {

	public static void main(String[] args) throws ParseException {
		System.out.println("results:"+getMiddleOfDay("6:27","18:53"));
	}
	
	public static String getMiddleOfDay (String sunriseTime, String sunsetTime) throws ParseException {
		
		int sunriseHrs = Integer.valueOf(sunriseTime.substring(0, sunriseTime.indexOf(":")));
		int sunriseMins = Integer.valueOf(sunriseTime.substring(sunriseTime.indexOf(":")+1));
		System.out.println("sunriseHrs:"+sunriseHrs);
		System.out.println("sunriseMins:"+sunriseMins);

		int sunsetHrs = Integer.valueOf(sunsetTime.substring(0, sunsetTime.indexOf(":")));
		int sunsetMins = Integer.valueOf(sunsetTime.substring(sunsetTime.indexOf(":")+1));
		System.out.println("sunsetHrs:"+sunsetHrs);
		System.out.println("sunsetMins:"+sunsetMins);
		
//		int mins = 0;
//		int hours = 0;
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");  
		Date d1 = null;
		Date d2 = null;
		d1 = format.parse(sunriseTime);
	    d2 = format.parse(sunsetTime);
	    System.out.println("d1:"+d1.getTime());
	    System.out.println("d2:"+d2.getTime());
	    long diff = d2.getTime() - d1.getTime();
	    System.out.println("diff:"+diff);

	    long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
	    long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
	    long hours = TimeUnit.MILLISECONDS.toHours(diff);
	    System.out.println("time:"+hours+":"+minutes+":"+seconds);
	    
	    String hhMM = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toHours(diff),
	            TimeUnit.MILLISECONDS.toMinutes(diff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff)));
	    System.out.println("HHmm:"+hhMM);
	    
		return hhMM;

	}

}
