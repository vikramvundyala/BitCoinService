package com.ps.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class PsUtil {
	
	private static DateFormat df = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm");
	
	public static Function<Date, String> dateFormat = d ->  df.format(d);
	

}
