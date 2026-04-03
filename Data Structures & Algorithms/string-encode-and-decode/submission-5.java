class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '#'){
                int len = Integer.parseInt(str.substring(start, i));
                String s = str.substring(i+1, i+1 + len);
                ans.add(s);
                start = i+1 + len;
                i = start;
            }
        }
        return ans;
    }
}
