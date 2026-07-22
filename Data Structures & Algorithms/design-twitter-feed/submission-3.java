class Twitter {
    ArrayList<User> users;
    int count;
    Map<Integer, User> map = new HashMap<Integer, User>();
   
    public Twitter() {
        users = new ArrayList();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(map.containsKey(userId)){
            User user = map.get(userId);
            user.tweets.add(new Tweets(tweetId, count++));
          
        } else {
            User user = new User(userId);
            user.tweets.add(new Tweets(tweetId, count++));
            map.put(userId, user);
            this.follow(userId, userId);

            if(user.tweets.size() > 10){
                user.tweets.remove(user.tweets.size() - 1);
            }

        }

        
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
         List<Integer> result = new ArrayList();
           if(map.containsKey(userId)){
              User user = map.get(userId);  
              Set<Integer> followers = user.followers;
              PriorityQueue<Tweets> userTweets = new PriorityQueue<Tweets>((a,b)-> a.count - b.count);
              for(int follower: followers){
                User userFollower = map.get(follower);
                for(Tweets tweet: userFollower.tweets){
                    userTweets.offer(tweet);
                    if(userTweets.size() > 10){
                        userTweets.poll(); 
                    }
                }
              

              }

              while(!userTweets.isEmpty()){
                Tweets tweet = userTweets.poll();
                result.add(tweet.tweetId);
              }

           }  
           Collections.reverse(result);
           return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
         User user;
          if(map.containsKey(followerId)){
            user = map.get(followerId);    
          } else {
            user = new User(followerId);
            map.put(followerId, user);
          }
          user.followers.add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user;
        if(followerId == followeeId){
            return;
        }
         if(map.containsKey(followerId)){
            user = map.get(followerId);    
          } else {
             user = new User(followerId);
          }
          user.followers.remove(followeeId);
    }
}

class User{
    int userId;
    ArrayList<Tweets> tweets; 
    Set<Integer> followers; 

    public User(int userId){
        this.userId = userId;
        tweets = new ArrayList<Tweets>();
        followers = new HashSet<Integer>();
    }
}

class Tweets{
    int tweetId; 
    int count; 

    public Tweets(int tweetId, int count) {

        this.tweetId = tweetId; 
        this.count = count;

    }
}
