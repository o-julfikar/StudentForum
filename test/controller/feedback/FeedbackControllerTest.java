/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.feedback;

import controller.swap.Course;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.feedback.FeedbackCard;
import view.feedback.ReviewCard;

/**
 *
 * @author Zulfikar
 */
public class FeedbackControllerTest {
    
    public FeedbackControllerTest() {
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
     * Test of getReviewPoint method, of class FeedbackController.
     */
    @Test
    public void testGetReviewPoint() {
        System.out.println("getReviewPoint");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        String facultyInitial = "AHN";
        double expResult = 3.3;
        double result = FeedbackController.getReviewPoint(parentFrame, parentDialog, facultyInitial);
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getReviewCards method, of class FeedbackController.
     */
    @Test
    public void testGetReviewCards() {
        System.out.println("getReviewCards");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        String facultyInitial = "AHN";
        LinkedList<ReviewCard> result = FeedbackController.getReviewCards(parentFrame, parentDialog, facultyInitial);
        assertNotEquals(null, result);
    }

    /**
     * Test of insertFeedback method, of class FeedbackController.
     */
    @Test
    public void testInsertFeedback() {
        System.out.println("insertFeedback");
        Dialog parentDialog = null;
        int userID = 18301159;
        String facultyInitial = "AND";
        Course course = new Course("CSE110", "Programming Language I");
        String feedbackString = "This is pure testing";
        double point = 2.0;
        boolean expResult = true;
        boolean result = FeedbackController.insertFeedback(parentDialog, userID, facultyInitial, course, feedbackString, point);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFeedbackCards method, of class FeedbackController.
     */
    @Test
    public void testGetFeedbackCards() {
        System.out.println("getFeedbackCards");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        String searchText = "AHN";
        LinkedList<FeedbackCard> result = FeedbackController.getFeedbackCards(parentFrame, parentDialog, searchText);
        assertNotEquals(null, result);
    }
    
}
