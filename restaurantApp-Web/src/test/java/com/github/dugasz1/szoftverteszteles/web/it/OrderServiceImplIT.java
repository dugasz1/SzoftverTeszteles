package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.service.CategoryService;
import com.github.dugasz1.szoftverteszteles.core.service.OrderService;
import com.github.dugasz1.szoftverteszteles.dao.mysql.CategoryDAOmysql;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.dao.mysql.MenuItemDAOmysql;
import com.github.dugasz1.szoftverteszteles.dao.mysql.OrderDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.CategoryServiceImpl;
import com.github.dugasz1.szoftverteszteles.service.OrderServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

public class OrderServiceImplIT {
    private static Connection conn;
    private static OrderService orderService;


    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " +System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        orderService = new OrderServiceImpl(new OrderDAOmysql(conn, new MenuItemDAOmysql(conn)));
    }

    @Before
    public void setUp() throws Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_order_setup"));
    }

    @After
    public void tearDown() throws Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_order_teardown"));
    }

    @Test
    public void getOrder() throws Exception {
        orderService.getOrder(1);
    }
}
