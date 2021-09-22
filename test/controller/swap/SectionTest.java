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
public class SectionTest {
    
    public SectionTest() {
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
     * Test of getId method, of class Section.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Section instance = new Section(0, new Course("TST", "Test"), 1);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSectionNumber method, of class Section.
     */
    @Test
    public void testGetSectionNumber() {
        System.out.println("getSectionNumber");
        Section instance = new Section(0, new Course("TST", "Test"), 1);
        int expResult = 1;
        int result = instance.getSectionNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class Section.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        Course crs = new Course("TST", "Test");
        Section instance = new Section(0, crs, 1);
        Course result = instance.getCourse();
        assertEquals(crs, result);
    }

    /**
     * Test of toString method, of class Section.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Section instance = new Section(0, new Course("TST", "Test"), 1);
        String expResult = "TST (01)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
