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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Zulfikar
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.AccountModelTest.class, model.UserTest.class, model.DepartmentTest.class, model.DatabaseTest.class, model.ConsoleModelTest.class, model.forum.ForumSuite.class, model.feedback.FeedbackSuite.class, model.SemesterTest.class, model.ImageResourceTest.class, model.StringHolderTest.class, model.swap.SwapSuite.class})
public class ModelSuite {

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
