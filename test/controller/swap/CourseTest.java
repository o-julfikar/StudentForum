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
public class CourseTest {
    
    public CourseTest() {
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
     * Test of getCourseCode method, of class Course.
     */
    @Test
    public void testGetCourseCode() {
        System.out.println("getCourseCode");
        Course instance = new Course("TST101", "Intro to Test");
        String expResult = "TST101";
        String result = instance.getCourseCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourseTitle method, of class Course.
     */
    @Test
    public void testGetCourseTitle() {
        System.out.println("getCourseTitle");
        Course instance = new Course("TST101", "Intro to Test");
        String expResult = "Intro to Test";
        String result = instance.getCourseTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Course.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Course other = new Course("TST102", "Intro to Test");
        Course instance = new Course("TST101", "Intro to Test");
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Course instance = new Course("TST101", "Intro to Test");
        String expResult = "TST101 (Intro to Test)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
