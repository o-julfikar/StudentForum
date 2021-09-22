/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class StringHolderTest {
    
    public StringHolderTest() {
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
     * Test of getId method, of class StringHolder.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        StringHolder instance = new StringHolder(0, "");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class StringHolder.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StringHolder instance = new StringHolder(0, "");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
