class Solution {
    String s,t;
    int ct;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        this.ct = 0;
        dfs(0, 0);
        return ct;
    }
    void dfs(int i, int j){
        if (j == t.length()){
            ct++;
            return;
        }
        if (i == s.length())
            return;
        if (s.charAt(i) == t.charAt(j))
            dfs(i+1, j+1);
        dfs(i+1, j);
    }
}
