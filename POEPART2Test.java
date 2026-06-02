/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_Lab
 */
public class POEPART2Test {
    
    public POEPART2Test() {
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
     * Test of main method, of class POEPART2.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] ARGS = null;
        POEPART2.main(ARGS);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class POEPART2.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String administrator = "";
        String password = "";
        boolean expResult = true;
        boolean result = POEPART2.login(administrator, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class POEPART2.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        POEPART2.sendMessage();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveMessagesToJSON method, of class POEPART2.
     */
    @Test
    public void testSaveMessagesToJSON() {
        System.out.println("saveMessagesToJSON");
        POEPART2.saveMessagesToJSON();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of showrecentlysentmessages method, of class POEPART2.
     */
    @Test
    public void testShowrecentlysentmessages() {
        System.out.println("showrecentlysentmessages");
        POEPART2.showrecentlysentmessages();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
