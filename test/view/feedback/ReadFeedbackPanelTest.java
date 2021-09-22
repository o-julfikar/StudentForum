/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.feedback;

import javax.swing.Icon;
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
public class ReadFeedbackPanelTest {
    
    public ReadFeedbackPanelTest() {
        System.out.println("Testing ReadFeedbackPanel");
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
            ReadFeedbackPanel instance = new ReadFeedbackPanel();
        } catch (Exception e) {
            fail("Unable to create ReadFeedbackPanel with empty parameter");
        }
        
        try {
            Icon[] stars = new Icon[]{ImageResource.zeroStar, ImageResource.zeroStar, ImageResource.zeroStar, ImageResource.zeroStar, ImageResource.zeroStar};
            ReadFeedbackPanel instance = new ReadFeedbackPanel("Test", "TST", ImageResource.userPhoto, stars);
        } catch (Exception e) {
            fail("Unable to create ReadFeedbackPanel with parameters" + e.getMessage());
        }
    }
    
}
