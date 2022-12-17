package com.gzeinnumer.weekenddetection;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.weekenddetection.helper.WeekendDetection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String start_date = "2022-10-01";
        String end_date = "2022-10-30";

        ArrayList<String> dateRange = WeekendDetection.getDateRange(start_date, end_date);
        Log.d(TAG, "all: " + dateRange);

        ArrayList<String> weekend = new ArrayList<>();

        weekend.add("2022-10-01");
        weekend.add("2022-10-02");
        weekend.add("2022-10-08");
        weekend.add("2022-10-09");
        weekend.add("2022-10-15");
        weekend.add("2022-10-16");
        weekend.add("2022-10-22");
        weekend.add("2022-10-23");
        weekend.add("2022-10-29");
        weekend.add("2022-10-30");

        ArrayList<String> dateNoWeekend = WeekendDetection.getDateRangeNoWeekend(weekend, start_date, end_date);
        Log.d(TAG, "libur: " + dateNoWeekend);

        countWeekenInDate();
    }

    private void countWeekenInDate() {
        String _3daysBefore = getCalculatedDate("yyyy-MM-dd", -4);
        String today = getDateYMD();

        int countWeekend = countWeekend(_3daysBefore, today);
    }

    private static final String TAG = "asdsafasfasdada";

    public int countWeekend(String start_date, String end_date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int count = 0;
        try {
            Date d1 = formatter.parse(start_date);
            Date d2 = formatter.parse(end_date);
            count = saturdaysundaycount(d1,d2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return count;
    }



    public int saturdaysundaycount(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int sundays = 0;
        int saturday = 0;

        while (! c1.after(c2)) {
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ){
                saturday++;
            }
            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                sundays++;
            }

            c1.add(Calendar.DATE, 1);
        }

        System.out.println("Saturday Count = "+saturday);
        System.out.println("Sunday Count = "+sundays);
        return saturday + sundays;
    }

    public String getDateYMD() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public String getCalculatedDate(String dateFormat, int days) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat(dateFormat);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return s.format(new Date(cal.getTimeInMillis()));
    }
}