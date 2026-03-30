class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        System.out.println(map);
        List<int[]> order = new ArrayList<>();
        for (char each : map.keySet()){
            List<Integer> val = map.get(each);
            order.add(new int[]{val.get(0), val.get(val.size()-1)});
        }
        Collections.sort(order, (a,b)-> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        for (int[] c : order){
            if (!stack.isEmpty()){
                int[] top = stack.peek();
                if (top[1] > c[0]){
                    stack.pop();
                    c[0] = Math.min(c[0], top[0]);
                    c[1] = Math.max(c[1], top[1]);
                }
            }
            stack.push(c);
        }
        List<Integer> l2 = new ArrayList<>();
        while (!stack.isEmpty()){
            int[] c =  stack.pop();
            System.out.println(c[0]+" "+c[1]);
            l2.add(0, c[1] - c[0] + 1);
        }
        return l2;
    }
}
