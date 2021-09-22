/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.feedback;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zulfikar
 */
public class FeedbackCardTest {
    
    public FeedbackCardTest() {
        System.out.println("Testing FeedBackCard");
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
    
    @Test
    public void testConstructor() {
        try {
            FeedbackCard instance = new FeedbackCard();
        } catch (Exception e) {
            fail("Unable to create FeedbackCard with empty parameter");
        }
        
        try {
            FeedbackCard instance = new FeedbackCard("Test", "TST", "", 2);
        } catch (Exception e) {
            fail("Unable to create FeedbackCard with parameters");
        }
    }
}
