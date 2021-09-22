/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.feedback;

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
public class FacultyModelTest {
    
    public FacultyModelTest() {
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
     * Test of insertFaculty method, of class FacultyModel.
     */
    @Test
    public void testInsertFaculty() {
        System.out.println("insertFaculty");
        String facultyName = "Test Faculty";
        String facultyInitial = "TFC";
        String facultyImg = "";
        boolean result = FacultyModel.insertFaculty(facultyName, facultyInitial, facultyImg);
        if (!result) {
            fail("Insert Faculty Method failed to work");
        }
    }
    
}
