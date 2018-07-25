import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import com.datastax.*;

public class TwitterTags {
	
    public static void main(String[] args) throws TwitterException {
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
  	    .setOAuthConsumerKey("ILgbiUejOMe3oaYCqpQASA4s0")
  	    .setOAuthConsumerSecret("4psVrWjrodrN8Xkj9DLgJ4QQ75DGkP174qEY2qxfDQLVWlgYHC")
        .setOAuthAccessToken("1020465508792053760-8OtXa4SFI96MZEbcMzuGmuTmAA7fsh")
  	    .setOAuthAccessTokenSecret("L9mSIhxqB7gxzbiffaQwoRnwbiFkWp4rOB32MoxlQHsDG");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	String[] hashtags = {"#japao", "#japan", "#japao2020", "#japan2020", "#jogosolimpicos",
    			"#olimpiadas", "#olimpiadas2020", "#olympics", "#tokyo2020", "#tokyo"};
    	
  		for (String tag : hashtags) {
    		
  			Query query = new Query(tag);
  			//query.count(100);
  			QueryResult result = twitter.search(query);
       
  			for (Status status : result.getTweets()) {
  				System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
  			}
  		}
  		
 	   final CassandraConnector client = new CassandraConnector();
 	   final String ipAddress = args.length > 0 ? args[0] : "127.0.0.1";
 	   final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
 	   System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
 	   client.connect(ipAddress, port);
 	   client.close();
    }
    	
    	
}