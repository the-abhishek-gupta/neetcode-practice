class Solution {
    Map<String, String> ownerMap = new HashMap<>();
    Map<String, String> emailsMap = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> list : accounts){
            String owner = list.get(0);
            String leader = list.get(1);
            for (int i = 1; i < list.size(); i++){
                String email = list.get(i);
                ownerMap.put(email, owner);
                union(leader, email);
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String each : ownerMap.keySet()){
            String leader = find(each);
            map.computeIfAbsent(leader, x -> new ArrayList<>()).add(each);
        }
        System.out.println(map);
        List<List<String>> ans = new ArrayList<>();
        for (String leader : map.keySet()){
            List<String> list = map.get(leader);
            List<String> temp = new ArrayList<>();
            temp.add(ownerMap.get(leader));
            temp.addAll(list);
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
    private void union(String a, String b){
        String parentA = find(a);
        String parentB = find(b);
        if (!parentA.equals(parentB)){
            emailsMap.put(parentB, parentA);
        }
    }
    private String find(String x){
        emailsMap.putIfAbsent(x, x);
        if (!emailsMap.get(x).equals(x)){
            emailsMap.put(x, find(emailsMap.get(x)));
        }
        return emailsMap.get(x);
    }
}