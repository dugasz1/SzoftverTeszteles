package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.service.CategoryService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.dao.mysql.CategoryDAOmysql;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.service.CategoryServiceImpl;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import org.junit.*;

import java.sql.Connection;

public class CategoryServiceImplIT {
    private static Connection conn;
    private static CategoryService categoryService;


    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " +System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        categoryService = new CategoryServiceImpl(new CategoryDAOmysql(conn));
    }

    @Before
    public void setUp () throws Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_category_setup"));
    }

    @After
    public void tearDown() throws  Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_category_teardown"));
    }

    @Test
    public void dbTest() throws Exception{
        Assert.assertEquals(conn.isValid(1000),true);
    }

    @Test
    public void getCategoryTest() throws Exception{
        Assert.assertEquals(categoryService.getCategory(1),new Category(1,"Leves"));
    }

    @Test(expected = StorageProblemException.class)
    public void deleteCategoryTest() throws Exception{
        categoryService.deletaCategory(10);
    }

    @Test
    public void updateCategoryTest() throws Exception {
        Category base = categoryService.getCategory(1);
        base.setName("New name");
        categoryService.updateCategor(base);
        Category updated = categoryService.getCategory(1);

        Assert.assertTrue(updated.getName().equals(base.getName()));
    }

    @Ignore
    @Test
    public void addCategoryTest() throws Exception {
        Category base = new Category(7, "Spagetti");
        categoryService.addCategory(base);
        Category added = categoryService.getCategory(7);

        Assert.assertTrue(base.getName().equals(added));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }
}
