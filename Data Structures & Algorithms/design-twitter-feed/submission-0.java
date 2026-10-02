class Twitter {
    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> following;
    int time;
    class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) ->
        b.time - a.time);
        if(tweets.containsKey(userId))
            pq.addAll(tweets.get(userId));
        if(following.containsKey(userId)) {
            for(int followee: following.get(userId)) {
                if(tweets.containsKey(userId))
                    pq.addAll(tweets.get(followee));
            }
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while(!pq.isEmpty() && count < 10) {
            result.add(pq.poll().tweetId);
            count++;
        }  
        return result;  
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
