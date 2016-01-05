package alex.demo.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 16/1/5.
 */
public class DateUtils {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /** @return "2016-01-05" **/
    public static String get_year_month_day(long currentMills){
       return dateFormat.format(new Date(currentMills)).toString();
    }
}
