import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mia on 9/17/17.
 */
public class SearchLogFile {

    public static void main(String[] args) {

    }
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        List<String> logLine = (List<String>)logLines;
        List<String> ans = new ArrayList<String>();
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        //System.out.println(startDate);
        for(int i = 0; i < logLine.size(); i++){
            StringBuilder sb = new StringBuilder(logLine.get(i));
            String time = getTime(logLine, i);
            if(time.length()<20){
                continue;
            }
            LocalTime date = dateParser(time);
            if(date.equals(startDate) || (date.isAfter(startDate) && date.isBefore(endDate))){
                int idx = i;
                while(getTime(logLine, ++idx).length()<20){
                    sb.append("\n");
                    sb.append(logLine.get(idx));
                }
                ans.add(sb.toString());
                i = --idx;
            }
        }
        return ans;
    }
    String getTime(List<String> logLines, int i){
        String line = logLines.get(i);
        line = line.trim();
        return line.substring(0, line.indexOf('Z')+1);
    }
    LocalTime dateParser(String time){
        String localTime = time.substring(time.indexOf('T')+1, time.indexOf('Z'));
        return LocalTime.parse(localTime);
    }

}
