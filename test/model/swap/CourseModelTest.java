/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.swap;

import controller.swap.Course;
import javax.swing.JComboBox;
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
public class CourseModelTest {
    
    public CourseModelTest() {
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
//
//    /**
//     * Test of addCourse method, of class CourseModel.
//     */
//    @Test
//    public void testAddCourse() {
//        System.out.println("addCourse");
//        String courseCode = "CSE473";
//        String courseTitle = "Software Engineering 3";
//        boolean result = CourseModel.addCourse(courseCode, courseTitle);
//        assertEquals(true, result);
//    }
//
//    /**
//     * Test of addCourseWithSection method, of class CourseModel.
//     */
//    @Test
//    public void testAddCourseWithSection() {
//        System.out.println("addCourseWithSection");
//        String courseCode = "CSE474";
//        String courseTitle = "Software Engineering 4";
//        String courseSection = "01";
//        boolean expResult = true;
//        boolean result = CourseModel.addCourseWithSection(courseCode, courseTitle, courseSection);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of addCourseSection method, of class CourseModel.
//     */
//    @Test
//    public void testAddCourseSection() {
//        System.out.println("addCourseSection");
//        String courseCode = "CSE491";
//        String courseSection = "13";
//        boolean expResult = true;
//        boolean result = CourseModel.addCourseSection(courseCode, courseSection);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of fillCourseCode method, of class CourseModel.
     */
    @Test
    public void testFillCourseCode() {
        System.out.println("fillCourseCode");
        try {
            JComboBox containerComboBox = new JComboBox(new Object[]{});
            CourseModel.fillCourseCode(containerComboBox);
        } catch (Exception e) {
            fail("Filling course code method failed.");
        }
        
    }

    /**
     * Test of getCourse method, of class CourseModel.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        String courseCode = "CSE110";
        Course expResult = new Course("CSE110", "Programming Language I");
        Course result = CourseModel.getCourse(courseCode);
        assertEquals(expResult.toString(), result.toString());
    }
    
}
