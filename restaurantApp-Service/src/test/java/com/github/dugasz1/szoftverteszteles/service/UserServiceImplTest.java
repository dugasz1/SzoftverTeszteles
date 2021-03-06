package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.UserAlreadyExistExpection;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.UserNotFoundExpection;
import com.github.dugasz1.szoftverteszteles.service.dao.UserDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import org.easymock.EasyMock;
import org.easymock.internal.MocksControl;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserServiceImpl userService;
    User teszt = new User(1,"teszt");
    User uTeszt = new User(1,"uTeszt");
    User notexistU = new User(111, "notexist");
    @Before
    public void setUp() throws Exception {
        UserDAO userDAO = EasyMock.createNiceMock(UserDAO.class);
        EasyMock.expect(userDAO.createUser("teszt")).andReturn(teszt);
        EasyMock.expect(userDAO.createUser("existingUser")).andThrow(new AlreadyExistingException("existingUser exist."));
        EasyMock.expect(userDAO.getUser(1)).andReturn(teszt);
        EasyMock.expect(userDAO.getUser("teszt")).andReturn(teszt);
        EasyMock.expect(userDAO.getUser(111)).andThrow(new NotFoundException());
        EasyMock.expect(userDAO.getUser("notexist")).andThrow(new NotFoundException());
        EasyMock.expect(userDAO.updateUser(uTeszt)).andReturn(true);
        EasyMock.expect(userDAO.updateUser(notexistU)).andThrow(new NotFoundException());
        EasyMock.expect(userDAO.deleteUser(1)).andReturn(true);
        EasyMock.expect(userDAO.deleteUser(uTeszt)).andReturn(false);
        EasyMock.expect(userDAO.deleteUser(111)).andThrow(new NotFoundException());
        EasyMock.expect(userDAO.deleteUser(notexistU)).andThrow(new NotFoundException());
        EasyMock.replay(userDAO);

        userService = new UserServiceImpl(userDAO);
    }

    @Test
    public void createUser() throws Exception {
        User excepted = new User(1, "teszt");
        User actual = userService.createUser("teszt");
        assertEquals(excepted, actual);
    }

    @Test(expected = UserAlreadyExistExpection.class)
    public void createUserExist() throws Exception {
        userService.createUser("existingUser");
    }

    @Test
    public void getUser() throws Exception {
        assertTrue(userService.getUser(1) == teszt);
    }

    @Test
    public void getUser1() throws Exception {
        assertTrue(userService.getUser("teszt") == teszt);
    }

    @Test(expected = UserNotFoundExpection.class)
    public void getUserByIdNotFound () throws Exception{
        userService.getUser(111);
    }

    @Test(expected = UserNotFoundExpection.class)
    public void getUserByNameNotFound () throws Exception {
        userService.getUser("notexist");
    }

    @Test
    public void updateUser() throws Exception {
        assertTrue(userService.updateUser(uTeszt) == true);
    }

    @Test(expected = UserNotFoundExpection.class)
    public void updateUserNotFound() throws Exception {
        userService.updateUser(notexistU);
    }

    @Test
    public void deleteUser() throws Exception {
        assertTrue(userService.deleteUser(1) == true);
    }

    @Test
    public void deleteUser1() throws Exception {
        assertTrue(userService.deleteUser(uTeszt) == false);
    }

    @Test(expected = UserNotFoundExpection.class)
    public void deleteUserByUserNotFound() throws Exception {
        userService.deleteUser(notexistU);
    }

    @Test(expected = UserNotFoundExpection.class)
    public void deleteUserByIdNotFound() throws Exception {
        userService.deleteUser(111);
    }

}