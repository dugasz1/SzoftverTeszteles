package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.UserAlreadyExistExpection;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.UserNotFoundExpection;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.UserService;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.dao.mysql.UserDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.UserServiceImpl;
import org.junit.*;

import java.sql.Connection;

public class UserServiceImplIT {
    private static Connection conn;
    private static UserService userService;


    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " +System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        userService = new UserServiceImpl(new UserDAOmysql(conn));
    }

    @Before
    public void setUp () throws Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_user_setup"));
    }

    @After
    public void tearDown() throws  Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_user_teardown"));
    }

    @Test
    public void getUserById() throws Exception {
        User actual = userService.getUser(1);
        User expected = new User(1, "Teszt User");

        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void getUserByName() throws Exception {
        User actual = userService.getUser("Répási Kristóf");
        User expected = new User(8, "Répási Kristóf");

        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void updateUser() throws Exception {
        User base = userService.getUser(1);
        base.setName("New name");
        userService.updateUser(base);
        User updated = userService.getUser(1);

        Assert.assertTrue(updated.getName().equals(base.getName()));
    }

    @Test(expected = UserNotFoundExpection.class)
    public void getNotExistingUser() throws Exception {
        userService.getUser(55);
    }

    @Test
    public void createUserTest() throws Exception {
        String userName = " New User";
        User newUser = userService.createUser(userName);

        Assert.assertTrue(userService.getUser(userName).equals(newUser));
    }

    @Test(expected = UserAlreadyExistExpection.class)
    public void createExistingUser() throws Exception {
        userService.createUser("Ardó Bence");
    }

    @Test
    public void deleteUserByIdTest() throws Exception {
        User local = userService.getUser(1);
        Assert.assertTrue(userService.deleteUser(local.getId()));
    }

    @Test(expected = UserNotFoundExpection.class)
    public void deleteUserByIdTest2() throws Exception {
        User user = userService.getUser(3);
        userService.deleteUser(user);
        userService.getUser(3);
    }

    @Test
    public void deleteUserByUserTest() throws Exception {
        User local = userService.getUser(1);
        Assert.assertTrue(userService.deleteUser(local));
    }

    @Test(expected = UserNotFoundExpection.class)
    public void deleteNotExistingUser() throws Exception {
        userService.deleteUser(23);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }
}
