package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(longestPalindrome_best("abbaccc"));
        System.out.println(longestPalindrome_best("abcddcba"));
    }
    /*
    summary about some problem in dp solution but final just use constant space
    for same reason: because result can be derectly get from state and states are
    update from small area to big area or from big to small (one direction)
    and the process don't have repeated state value will be reused

    for this kind of question, max length is recorded by
    start index and end index. And final result can be updated by
    states changing
     */
    public static String longestPalindrome_best(String s) {
        int start = 0, end =0;
        for(int i = 0; i < s.length()-1; i++){
            //two ways to extend the palindromic string
            //one is use s.charAt(i) as middle char of 2*n+1
            int len1 = extendPalindrimicSubtring(s, i, i);
            int len2 = 1;
            if(s.charAt(i) == s.charAt(i+1)){
                //one is use empyty space between s.charAt(i) and s.charAt(i+1) as middle of 2*n
                len2 = extendPalindrimicSubtring(s, i, i+1);
            }
            len1 = Math.max(len1, len2);//compare the length of new middle index with max length we have
            if(len1 > (end - start + 1)){
                start = i - (len1 - 1)/2;
                end = i + len1/2;
            }
        }
        return s.substring(start, end+1);
    }
    static int extendPalindrimicSubtring(String str, int left, int right){
        while(left-1 >= 0 && right+1 < str.length()&& str.charAt(left-1)==str.charAt(right+1)){
            left--;
            right++;
        }
        return right - left + 1;
    }

}
