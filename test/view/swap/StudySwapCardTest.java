/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.swap;

import java.awt.Graphics;
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
public class StudySwapCardTest {
    
    public StudySwapCardTest() {
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
            StudySwapCard instance = new StudySwapCard();
        } catch (Exception e) {
            fail("Unable to create StudySwapCard with empty parameter");
        }
        
        try {
            StudySwapCard instance = new StudySwapCard("TestCourse", "monday", "9:30 AM", "TestTeacher", ImageResource.userPhoto, "TestLearner", ImageResource.userPhoto);
        } catch (Exception e) {
            fail("Unable to create StudySwapCard with parameters");
        }
    }
    
}
