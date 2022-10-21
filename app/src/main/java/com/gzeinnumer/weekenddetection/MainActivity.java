package com.gzeinnumer.weekenddetection;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.weekenddetection.helper.WeekendDetection;

import java.util.ArrayList;

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
    }

    private static final String TAG = "asdsafasfasdada";


}