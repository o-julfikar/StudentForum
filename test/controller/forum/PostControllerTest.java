/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.forum;

import java.awt.Dialog;
import java.awt.Frame;
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
public class PostControllerTest {
    
    public PostControllerTest() {
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
     * Test of insertPost method, of class PostController.
     */
    @Test
    public void testInsertPost() {
        System.out.println("insertPost");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        int userID = 18301264;
        String postText = "Test controller post";
        String tags = "";
        boolean expResult = true;
        boolean result = PostController.insertPost(parentFrame, parentDialog, userID, postText, tags);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostCards method, of class PostController.
     */
    @Test
    public void testGetPostCards_Frame_Dialog() {
        System.out.println("getPostCards");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        LinkedList<PostCard> result = PostController.getPostCards(parentFrame, parentDialog);
        assertNotEquals(null, result);
    }

    /**
     * Test of getCommentCards method, of class PostController.
     */
    @Test
    public void testGetCommentCards() {
        System.out.println("getCommentCards");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        int userID = 18301264;
        int postID = 1;
        LinkedList<CommentCard> result = PostController.getCommentCards(parentFrame, parentDialog, userID, postID);
        assertNotEquals(null, result);
    }
    
}
