class Solution {
    class Pair{
        String word;
        int dist;
        Pair(String s, int d){
            this.word = s;
            this.dist = d;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                String w1 = wordList.get(i);
                String w2 = wordList.get(j);
                if (diff(w1, w2) == 1){
                    map.computeIfAbsent(w1, x -> new ArrayList<>()).add(w2);
                    map.computeIfAbsent(w2, x -> new ArrayList<>()).add(w1);
                }
            }
        }
        for (String each : wordList){
            if (diff(beginWord, each) == 1){
                map.computeIfAbsent(beginWord, x -> new ArrayList<>()).add(each);
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            String word = pair.word;
            int distance = pair.dist;
            if (word.equals(endWord))
                return distance;
            for (String next : map.getOrDefault(word, new ArrayList<>())){
                if (visited.contains(next))
                    continue;
                visited.add(next);
                queue.offer(new Pair(next, distance+1));
            }
        }
        return 0;
    }
    private int diff(String w1, String w2){
        int ct = 0;
        if (w1.length() != w2.length())
            return 2;
        for (int i = 0; i < w1.length(); i++){
            if (w1.charAt(i) != w2.charAt(i))
                ct++;
        }
        return ct;
    }
}
