class Solution {
    class Pair{
        String node;
        double value;
        Pair(String s, double d){
            this.node = s;
            this.value =d;
        }
    }
    Map<String, List<Pair>> map ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.map = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++){
            List<String> l = equations.get(i);
            String up = l.get(0);
            String down = l.get(1);
            double val = values[i];
            map.computeIfAbsent(up, x -> new ArrayList<Pair>()).add(new Pair(down, val));
            map.computeIfAbsent(down, x -> new ArrayList<Pair>()).add(new Pair(up, 1.0 /val));
        }
        n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; i++){
            ans[i] = fetch(queries.get(i));
        }
        return ans;
    }
    private double fetch(List<String> query){
        String from = query.get(0);
        String to = query.get(1);
        if (!map.containsKey(from) || !map.containsKey(to)) return -1.0;
        if (from.equals(to)) return 1.0;

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair(from, 1.0));
        visited.add(from);

        while (!queue.isEmpty()){
            Pair p = queue.poll();
            String node = p.node;
            double value = p.value;

            if (node.equals(to))
                return value;
            for (Pair next : map.getOrDefault(node, new ArrayList<>())){
                String nextNode = next.node;
                double nextVal = next.value;

                if (visited.contains(nextNode))
                    continue;
                visited.add(nextNode);
                queue.offer(new Pair(nextNode, value * nextVal));
            }
        }
        return -1.0;
    }
}