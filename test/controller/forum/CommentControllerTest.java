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

/**
 *
 * @author Zulfikar
 */
public class CommentControllerTest {
    
    public CommentControllerTest() {
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
     * Test of insertComment method, of class CommentController.
     */
    @Test
    public void testInsertComment() {
        System.out.println("insertComment");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        String commentText = "Test controller comment";
        int userID = 18301264;
        int postID = 1;
        boolean expResult = true;
        boolean result = CommentController.insertComment(parentFrame, parentDialog, commentText, userID, postID);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertReply method, of class CommentController.
     */
    @Test
    public void testInsertReply() {
        System.out.println("insertReply");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        String replyText = "Test controller reply";
        int userID = 18301264;
        int postID = 5;
        int commentID = 1;
        boolean expResult = true;
        boolean result = CommentController.insertReply(parentFrame, parentDialog, replyText, userID, postID, commentID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getReplyCards method, of class CommentController.
     */
    @Test
    public void testGetReplyCards() {
        System.out.println("getReplyCards");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        int userID = 18301264;
        int postID = 7;
        int commentID = 5;
        LinkedList<CommentCard> result = CommentController.getReplyCards(parentFrame, parentDialog, userID, postID, commentID);
        assertNotEquals(null, result);
    }
    
}
