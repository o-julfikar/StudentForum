/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.swap;

import model.ImageResource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zulfikar
 */
public class SectionSwapCardTest {
    
    public SectionSwapCardTest() {
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
            SectionSwapCard instance = new SectionSwapCard();
        } catch (Exception e) {
            fail("Unable to create SectionSwapCard with empty parameter");
        }
        
        try {
            SectionSwapCard instance = new SectionSwapCard("TestCourse", "0", "TestProvider", ImageResource.userPhoto, "TestReceiver", ImageResource.userPhoto);
        } catch (Exception e) {
            fail("Unable to create SectionSwapCard with parameters");
        }
    }

    
}
