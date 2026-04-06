class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int ans = 0;
        int start = 0;
        int maxFrequency = 0;
        for (int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));

            while (end - start + 1 - maxFrequency > k){
                char prevChar = s.charAt(start);
                map.put(prevChar, map.get(prevChar) - 1);
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }
}
