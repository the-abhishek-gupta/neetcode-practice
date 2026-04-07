class Solution {
    Map<Integer, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n==0)
            return ans;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs(digits, 0, new char[digits.length()]);
        return ans;
    }
    private void dfs(String digits, int index, char[] arr){
        if (index == digits.length()){
            ans.add(new String(arr));
            return;
        }
        char character = digits.charAt(index);
        for (char c : map.getOrDefault( character - '0', "").toCharArray()){
            arr[index] = c;
            dfs(digits, index+1, arr);
            arr[index] = '.';
        }
    }
}
