class Twitter {

    private int timestamp = 0;
    class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id){
            this.id = id;
            this.time = timestamp++;
        }
    }
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!followMap.containsKey(userId)){
            return res;
        }
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        for(int followee : followMap.get(userId)){
            if(tweetMap.containsKey(followee)){
                maxHeap.offer(tweetMap.get(followee));
            } 
        }
        int count = 0;
        while(!maxHeap.isEmpty() && count < 10){
            Tweet tweet = maxHeap.poll();
            res.add(tweet.id);
            count++;
            if(tweet.next != null){
                maxHeap.offer(tweet.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followerId);
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followerId != followeeId){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
