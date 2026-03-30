class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String each : strs){
            sb.append(each.length()).append('#').append(each);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '#'){
                int l = Integer.parseInt(str.substring(start, i));
                String s = str.substring(i+1,i+l+1);
                list.add(s);
                start = i+l+1;
                i = start;
            }
        }
        return list;
    }
}
