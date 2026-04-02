class Solution {
    public int countSubstrings(String s) {
        int ct = 0;
        for (int i = 0; i< s.length(); i++){
            ct += findPal(s, i, i);
            ct += findPal(s, i, i+1);
        }
        return ct;
    }
    private int findPal(String word, int start, int end){
        int ct =0;
        while (start >= 0 && end < word.length() && word.charAt(start) == word.charAt(end)){
            start--;
            end++;
            ct++;
        }
        return ct;
    }
}
