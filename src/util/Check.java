package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Check {
	public static boolean check(String s1,String s2) {
		String t1[] = new String[3], t2[] = new String[3], time;
		int y1,y2,m1,m2,d1,d2,t,compare = 0;
		y1 = Integer.parseInt(s1.substring(0, 4));
		m1 = Integer.parseInt(s1.substring(5, 7));
		d1 = Integer.parseInt(s1.substring(8, 10));
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		time = df.format(new Date());
		y2 = Integer.parseInt(time.substring(0, 4));
		m2 = Integer.parseInt(time.substring(5, 7));
		d2 = Integer.parseInt(time.substring(8, 10));
		t = Integer.parseInt(s2);
		System.out.println(t);
		if(y1<y2)
			compare = m2 - m1 + 12 * (y2-y1);
		else if(y1 == y2)
			compare = m2 - m1;
		if(compare>t)
			return true;
		else if(compare==t && d2> d1)
			return true;
		else
			return false;
		
	}

}
