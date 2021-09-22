/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dialog;
import java.awt.Frame;
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
public class AccountControllerTest {
    
    public AccountControllerTest() {
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
     * Test of userLogin method, of class AccountController.
     */
    @Test
    public void testUserLogin() {
        System.out.println("userLogin");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        String userID = "18301264";
        String userPassword = "123456";
        boolean expResult = true;
        boolean result = AccountController.userLogin(parentFrame, parentDialog, userID, userPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class AccountController.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Dialog parentDialog = null;
        String userID = "-2";
        String userName = "18301264";
        String birthDate = "1990/01/01";
        String department = "Test";
        String semester = "Test 2021";
        String phone = "01234567891";
        String email = "test@bracu.ac.bd";
        String password = "123456";
        String photo = "";
        int role = 2;
        boolean expResult = true;
        boolean result = AccountController.registerUser(parentDialog, userID, userName, birthDate, department, semester, phone, email, password, photo, role);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUserPassword method, of class AccountController.
     */
    @Test
    public void testUpdateUserPassword() {
        System.out.println("updateUserPassword");
        Dialog parentDialog = null;
        boolean expResult = true;
        boolean result = AccountController.updateUserPassword(parentDialog);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUserInfo method, of class AccountController.
     */
    @Test
    public void testUpdateUserInfo() {
        System.out.println("updateUserInfo");
        Dialog parentDialog = null;
        boolean expResult = true;
        testUserLogin();
        boolean result = AccountController.updateUserInfo(parentDialog);
        assertEquals(expResult, result);
    }
    
}
