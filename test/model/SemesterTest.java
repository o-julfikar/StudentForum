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
public class SemesterTest {
    
    public SemesterTest() {
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
     * Test of getSeasonCode method, of class Semester.
     */
    @Test
    public void testGetSeasonCode() {
        System.out.println("getSeasonCode");
        String seasonName = "Summer";
        int expResult = 3;
        int result = Semester.getSeasonCode(seasonName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeasonName method, of class Semester.
     */
    @Test
    public void testGetSeasonName() {
        System.out.println("getSeasonName");
        int seasonCode = 1;
        String expResult = "Spring";
        String result = Semester.getSeasonName(seasonCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Semester.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Semester instance = new Semester(2, 21);
        String expResult = "Fall 2021";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
