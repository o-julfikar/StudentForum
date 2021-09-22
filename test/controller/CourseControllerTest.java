/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class CourseControllerTest {
    public CourseControllerTest() {
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
     * Test of addCourse method, of class CourseController.
     */
    @Test
    public void testAddCourse() {
        System.out.println("addCourse");
        Dialog parentDialog = null;
        String courseCode = "CSE451";
        String courseTitle = "Advanced Test";
        boolean expResult = true;
        boolean result = CourseController.addCourse(parentDialog, courseCode, courseTitle);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCourseWithSection method, of class CourseController.
     */
    @Test
    public void testAddCourseWithSection() {
        System.out.println("addCourseWithSection");
        Dialog parentDialog = null;
        String courseCode = "CSE452";
        String courseTitle = "Advanced Test 2";
        String courseSection = "1-3";
        boolean expResult = true;
        boolean result = CourseController.addCourseWithSection(parentDialog, courseCode, courseTitle, courseSection);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCourseSection method, of class CourseController.
     */
    @Test
    public void testAddCourseSection() {
        System.out.println("addCourseSection");
        Dialog parentDialog = null;
        String courseCode = "CSE111";
        String courseSection = "99";
        boolean expResult = true;
        boolean result = CourseController.addCourseSection(parentDialog, courseCode, courseSection);
        assertEquals(expResult, result);
    }
    
}
