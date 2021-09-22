/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.swap;

import controller.swap.Section;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JComboBox;
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
public class SectionModelTest {
    
    public SectionModelTest() {
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
     * Test of getOffersList method, of class SectionModel.
     */
    @Test
    public void testGetOffersList() {
        System.out.println("getOffersList");
        HashMap<Integer, Queue<Integer>> result = SectionModel.getOffersList();
        assertNotEquals(null, result);
    }

    /**
     * Test of getPrefersList method, of class SectionModel.
     */
    @Test
    public void testGetPrefersList() {
        System.out.println("getPrefersList");
        HashMap<Integer, Queue<Integer>> result = SectionModel.getPrefersList();
        assertNotEquals(null, result);
    }

    /**
     * Test of getOfferObjects method, of class SectionModel.
     */
    @Test
    public void testGetOfferObjects() {
        System.out.println("getOfferObjects");
        int userID = 18301264;
        LinkedList result = SectionModel.getOfferObjects(userID);
        assertNotEquals(null, result);
    }

    /**
     * Test of getPreferObjects method, of class SectionModel.
     */
    @Test
    public void testGetPreferObjects() {
        System.out.println("getPreferObjects");
        int userID = 18301264;
        LinkedList<String> result = SectionModel.getPreferObjects(userID);
        assertNotEquals(null, result);
    }
    
}
