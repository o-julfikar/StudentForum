/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import model.Department;
import model.ImageResource;
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
public class PostCardTest {
    
    public PostCardTest() {
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
            PostCard instance = new PostCard();
        } catch (Exception e) {
            fail("Unable to create PostCard with empty parameter");
        }
        
        try {
            PostCard instance = new PostCard(0, "Test", new User(0, "TestUser", new Department("Test"), new Semester(Semester.SPRING, 2021), ""), new Date(), new ArrayList<String>());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unable to create PostCard with parameters");
        }
    }

    /**
     * Test of getPostId method, of class PostCard.
     */
    @Test
    public void testGetPostId() {
        System.out.println("getPostId");
        PostCard instance = new PostCard();
        int result = instance.getPostId();
        if (result < 0) {
            fail("getPostId() failed.");
        }
    }
}
