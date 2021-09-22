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

/**
 *
 * @author Zulfikar
 */
public class CommentModelTest {
    
    public CommentModelTest() {
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
     * Test of insertComment method, of class CommentModel.
     */
    @Test
    public void testInsertComment() {
        System.out.println("insertComment");
        String commentText = "Test Comment";
        int userID = 18301264;
        int postID = 0;
        boolean result = CommentModel.insertComment(commentText, userID, postID);
        if (!result) fail ("Failed to insert comment");
    }

    /**
     * Test of insertReply method, of class CommentModel.
     */
    @Test
    public void testInsertReply() {
        System.out.println("insertReply");
        String replyText = "Test Reply";
        int userID = 18301264;
        int postID = 5;
        int commentID = 1;
        boolean result = CommentModel.insertReply(replyText, userID, postID, commentID);
        if (!result) {
            
        }
    }

    /**
     * Test of deleteComment method, of class CommentModel.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("deleteComment");
        int commentID = 17;
        boolean result = CommentModel.deleteComment(commentID);
        if (!result) {
            fail("Failed to delete the comment");
        }
    }

    /**
     * Test of getReplyCards method, of class CommentModel.
     */
    @Test
    public void testGetReplyCards() {
        System.out.println("getReplyCards");
        int userID = 18301264;
        int postID = 0;
        int commentID = 1;
        LinkedList<CommentCard> result = CommentModel.getReplyCards(userID, postID, commentID);
        if (result == null) fail("Failed to get replies");
    }
    
}
