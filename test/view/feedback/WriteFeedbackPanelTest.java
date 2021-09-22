/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.feedback;

import model.ImageResource;
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
public class WriteFeedbackPanelTest {
    
    public WriteFeedbackPanelTest() {
        System.out.println("Testing WriteFeedbackPanel");
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
            WriteFeedbackPanel instance = new WriteFeedbackPanel();
        } catch (Exception e) {
            fail("Unable to create WriteFeedbackPanel with empty parameter");
        }
        
        try {
            WriteFeedbackPanel instance = new WriteFeedbackPanel("TestName", "TST", ImageResource.userPhoto);
        } catch (Exception e) {
            fail("Unable to create WriteFeedbackPanel with parameters");
        }
    }
}
