package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User testUser = null;
    @Before
    public void setUp() throws Exception {
        testUser = new User(1, "tesztuser");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(testUser.getId(), 1);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(testUser.getName(), "tesztuser");
    }

    @Test
    public void setName() throws Exception {
        User localUser = new User(2, "localTuser");
        localUser.setName("renamed");
        assertEquals(localUser.getName(), "renamed");
    }

    @Test
    public void equals() throws Exception {
        User sameUser = new User(1, "tesztuser");
        assertTrue(testUser.equals(sameUser));
    }

}