package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by admin on 7/15/16.
 */
public class DateProducer {
    public static String [] getDates(int dayDifference, String format){
        Calendar date = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setCalendar(date);
        String originDateString = simpleDateFormat.format(date.getTime());
        date.add(Calendar.DAY_OF_MONTH, dayDifference);
        String returnDateString = simpleDateFormat.format(date.getTime());
        String [] dates = {originDateString, returnDateString};
        return dates;
    }

    public static String [] getDates(int dayDifference){
        Calendar date = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YY");
        simpleDateFormat.setCalendar(date);
        String originDateString = simpleDateFormat.format(date.getTime());
        date.add(Calendar.DAY_OF_MONTH, dayDifference);
        String returnDateString = simpleDateFormat.format(date.getTime());
        String [] dates = {originDateString, returnDateString};
        return dates;
    }
}
