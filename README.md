# WeekendDetection

```java
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

```
```java
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
```


---

```
Copyright 2022 M. Fadli Zein
```
