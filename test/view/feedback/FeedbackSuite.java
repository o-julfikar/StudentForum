/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.feedback;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Zulfikar
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({view.feedback.ReadFeedbackPanelTest.class, view.feedback.WriteFeedbackPanelTest.class, view.feedback.FeedbackPanelTest.class, view.feedback.AddFacultyPanelTest.class, view.feedback.FeedbackCardTest.class, view.feedback.ReviewCardTest.class})
public class FeedbackSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
