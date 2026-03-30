class Solution {
    int maxLeft = 0, maxRight = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++)
            findPal(s, i, i);
        for (int i = 0; i < s.length()-1; i++)
            findPal(s, i, i+1);
        return s.substring(maxLeft, maxRight+1);
    }
    void findPal(String word, int start, int end){
        while(start>=0 && end < word.length() && word.charAt(start) == word.charAt(end)){
            if (maxRight - maxLeft < end - start){
            maxLeft = start;
            maxRight = end;
        }
            start--;
            end++;
        }
        
    }
}
