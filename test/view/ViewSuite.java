/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
@Suite.SuiteClasses({view.HomeTest.class, view.SuccessPanelTest.class, view.DialogFormTest.class, view.UserProfilePanelTest.class, view.feedback.FeedbackSuite.class, view.ErrorPanelTest.class, view.forum.ForumSuite.class, view.swap.SwapSuite.class, view.LoginPanelTest.class, view.AdminPanelTest.class, view.DialogTitlePanelTest.class, view.TitlePanelTest.class, view.AddCoursePanelTest.class, view.AccountPanelTest.class, view.FlatButtonTest.class, view.RegisterPanelTest.class, view.ConsolePanelTest.class, view.SecurityPanelTest.class})
public class ViewSuite {

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
