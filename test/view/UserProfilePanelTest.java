/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Department;
import model.Semester;
import model.User;
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
public class UserProfilePanelTest {
    
    public UserProfilePanelTest() {
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
    
    @Test
    public void testConstructor() {
        try {
            User.login(new User(0, "test", new Department("test"), new Semester(1, 2021), ""));
            UserProfilePanel instance = new UserProfilePanel();
            User.logout();
        } catch (Exception e) {
            fail("Unable to create UserProfilePanel with empty parameter");
        }
    }
    
}
