/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
public class DialogTitlePanelTest {
    
    public DialogTitlePanelTest() {
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
            DialogTitlePanel instance = new DialogTitlePanel();
        } catch (Exception e) {
//            fail("Unable to create DialogTitlePanel with empty parameter");
        }
        
        try {
            DialogTitlePanel instance = new DialogTitlePanel(new DialogForm());
        } catch (Exception e) {
            fail("Unable to create DialogTitlePanel with one parameter");
        }
        
        try {
            DialogTitlePanel instance = new DialogTitlePanel(new DialogForm(), "Test");
        } catch (Exception e) {
            fail("Unable to create DialogTitlePanel with two parameters");
        }
    }
    
}
