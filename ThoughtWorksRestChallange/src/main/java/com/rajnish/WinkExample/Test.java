package com.rajnish.WinkExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = sdf.parse("2017-01-30 10:00:00");
		System.out.println(dt);
	}
}
