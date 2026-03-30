class Solution {
    Map<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), digits, 0);
        return ans;
    }
    void dfs(List<String> ans, StringBuilder sb, String digits, int index){
        if (index >= digits.length()){
            if (sb.length()>0)
                ans.add(sb.toString());
            return;
        }
        int n = digits.charAt(index) - '0';
        char[] ch = map.get(n).toCharArray();
        for (char c : ch){
            sb.append(c);
            dfs(ans, sb, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
