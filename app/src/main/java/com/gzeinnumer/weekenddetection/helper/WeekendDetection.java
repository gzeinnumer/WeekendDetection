package com.gzeinnumer.weekenddetection.helper;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeekendDetection {

    public static ArrayList<String> getDateRangeNoWeekend(ArrayList<String> weekend, String start_date, String end_date) {
        ArrayList<String> res = getDateRange(start_date, end_date);

        for (int i = 0; i < weekend.size(); i++) {
            res.remove(weekend.get(i));
        }

        return res;
    }

    public static ArrayList<String> getDateRange(String start_date, String end_date) {
        ArrayList<String> res = new ArrayList<>();

        try {
            @SuppressLint("SimpleDateFormat")
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date startDate= formatter.parse(start_date);
            Date endDate= formatter.parse(end_date);

            List<Date> dates = new ArrayList<>();

            long interval = 24 * 1000 * 60 * 60;
            long endTime = endDate != null ? endDate.getTime() : 0;
            long curTime = startDate != null ? startDate.getTime() : 0;
            while (curTime <= endTime) {
                dates.add(new Date(curTime));
                curTime += interval;
            }
            for (int i = 0; i < dates.size(); i++) {
                String result = formatter.format(dates.get(i));
                res.add(result);
            }
            return res;

        } catch (ParseException e) {
            e.printStackTrace();
            return res;
        }
    }
}
