class Twitter {

    private boolean[][] follows;
    private PriorityQueue<Integer> feed;
    private HashMap<Integer, Integer> timeToUser;
    private HashMap<Integer, Integer> timeToTweet;
    private int time;

    public Twitter() {
        follows = new boolean[501][501];
        feed = new PriorityQueue<Integer>(Collections.reverseOrder());
        timeToUser = new HashMap<Integer, Integer>();
        timeToTweet = new HashMap<Integer, Integer>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeToTweet.put(time, tweetId);
        feed.offer(time);
        timeToUser.put(time, userId);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<Integer> seen = new LinkedList<Integer>();
        List<Integer> news = new ArrayList<>();
        while (news.size() < 10 && !feed.isEmpty()){
            int current = feed.poll();
            int user = timeToUser.get(current);
            if (follows[userId][user] || user == userId) news.add(timeToTweet.get(current));
            seen.offer(current);
        }
        while (!seen.isEmpty()){
            int current = seen.remove();
            feed.offer(current);
        }
        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        follows[followerId][followeeId] = true;        
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows[followerId][followeeId] = false;
    }
}
