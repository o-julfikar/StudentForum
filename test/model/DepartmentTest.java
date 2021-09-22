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
public class DepartmentTest {
    
    public DepartmentTest() {
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
     * Test of getDepartment method, of class Department.
     */
    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        int departmentCode = 1;
        String expResult = "Computer Science and Engineering";
        String result = Department.getDepartment(departmentCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Department.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Department instance = new Department("Test");
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Department.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Department instance = new Department("Test");
        String expResult = "Department of Test";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAcronym method, of class Department.
     */
    @Test
    public void testGetAcronym() {
        System.out.println("getAcronym");
        Department instance = new Department("Test Of Test");
        String expResult = "TOT";
        String result = instance.getAcronym();
        assertEquals(expResult, result);
    }
    
}
