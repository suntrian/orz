package com.suntr;

import org.junit.*;

import java.io.IOException;

/**
 * Created by suntr on 5/14/2017.
 * junit4 ways for test
 */
public class UserTest {

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public static void testAfterClass(){
        System.out.println("AfterClass");
    }
    @Ignore
    public void testIgnore(){
        System.out.println("ignore");
    }
    @Before
    public void testBefore(){
        System.out.println("Before");
    }
    @After
    public void testAfter(){
        System.out.println("After");
    }
    @Test(expected = IOException.class, timeout = 3)
    public void testMain(){
        Assert.assertTrue("not implement yet" != null );
    }
    @Test
    public void testAssert(){
        Assert.assertEquals("Equal","abc","abcd");
    }

}
