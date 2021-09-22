/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.feedback;

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
public class AddFacultyPanelTest {
    
    public AddFacultyPanelTest() {
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
    public void testGetNumberOfNewFaculty() {
        System.out.println("getNumberOfNewFaculty");
        AddFacultyPanel instance = new AddFacultyPanel();
        if (instance == null) fail("An error occured while creating AddFacultyPanel object");
        try {
            int result = instance.getNumberOfNewFaculty();
        } catch (Exception e) {
            fail("An error occured to get the number of faculty.");
        }
    }
    
}
