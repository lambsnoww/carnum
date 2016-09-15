package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MynoteUtil {
	public static String formatDate(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}
}
