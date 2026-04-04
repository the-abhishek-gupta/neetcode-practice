class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        if (map.containsKey(s))
            return map.get(s);
        if (s.length() == 0)
            return 1;
        int c = s.charAt(0) - '0';
        if (c == 0)
            return 0;

        int ct = numDecodings(s.substring(1));
        if (c == 1 && s.length() > 1){
            ct += numDecodings(s.substring(2));
        }
        else if (c == 2 && s.length() > 1 && (s.charAt(1)-'0' < 7))
            ct += numDecodings(s.substring(2));
        map.put(s, ct);
        return ct ;
    }
}
