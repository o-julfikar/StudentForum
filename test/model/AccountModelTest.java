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
import view.ErrorPanel;

/**
 *
 * @author Zulfikar
 */
public class AccountModelTest {
    
    public AccountModelTest() {
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
     * Test of updateUserPassword method, of class AccountModel.
     */
    @Test
    public void testUpdateUserPassword() {
        System.out.println("updateUserPassword");
        testGetLoginError();
        boolean expResult = true;
        boolean result = AccountModel.updateUserPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUserInfo method, of class AccountModel.
     */
    @Test
    public void testUpdateUserInfo() {
        System.out.println("updateUserInfo");
        testGetLoginError();
        boolean expResult = true;
        boolean result = AccountModel.updateUserInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLoginError method, of class AccountModel.
     */
    
    public void testGetLoginError() {
        System.out.println("getLoginError");
        String userID = "18301264";
        String userPassword = "123456";
        ErrorPanel result = AccountModel.getLoginError(userID, userPassword);
        assertEquals(null, result);
    }

    /**
     * Test of registerUser method, of class AccountModel.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String userID = "-1";
        String userName = "testUser";
        String birthDate = "1990/01/01";
        String department = "Department of Test and Testing";
        String semester = "Summer 2021";
        String phone = "01234567891";
        String email = "test@bracu.ac.bd";
        String password = "123456";
        String photo = "";
        int role = 2;
        boolean expResult = true;
        boolean result = AccountModel.registerUser(userID, userName, birthDate, department, semester, phone, email, password, photo, role);
        assertEquals(expResult, result);
    }
    
}
