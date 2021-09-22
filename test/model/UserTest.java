/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.swing.ImageIcon;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of isSignedIn method, of class User.
     */
    @Test
    public void testIsSignedIn() {
        System.out.println("isSignedIn");
        boolean expResult = true;
        User.login(new User(0, "Test", new Department("Test"), new Semester("Summer 2021"), ""));
        boolean result = User.isSignedIn();
        assertEquals(expResult, result);
    }
}
