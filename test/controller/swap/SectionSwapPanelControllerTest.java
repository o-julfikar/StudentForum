/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.swap;

import java.awt.Dialog;
import java.awt.Frame;
import java.util.LinkedList;
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
public class SectionSwapPanelControllerTest {
    
    public SectionSwapPanelControllerTest() {
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
     * Test of addOffer method, of class SectionSwapPanelController.
     */
    @Test
    public void testAddOffer() {
        System.out.println("addOffer");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        int id = 18301264;
        String course = "CSE110";
        String section = "07";
        boolean expResult = true;
        boolean result = SectionSwapPanelController.addOffer(parentFrame, parentDialog, id, course, section);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPrefer method, of class SectionSwapPanelController.
     */
    @Test
    public void testAddPrefer() {
        System.out.println("addPrefer");
        Frame parentFrame = null;
        Dialog parentDialog = null;
        int id = 18301264;
        String course = "CSE110";
        String section = "08";
        boolean expResult = true;
        boolean result = SectionSwapPanelController.addPrefer(parentFrame, parentDialog, id, course, section);
        assertEquals(expResult, result);
    }

    /**
     * Test of getOfferObjects method, of class SectionSwapPanelController.
     */
    @Test
    public void testGetOfferObjects() {
        System.out.println("getOfferObjects");
        int userID = 18301264;
        LinkedList result = SectionSwapPanelController.getOfferObjects(userID);
        assertNotEquals(null, result);
    }

    /**
     * Test of getPreferObjects method, of class SectionSwapPanelController.
     */
    @Test
    public void testGetPreferObjects() {
        System.out.println("getPreferObjects");
        int userID = 18301264;
        LinkedList<String> result = SectionSwapPanelController.getPreferObjects(userID);
        assertNotEquals(null, result);
    }
    
}
