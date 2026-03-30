class Solution {
    public int countSubstrings(String s) {
        int ct = 0;
        for (int i = 0; i < s.length(); i++)
            ct += checkPal(s,i, i);
        for (int i = 0; i < s.length()-1; i++)
            ct += checkPal(s,i, i+1);
        return ct;
    }
    int checkPal(String s, int start, int end){
        int ct = 0;
        while (start>=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            ct++;
        }
        System.out.println(start+" "+end);
        return ct;
    }
}
