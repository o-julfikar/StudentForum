/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.feedback;

import controller.swap.Course;
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
public class FeedbackModelTest {
    
    public FeedbackModelTest() {
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
     * Test of getReviewPoint method, of class FeedbackModel.
     */
    @Test
    public void testGetReviewPoint() {
        System.out.println("getReviewPoint");
        String facultyInitial = "AHN";
        double expResult = 3.3333;
        double result = FeedbackModel.getReviewPoint(facultyInitial);
        
        if (result != expResult) {
            fail("GetReviewPoint method Failed because value not matched with " + result);
        }
    }

    /**
     * Test of getReviewCards method, of class FeedbackModel.
     */
    @Test
    public void testGetReviewCards() {
        System.out.println("getReviewCards");
        String facultyInitial = "AHN";
        LinkedList<ReviewCard> result = FeedbackModel.getReviewCards(facultyInitial);
        if (result == null) {
            fail("Failed to get Review Card");
        }
    }

    @Test
    public void testInsertFeedback() {
        System.out.println("insertFeedback");
        int userID = 18301159;
        String facultyInitial = "AHN";
        Course course = new Course("CSE110", "Programming Language I");
        String feedbackString = "Test Feedback";
        double point = 1.0;
        boolean result = FeedbackModel.insertFeedback(userID, facultyInitial, course, feedbackString, point);
        if (!result) {
            fail("Insert Feedback not working properly");
        }
    }

    /**
     * Test of getFeedbackCards method, of class FeedbackModel.
     */
    @Test
    public void testGetFeedbackCards() {
        System.out.println("getFeedbackCards");
        String searchString = "AHN";
        LinkedList<FeedbackCard> result = FeedbackModel.getFeedbackCards(searchString);
        if (result == null) {
            fail("Get feedback card function not working properly.");
        }
        System.out.println("Found " + result.size() + " feedback cards.");
    }
    
}
