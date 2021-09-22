/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.swap;

import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
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
public class StudySwapPanelControllerTest {
    
    public StudySwapPanelControllerTest() {
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
     * Test of getSlots method, of class StudySwapPanelController.
     */
    @Test
    public void testGetSlots() {
        System.out.println("getSlots");
        int userID = 18301264;
        LinkedList result = StudySwapPanelController.getSlots(userID);
        assertNotEquals(null, result);
    }

    /**
     * Test of getTeachObjects method, of class StudySwapPanelController.
     */
    @Test
    public void testGetTeachObjects() {
        System.out.println("getTeachObjects");
        int userID = 18301264;
        LinkedList result = StudySwapPanelController.getTeachObjects(userID);
        assertNotEquals(null, result);
    }

    /**
     * Test of getLearnObjects method, of class StudySwapPanelController.
     */
    @Test
    public void testGetLearnObjects() {
        System.out.println("getLearnObjects");
        int userID = 18301264;
        LinkedList<String> result = StudySwapPanelController.getLearnObjects(userID);
        assertNotEquals(null, result);
    }
}
