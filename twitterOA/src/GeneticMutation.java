import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by mia on 9/18/17.
 */
public class GeneticMutation {
//version zero
    //base on BFS search with distance 1 in bank, need to convert bank as hashset and use iterator to get next, and delete;
    public int minMutation(String start, String end, String[] bank) {
        int diffStartEnd = calculateDiff(start, end);
        if(diffStartEnd == 0){
            return 0;
        }
        if( diffStartEnd > bank.length ){
            return -1;
        }
        HashSet<String> sBank = new HashSet<String>();
        for(int i = 0; i < bank.length; i++){
            sBank.add(bank[i]);
        }
        int level = 0;
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(start);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i ++){
                String str = queue.poll();
                if(str.equals(end)){
                    return level;
                }
                if(sBank.isEmpty()){continue;}
                for(Iterator<String> itr = sBank.iterator(); itr.hasNext();){//use iterator to delete visited candidate
                    String candidate = itr.next();
                    if(calculateDiff(str, candidate) == 1){
                        queue.add(candidate);
                        itr.remove();
                    }
                }

            }
            level++;
        }

        return -1;
    }
    public int calculateDiff(String start, String end){
        int diff = 0;
        for(int i = 0; i < start.length(); i ++){
            if( (start.charAt(i) - end.charAt(i)) != 0 ){
                diff+=1;
            }
        }
        return diff;
    }

    //version two: two-end search with 8*4 constant time change to get distance 1 candidate

    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
            for(int i = 0; i < bank.length; i ++){
                visited.put(bank[i], true);
            }
            int level = 0;
            HashSet<String> q1 = new HashSet<String>();
            q1.add(start);
            if(visited.get(start)!=null){
                visited.put(start, false);
            }
            HashSet<String> q2 = new HashSet<String>();
            q2.add(end);
            if(visited.get(end)==null){
                return -1;
            }
            visited.put(end, false);
            while(!q1.isEmpty()){
                if(q1.size()>q2.size()){
                    HashSet<String> tmp = q1;
                    q1 = q2;
                    q2 = tmp;
                }
                level ++;
                HashSet<String> qn = new HashSet<String>();
                for(String str : q1){
                    for(int k = 0; k < 8; k++){
                        for(char c : "ACGT".toCharArray()){
                            if(c == str.charAt(k)){
                                continue;
                            }
                            String newStr = str.substring(0, k) + c + str.substring(k+1, 8);
                            if(q2.contains(newStr)){
                                return level;
                            }
                            if(visited.get(newStr)==null || !visited.get(newStr)){//null || false
                                continue;
                            }
                            visited.put(newStr, false);
                            qn.add(newStr);
                        }
                    }
                }
                q1 = qn;
            }
            return -1;
        }
    }
}

