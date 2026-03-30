class Twitter {

    int time;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;


    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, x-> new ArrayList<>()).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feedList = new ArrayList<>();
        feedList.addAll(tweetMap.getOrDefault(userId, new ArrayList<>()));
        
        for (int user : followMap.getOrDefault(userId, new HashSet<>())){
            feedList.addAll(tweetMap.getOrDefault(user, new ArrayList<>()));
        }
        feedList.sort((a,b)-> b[0] - a[0]);

        List<Integer> ans = new ArrayList<>();
        for (int[] each : feedList)
            if (ans.size() < 10)
                ans.add(each[1]);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        followMap.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
