package hard;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s==null || s.length()==0 || t==null || t.length()==0)
            return "";
        if(s.length()<t.length())
            return "";
        int[] map = new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int start=0, end=0, counter=t.length(), minLength = Integer.MAX_VALUE, minStart =0;

        while(end<s.length()){
            if(map[s.charAt(end)] > 0) {
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while(counter==0){
                if(minLength>end-start){
                    minLength = end-start;
                    minStart = start;
                }
                map[s.charAt(start)]++;
                if(map[s.charAt(start)] > 0){
                    counter++;
                }
                start++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLength);
    }
}
