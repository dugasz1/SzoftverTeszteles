package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.UserDAO;
import org.easymock.EasyMock;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        UserDAO userDAO = EasyMock.createNiceMock(UserDAO.class);
        EasyMock.expect(userDAO.createUser("tesztuser")).andReturn(new User(1, "tesztuser"));

        EasyMock.replay(userDAO);

        userService = new UserServiceImpl(userDAO);
    }

    @Test
    public void createUser() throws Exception {
        User excepted = new User(1, "tesztuser");
        User actual = userService.createUser("tesztuser");
        assertEquals(excepted, actual);
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void getUser1() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void deleteUser1() throws Exception {
    }

}