/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.swap;

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
public class SectionSwapShellTest {
    
    public SectionSwapShellTest() {
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

    /**
     * Test of toString method, of class SectionSwapShell.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SectionSwapShell instance = new SectionSwapShell(0, 0, false);
        String expResult = "0 > 0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
