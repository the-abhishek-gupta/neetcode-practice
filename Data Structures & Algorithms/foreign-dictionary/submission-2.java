class Solution {
    public String foreignDictionary(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        Map<Character, Set<Character>> map = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (arr[c - 'a'] == -1)
                    arr[c - 'a'] = 0;
            }
        }
        for (int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            
            int index = getDiff(w1, w2);
            if (index == -1)
                return "";
            if (index == 101)
                continue;
            char c1 = w1.charAt(index);
            char c2 = w2.charAt(index);
            
            map.putIfAbsent(c1, new HashSet<>());
            if (!map.get(c1).contains(c2)) {
                map.get(c1).add(c2);
                arr[c2 - 'a']++;
            }
            
        }
        Queue<Character> queue = new LinkedList<>();
        int totalChars = 0;
        for (int i = 0; i < 26; i++){
            if (arr[i] != -1) {
                totalChars++;
                if (arr[i] == 0)
                queue.offer((char)('a'+ i));
            }
            
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for (char ch : map.getOrDefault(c, new HashSet<>())){
                arr[ch-'a']--;
                if (arr[ch-'a'] == 0)
                    queue.offer(ch);
            }
        }
        if (sb.length() != totalChars)
            return "";

        return sb.toString();
    }
    private int getDiff(String w1, String w2){
        int i = 0;
        for (; i < Math.min(w1.length(), w2.length()); i++)
            if (w1.charAt(i) != w2.charAt(i))
                return i;
        
        if (w1.length() > w2.length())
            return -1;
        return 101;
    }
}
