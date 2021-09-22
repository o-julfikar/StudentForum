/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

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
@Suite.SuiteClasses({view.forum.ForumPanelTest.class, view.forum.PostCardTest.class, view.forum.NewReplyPanelTest.class, view.forum.CommentCardTest.class, view.forum.CommentPanelTest.class, view.forum.NewCommentPanelTest.class, view.forum.PostPanelTest.class, view.forum.WritePostPanelTest.class})
public class ForumSuite {

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
