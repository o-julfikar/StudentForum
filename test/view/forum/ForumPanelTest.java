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
public class ForumPanelTest {
    
    public ForumPanelTest() {
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
            ForumPanel instance = new ForumPanel();
        } catch (Exception e) {
            fail("Unable to create ForumPanel with empty parameter");
        }
    }

    /**
     * Test of loadPosts method, of class ForumPanel.
     */
    @Test
    public void testLoadPosts() {
        System.out.println("loadPosts");
        String tag = "";
        ForumPanel instance = new ForumPanel();
        try {
            instance.loadPosts(tag);
        } catch (Exception e) {
            fail("loadPosts() function failed");
        }
    }
    
}
