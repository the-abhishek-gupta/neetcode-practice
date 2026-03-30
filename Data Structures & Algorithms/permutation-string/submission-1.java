class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0)+1);
            
            if (i >= s1.length()){
                c = s2.charAt(i-s1.length());
                int val = map2.getOrDefault(c, 0)-1;
                if (val == 0)
                    map2.remove(c);
                else
                    map2.put(c, val);
            }
            if (map.equals(map2))
                return true;

        }
        return false;
    }
}
