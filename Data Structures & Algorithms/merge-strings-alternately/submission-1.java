class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, w1n = word1.length(), w2n = word2.length();
        StringBuilder sb = new StringBuilder();
        while (i < w1n && j < w2n){
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        } 
        sb.append(word1.substring(i)).append(word2.substring(j));
        return sb.toString();
    }
}