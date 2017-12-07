package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.service.CategoryService;
import com.github.dugasz1.szoftverteszteles.core.service.RecipeService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.dao.mysql.CategoryDAOmysql;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.dao.mysql.RecipeDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.CategoryServiceImpl;
import com.github.dugasz1.szoftverteszteles.service.RecipeServiceImpl;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import org.junit.*;

import java.sql.Connection;

public class RecipeServiceImplIT {
    private static Connection conn;
    private static RecipeService recipeService;


    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " +System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        recipeService = new RecipeServiceImpl(new RecipeDAOmysql(conn));
    }

    @Before
    public void setUp () throws Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_recipe_setup"));
    }

    @After
    public void tearDown() throws  Exception{
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_recipe_teardown"));
    }

    @Test
    public void deleteRecipe() throws Exception{
        Assert.assertFalse(recipeService.deleteRecipe(1));
    }





    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }
}
