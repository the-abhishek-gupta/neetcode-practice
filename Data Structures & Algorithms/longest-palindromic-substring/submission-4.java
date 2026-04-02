class Solution {
    String s;

    public String longestPalindrome(String s) {
        this.s = s;
        int maxLen = 1;
        int start = 0;
        int n = s.length();
        for (int i = 0; i < n; i++){
            int currentLen = findPal(i, i);
            if (currentLen > maxLen){
                maxLen = currentLen;
                start = i - (maxLen - 1) / 2;
            }
        }
        for (int i = 0; i < n-1; i++){
            int currentLen = findPal(i, i+1);
            if (currentLen > maxLen){
                maxLen = currentLen;
                start = i - (maxLen / 2 - 1);
            }
        }
        return s.substring(start, start + maxLen);
    }
    private int findPal(int start, int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }

}
