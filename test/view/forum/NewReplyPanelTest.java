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
public class NewReplyPanelTest {
    
    public NewReplyPanelTest() {
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
            NewReplyPanel instance = new NewReplyPanel();
        } catch (Exception e) {
            fail("Unable to create NewReplyPanel with empty parameter");
        }
        
        try {
            NewReplyPanel instance = new NewReplyPanel(0, 0);
        } catch (Exception e) {
            fail("Unable to create NewReplyPanel with parameters");
        }
    }
    
}
