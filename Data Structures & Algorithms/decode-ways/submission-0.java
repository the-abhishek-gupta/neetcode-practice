class Solution {
    public int numDecodings(String s) {
        if (s.length()== 0)
            return 1;
        int sCh = s.charAt(0) - '0';
        if (sCh == 0)
            return 0;
        int ct = 0;
        if (sCh == 1 && s.length()> 1){
            ct += numDecodings(s.substring(2));
        }
        
        if (sCh == 2 && s.length()> 1){
            int sCh2 = s.charAt(1) - '0';
            if (sCh2 < 7)
                ct += numDecodings(s.substring(2));
        }
        
        ct += numDecodings(s.substring(1));
        return ct;
    }
}
