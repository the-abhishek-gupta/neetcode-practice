class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String each : strs){
            String key = sortedChars(each);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(each);
            map.put(key, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> each : map.values())
            ans.add(each);
        return ans;
    }
    String sortedChars(String str){
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for (char c : arr)
            sb.append(c);
        return sb.toString();
    }
}
