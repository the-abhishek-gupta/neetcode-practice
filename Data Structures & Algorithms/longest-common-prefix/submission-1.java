class Solution {
    public String longestCommonPrefix(String[] strs) {
        int maxLength = Integer.MAX_VALUE;
        for (String each : strs)
            maxLength = Math.min(maxLength, each.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++){
            boolean flag = true;
            for (String each : strs){
                if (each.charAt(i) != strs[0].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (flag == false)
                break;
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}