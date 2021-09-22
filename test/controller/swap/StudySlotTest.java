/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.swap;

import java.sql.Time;
import java.util.Date;
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
public class StudySlotTest {
    
    public StudySlotTest() {
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
     * Test of getId method, of class StudySlot.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        StudySlot instance = new StudySlot(0, new Course("TST101", "Test"), "Sunday", Time.valueOf("01:01:01"));
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class StudySlot.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        Course crs = new Course("TST101", "Test");
        StudySlot instance = new StudySlot(0, crs, "Sunday", Time.valueOf("01:01:01"));
        Course result = instance.getCourse();
        assertEquals(crs, result);
    }

    /**
     * Test of getCourseCode method, of class StudySlot.
     */
    @Test
    public void testGetCourseCode() {
        System.out.println("getCourseCode");
        StudySlot instance = new StudySlot(0, "TST101", "Sunday", Time.valueOf("01:01:01"));
        String expResult = "TST101";
        String result = instance.getCourseCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class StudySlot.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        StudySlot instance = new StudySlot(0, new Course("TST101", "Test"), "Sunday", Time.valueOf("01:01:01"));
        String expResult = "Sunday";
        String result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTime method, of class StudySlot.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        StudySlot instance = new StudySlot(0, new Course("TST101", "Test"), "Sunday", Time.valueOf("01:01:01"));
        Time expResult = Time.valueOf("01:01:01");
        Time result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class StudySlot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StudySlot instance = new StudySlot(0, new Course("TST101", "Test"), "Sunday", Time.valueOf("01:01:01"));
        String expResult = "TST101 (Sunday - 01:01 AM)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
