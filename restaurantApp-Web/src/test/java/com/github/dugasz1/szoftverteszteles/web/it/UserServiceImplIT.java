package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.UserService;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.dao.mysql.UserDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.UserServiceImpl;
import org.junit.*;

import java.sql.Connection;
import java.sql.Statement;

public class UserServiceImplIT {
    private static Connection conn;
    private static UserService userService;

    private static final String SET_UP_QUERY = "INSERT INTO `user` (`id`, `username`) VALUES(NULL, \"Teszt User\");";
    private static final String TEAR_DOWN_QUERY = "SET FOREIGN_KEY_CHECKS = 0;" +
            "TRUNCATE `user`;" +
            "SET FOREIGN_KEY_CHECKS = 1;";

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " +System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        userService = new UserServiceImpl(new UserDAOmysql(conn));
    }

    @Before
    public void setUp () throws Exception{
        Statement statement = conn.createStatement();
        statement.execute(SET_UP_QUERY);
    }

    @After
    public void tearDown() throws  Exception{
        Statement statement = conn.createStatement();
        statement.execute(TEAR_DOWN_QUERY);
    }

    @Test
    public void getUserById() throws Exception {
        User actual = userService.getUser(1);
        User expected = new User(1, "Teszt User");

        System.out.println("actual: " + actual.toString());
        System.out.println("expected: " + expected.toString());

        Assert.assertTrue(actual.equals(expected));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }
}
