package com.olawale.myreddit.Utility;
import java.util.ArrayList;
import java.util.List;
 
import org.json.JSONArray;
import org.json.JSONObject;
 
import android.util.Log;
import net.dean.jraw.paginators.*;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.Subreddit;
import net.dean.jraw.paginators.SubmissionSearchPaginator;
import net.dean.jraw.paginators.SubredditPaginator;

/**
	 * This is the class that creates Post objects out of the Reddit
	 * API, and maintains a list of these posts for other classes
	 * to use.
	 *
	 * @author Hathy
	 */
	public class PostsHolder {
	         
	    /**
	     * We will be fetching JSON data from the API.
	     */
        private static UserAgent myUserAgent;

        String url;
	    String after;
	     
	    public PostsHolder(UserAgent sr){
	        myUserAgent=sr;
	    }
	     
	    /**
	     * Generates the actual URL from the template based on the
	     * subreddit name and the 'after' property.
	     */

	    /**
	     * Returns a list of Post objects after fetching data from
	     * Reddit using the JSON API.
	     *
	     * @return
	     */
	    public List<Post> fetchPosts(){

            RedditClient client =   new RedditClient(myUserAgent);
	        List<Post> list=new ArrayList<Post>();
            Post post = new Post();
            for (Submission link : new SubredditPaginator(client).next()) {

              post.title = link.getTitle();
                post.author = link.getAuthor();
                post.numComments = link.getCommentCount();
                post.points = link.getScore();
                post.permalink = link.getPermalink();
                post.id = link.getSubredditId();
                post.domain = link.getDomain();
                post.url = link.getUrl();

	        }
	        return list;
	    }
	     
	    /**
	     * This is to fetch the next set of posts
	     * using the 'after' property
	     * @return
	     */
	    List<Post> fetchMorePosts(){
	        return fetchPosts();
	    }

}
