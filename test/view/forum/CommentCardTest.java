/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

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
public class CommentCardTest {
    
    public CommentCardTest() {
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
            CommentCard instance = new CommentCard();
        } catch (Exception e) {
            fail("Unable to create CommentCard with empty parameter");
        }
        
        try {
            CommentCard instance = new CommentCard(0, 0, null, "TestComment", 0, "TestWriter", "TestPhoto");
        } catch (Exception e) {
            fail("Unable to create CommentCard with string photo URL parameters");
        }
        
        try {
            CommentCard instance = new CommentCard(0, 0, null, "TestComment", 0, "TestWriter", ImageResource.userPhoto);
        } catch (Exception e) {
            fail("Unable to create CommentCard with ImageIcon photo parameters");
        }
    }
    
}
