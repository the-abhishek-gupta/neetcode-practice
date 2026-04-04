class Solution {
    List<String> wordDict;
    Boolean[] memo ;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        memo = new Boolean[s.length()];
        return wordBreak(s, 0);
    }
    private boolean wordBreak(String s, int index){
        if (index == s.length())
            return true;
        if (memo[index] != null)
            return memo[index];
        
        for (String word : wordDict){
            if (s.startsWith(word, index) && wordBreak(s, index + word.length()))
                return memo[index] = true;
        }
        
        return memo[index] = false;
    }
}
