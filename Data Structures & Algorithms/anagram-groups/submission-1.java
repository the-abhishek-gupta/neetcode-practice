class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String each : strs){
            String ana = getAnagram(each);
            System.out.println(each+ " "+ ana);
            map.computeIfAbsent(ana, x -> new ArrayList<>()).add(each);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> each : map.values())
            ans.add(each);
        return ans;
    }
    private String getAnagram(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (char each:arr)
            sb.append(each);
        return sb.toString();
    }
}
