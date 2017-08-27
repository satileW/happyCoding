class ZigZagString{
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        int len = s.length();
        char[] c = s.toCharArray();
        int i = 0;
        for(int k = 0; k < numRows; k++){ sb[k] = new StringBuilder();}
        while(i < len){
            for(int index = 0; index < numRows && i < len; index++){//vertical down
                sb[index].append(c[i++]);
            }

            for(int index = numRows-2; index > 0 && i < len; index --){//oblique
                sb[index].append(c[i++]);
            }
        }
        for(i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}