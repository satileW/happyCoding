class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0){ return 0;}
        HashSet<Character> nonRepeated = new HashSet<Character>();
        char[] c = s.toCharArray();
        int i =0, j = 0, max = 1;
        while(j < s.length()){
            if(!nonRepeated.contains(c[j])){
                nonRepeated.add(c[j++]);
                max = Math.max(max, nonRepeated.size());
            }else{
                //remove the characters until the next position of same character with c[j]
                nonRepeated.remove(c[i++]);
            }
        }
        return max;
    }

    //use hashmap to update the start index, and calculate length every time
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0){ return 0;}
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 1, i, j;
        char[] c = s.toCharArray();
        for( i =0, j =0; j < c.length; j++){
            if(map.containsKey(c[j])){
                i = Math.max( i, map.get(c[j])+1 );
            }
            max = Math.max(max, j-i+1);
            map.put(c[j], j);
        }
        return max;
    }
}