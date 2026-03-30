class Solution {
    String s;
    public String longestPalindrome(String s) {
        this.s = s;
        String max = "";
        for (int i = 0; i < s.length(); i++){
            int t = checkPal(i,i);
            if (2 *t - 1 > max.length())
                max = s.substring(i+1-t, i+t);
        }

        for (int i = 0; i < s.length()-1; i++){
            int t = checkPal(i,i+1);
            if (2*t > max.length())
                max = s.substring(i+1-t, i+1+t);
        }
        return max;
    }
    int checkPal(int start, int end){
        int k = 0;
        while (start >= 0 && end < s.length()){
            if (s.charAt(start) == s.charAt(end))
                k++;
            else
                break;
            start--;
            end++;
        }
        return k;
    }
}
