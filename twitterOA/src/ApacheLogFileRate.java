import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by mia on 9/17/17.
 */
public class ApacheLogFileRate {
    static class CountSuccess{
        public int total;
        public int success;
        public CountSuccess(int t, int s){
            total = t;
            success = s;
        }
    }
    public static void main(String[] args) throws Exception {
        String[] test = new String[2];
//        test[0] = "2016-01-22T03:23:54Z dsa";
//        test[1] = "2016-01-23T03:23:54Z dsa";
        test[0] = "10.10.10.10 - - [27/Sep/2016:05:22:00 +0000] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 500 563 19 \"Twi****\" 177.177.177.177";
        test[1] = "10.10.10.10 - - [27/Sep/2016:05:22:00 +0000] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 200 563 19 \"Twi****\" 177.177.177.177";
        HashMap<String, CountSuccess> map = new HashMap<>();
        for (String t:test
             ) {
            t = t.trim();
//            String time = t.substring(0, t.indexOf('Z')+1);
            getTimeFile(t, map);
        }
        for (String key:map.keySet()
             ) {
            CountSuccess countSuccess = map.get(key);
//            System.out.println(countSuccess.success + " " + countSuccess.total);
            double rate = (double)countSuccess.success/(double) countSuccess.total * 100.0f;
            System.out.println(key + " " + String.format("%.2f", rate));
        }


    }
    static void getTimeFile(String str, HashMap<String, CountSuccess> map) throws Exception{
        String time = str.substring(str.indexOf('[')+1, str.indexOf(']'));
        int idx = str.indexOf("HTTP/1.1");
        String url = str.substring(str.indexOf("GET ")+4, idx-1);
        url = url.substring(0, url.indexOf('?'));
        boolean response = getResponseCode(str, idx);
        String key = dateParser(time)+" "+ url;
        CountSuccess record = null;
        if(map.containsKey(key)){
            record = map.get(key);
        }else{
            record = new CountSuccess(0,0);
        }
        record.total += 1;
        if(response){
            record.success += 1;
        }
        map.put(key, record);
    }

    private static boolean getResponseCode(String str, int idx) {
        int numIdx = str.indexOf('\"', idx+8);
        String number = str.substring(numIdx+1).trim().split(" ")[0];
        return number.charAt(0)=='2';
    }

    static String dateParser(String time) throws Exception{
//        LocalTime l =
//        LocalTime currentTime = LocalTime.now();
//        DateTimeFormatter f = DateTimeFormatter.ISO_DATE_TIME;
//        System.out.println(currentTime);
        //System.out.print(LocalTime.parse(time));
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        System.out.print(dtf.parseLocalDateTime(time));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat dateMatcher = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z", Locale.US);

        Date date =  dateMatcher.parse(time);
        String ans = formatter.format(date);
        return ans;
    }

//        System.out.println(getTimeFile(test));
//        String time = test.substring(test.indexOf('[')+1, test.indexOf(']'));
//        int idx = test.indexOf("HTTP/1.1");
//        String url = test.substring(test.indexOf("GET ")+4, idx-1);
//        int numIdx = test.indexOf('\"', idx+8);
//        String number = test.substring(numIdx+1).trim().split(" ")[0];
//        url = url.substring(0, url.indexOf('?'));
//        System.out.println(dateParser(time));
//        System.out.println(url);
//        System.out.println(number.charAt(0)=='2');
//        System.out.print(dateParser("08/Sep/2015:10:55:15 +0000"));
}
