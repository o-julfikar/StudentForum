/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dialog;
import java.util.LinkedList;
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
public class ConsoleControllerTest {
    
    public ConsoleControllerTest() {
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
     * Test of getData method, of class ConsoleController.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Dialog parentDialog = null;
        String query = "select * from student";
        LinkedList result = ConsoleController.getData(parentDialog, query);
        assertNotEquals(null, result);
    }

    /**
     * Test of updateData method, of class ConsoleController.
     */
    @Test
    public void testUpdateData() {
        System.out.println("updateData");
        Dialog parentDialog = null;
        String query = "INSERT INTO course (course_code, course_title) VALUES ('TST101', 'Introo to Test')";
        boolean expResult = true;
        boolean result = ConsoleController.updateData(parentDialog, query);
        assertEquals(expResult, result);
    }
    
}
