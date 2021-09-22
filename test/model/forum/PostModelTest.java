/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.forum;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.forum.CommentCard;
import view.forum.PostCard;

/**
 *
 * @author Zulfikar
 */
public class PostModelTest {
    
    public PostModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertPost method, of class PostModel.
     */
    @Test
    public void testInsertPost() {
        System.out.println("insertPost");
        int userID = 18301264;
        String postText = "Test Post";
        String tags = "Nothing";
        boolean result = PostModel.insertPost(userID, postText, tags);
        if (!result) fail("Inserting post method not working");
    }

    /**
     * Test of getPostCards method, of class PostModel.
     */
    @Test
    public void testGetPostCards_int() {
        System.out.println("getPostCards");
        int page = 0;
        LinkedList<PostCard> result = PostModel.getPostCards(page);
        if (result == null) fail("Get post cards with only page method not working.");
    }

    /**
     * Test of getPostCards method, of class PostModel.
     */
    @Test
    public void testGetPostCards_5args() {
        System.out.println("getPostCards");
        String userID = "18301264";
        String userName = "Mohammed Julfikar Ali Mahbub";
        String date = "";
        String tag = "";
        int page = 0;
        LinkedList<PostCard> result = PostModel.getPostCards(userID, userName, date, tag, page);
        if (result == null) fail("Get post cards with 5 args method not working.");
    }

    /**
     * Test of getPostCards method, of class PostModel.
     */
    @Test
    public void testGetPostCards_String() {
        System.out.println("getPostCards");
        String loadPostQuery = "SELECT * FROM post join student ON std_id = student_id WHERE std_id = '18301264'";
        LinkedList<PostCard> result = PostModel.getPostCards(loadPostQuery);
        if (result == null) fail("Get post card with query method not working.");
    }

    /**
     * Test of getCommentCards method, of class PostModel.
     */
    @Test
    public void testGetCommentCards() {
        System.out.println("getCommentCards");
        int userID = 18301264;
        int postID = 0;
        LinkedList<CommentCard> result = PostModel.getCommentCards(userID, postID);
        if (result == null) fail("Get comment cards method not working properly.");
    }
    
}
