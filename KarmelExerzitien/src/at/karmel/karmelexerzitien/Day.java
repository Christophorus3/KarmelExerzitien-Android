/**
 * 
 */
package at.karmel.karmelexerzitien;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author chris
 *
 */
public class Day {
	
	String name;
	Date date;
	String headline;
	int number;
	
	public String dateDescription() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d. MMMM", Locale.getDefault());
		
		String result = sdf.format(this.date);
		return result;
	}

}
