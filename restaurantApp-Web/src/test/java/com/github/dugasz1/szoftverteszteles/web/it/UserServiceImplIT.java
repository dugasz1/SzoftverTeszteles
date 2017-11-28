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

    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }
}
