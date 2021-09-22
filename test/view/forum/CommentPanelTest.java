/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

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
public class CommentPanelTest {
    
    public CommentPanelTest() {
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
            CommentPanel instance = new CommentPanel();
        } catch (Exception e) {
            fail("Unable to create CommentPanel with empty parameter");
        }
        
        try {
            CommentPanel instance = new CommentPanel(new CommentCard());
        } catch (Exception e) {
            fail("Unable to create CommentPanel with parameters");
        }
    }

    /**
     * Test of loadReplies method, of class CommentPanel.
     */
    @Test
    public void testLoadReplies() {
        System.out.println("loadReplies");
        CommentPanel instance = new CommentPanel();
        try {
            instance.loadReplies();
        } catch (Exception e) {
            fail("loadReplies() method failed.");
        }
    }
    
}
