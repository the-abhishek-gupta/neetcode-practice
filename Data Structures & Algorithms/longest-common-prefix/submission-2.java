class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String each : strs)
            min = Math.min(min, each.length());
        int maxLen = -1;
        for (int i = 0; i < min; i++){
            boolean flag = true;
            for (String each : strs){
                if (each.charAt(i) != strs[0].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
            maxLen = i;
        }
        return strs[0].substring(0, maxLen+1);
    }
}