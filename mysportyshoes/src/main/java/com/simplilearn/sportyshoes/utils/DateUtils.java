package com.simplilearn.sportyshoes.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

		public static String dateYYYYMMDD() {
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
			String dateYYYYMMDD = sm.format(new Date());
			return dateYYYYMMDD;
		}
}
