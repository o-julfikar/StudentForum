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
public class SuccessPanelTest {
    
    public SuccessPanelTest() {
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
            SuccessPanel instance = new SuccessPanel();
        } catch (Exception e) {
//            fail("Unable to create SuccessPanel with empty parameter");
        }
        
        try {
            SuccessPanel instance = new SuccessPanel("Test Success Message");
        } catch (Exception e) {
            fail("Unable to create SuccessPanel with parameters");
        }
    }
    
}
