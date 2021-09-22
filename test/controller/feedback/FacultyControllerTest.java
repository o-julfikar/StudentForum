/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.feedback;

import java.awt.Dialog;
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
public class FacultyControllerTest {
    
    public FacultyControllerTest() {
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
     * Test of insertFaculty method, of class FacultyController.
     */
    @Test
    public void testInsertFaculty() {
        System.out.println("insertFaculty");
        Dialog parentDialog = null;
        String facultyName = "TestFaculty";
        String facultyInitial = "TFY";
        String facultyImg = "";
        boolean expResult = true;
        boolean result = FacultyController.insertFaculty(parentDialog, facultyName, facultyInitial, facultyImg);
        assertEquals(expResult, result);
    }
    
}
