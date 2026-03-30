class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0)+1);
        
        Map<Integer, List<Integer>> revMap = new HashMap<>();
        for (int key : map.keySet()){
            revMap.putIfAbsent(map.get(key), new ArrayList<>());
            revMap.get(map.get(key)).add(key);
        }
        Map<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(revMap);
        // System.out.println(treeMap);
        int index = 0;
        int[] ans = new int[k];
        for (List<Integer> key : treeMap.values()){
            for (int each : key){
                ans[index++] = each;
                if (index == k)
                    return ans;
            }
        }
        return new int[]{};
    }
}
