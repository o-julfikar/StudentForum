/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.MouseEvent;
import javax.swing.JComponent;
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
public class TitlePanelTest {
    
    public TitlePanelTest() {
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
            TitlePanel instance = new TitlePanel();
        } catch (Exception e) {
            fail("Unable to create TitlePanel with empty parameter");
        }
        
        try {
            TitlePanel instance = new TitlePanel(new Home());
        } catch (Exception e) {
            fail("Unable to create TitlePanel with one parameter");
        }
        
        try {
            TitlePanel instance = new TitlePanel(new Home(), "Test Title");
        } catch (Exception e) {
            fail("Unable to create TitlePanel with two parameter");
        }
    }
    
}
