/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.swap;

import controller.swap.Course;
import controller.swap.StudySlot;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;
import model.StringHolder;
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
public class StudySlotModelTest {
    
    public StudySlotModelTest() {
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
     * Test of getSlotsList method, of class StudySlotModel.
     */
    @Test
    public void testGetSlotsList() {
        System.out.println("getSlotsList");
        HashMap<Integer, Queue<Integer>> result = StudySlotModel.getSlotsList();
        assertNotEquals(null, result);
    }

    /**
     * Test of getLearnersList method, of class StudySlotModel.
     */
    @Test
    public void testGetLearnersList() {
        System.out.println("getLearnersList");
        HashMap<String, Queue<Integer>> result = StudySlotModel.getLearnersList();
        assertNotEquals(null, result);
    }

    /**
     * Test of getCourseList method, of class StudySlotModel.
     */
    @Test
    public void testGetCourseList() {
        System.out.println("getCourseList");
        HashMap<Integer, Queue<String>> result = StudySlotModel.getCourseList();
        assertNotEquals(null, result);
    }

    /**
     * Test of getNameOfDay method, of class StudySlotModel.
     */
    @Test
    public void testGetNameOfDay() {
        System.out.println("getNameOfDay");
        int dayNumber = 1;
        String expResult = "Sunday";
        String result = StudySlotModel.getNameOfDay(dayNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortNameOfDay method, of class StudySlotModel.
     */
    @Test
    public void testGetShortNameOfDay() {
        System.out.println("getShortNameOfDay");
        int dayNumber = 1;
        String expResult = "Sun";
        String result = StudySlotModel.getShortNameOfDay(dayNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToMilitaryTime method, of class StudySlotModel.
     */
    @Test
    public void testConvertToMilitaryTime() {
        System.out.println("convertToMilitaryTime");
        String meridiemTime = "02:23 PM";
        String expResult = "14:23";
        String result = StudySlotModel.convertToMilitaryTime(meridiemTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDayNumber method, of class StudySlotModel.
     */
    @Test
    public void testGetDayNumber() {
        System.out.println("getDayNumber");
        String day = "Sunday";
        int expResult = 1;
        int result = StudySlotModel.getDayNumber(day);
        assertEquals(expResult, result);
    }
    
}
