/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
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
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of getResultOf method, of class Database.
     */
    @Test
    public void testGetResultOf() throws Exception {
        System.out.println("getResultOf");
        String query = "Select * from post";
        ResultSet result = Database.getResultOf(query);
        assertNotEquals(null, result);
    }

    /**
     * Test of updateWith method, of class Database.
     */
    @Test
    public void testUpdateWith() {
        System.out.println("updateWith");
        String query = "INSERT INTO course (course_code, course_title) VALUES ('TST102', 'Introo to Test 2')";
        boolean expResult = true;
        boolean result = Database.updateWith(query);
        assertEquals(expResult, result);
    }
    
}
