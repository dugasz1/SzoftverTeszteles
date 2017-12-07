package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.service.MenuService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.dao.mysql.MenuItemDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.MenuServiceImpl;
import org.junit.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

public class MenuServiceImplIT {
    private static Connection conn;
    private static MenuService menuService;

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " + System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        menuService = new MenuServiceImpl(new MenuItemDAOmysql(conn));
    }

    @Before
    public void setUp() throws Exception {
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_menu_setup"));
    }

    @After
    public void tearDown() throws Exception {
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_menu_teardown"));
    }

    @Test
    public void getMenuItemById() throws Exception {
        MenuItem actual = menuService.getMenuItem(1);
        Nutritions nutritions = new Nutritions(1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
        IngredientItem ingredientItem = new IngredientItem(1, "testIngredientItem", nutritions, "testUnit");
        Ingredient ingredient = new Ingredient(ingredientItem, 2.0f);
        Category category = new Category(1, "Category1");
        Collection collection = new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, "Test1", category, collection);
        MenuItem expected = new MenuItem(1, 2000.0f, recipe);

        Assert.assertTrue(actual.equals(expected));
    }
    /*@Test
    public void UpdateMenuItemById() throws Exception {
        //menuService.updateMenuItem(1);
    }
    @Ignore
    @Test
    public void UpdateMenuItemByMenuItem() throws Exception {
        Nutritions nutritions = new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f);
        IngredientItem ingredientItem = new IngredientItem(1,"testIngredientItem",nutritions,"testUnit");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Category category = new Category(1,"Category1");
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, "Test1", category,collection);
        MenuItem expected = new MenuItem(1,2000.0f,recipe);
        menuService.updateMenuItem(expected);
    }
    @Ignore
    @Test
    public void deleteMenuItemByMenuItem() throws Exception {
        Nutritions nutritions = new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f);
        IngredientItem ingredientItem = new IngredientItem(1,"testIngredientItem",nutritions,"testUnit");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Category category = new Category(1,"Category1");
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, "Test1", category,collection);
        MenuItem expected = new MenuItem(1,2000.0f,recipe);
        menuService.deleteMenuItem(expected);

    }
    @Ignore
    @Test
    public void deleteMenuItemById() throws Exception {
        menuService.deleteMenuItem(5);
    }
    @Ignore
    @Test(expected = ExistingProblemException.class)
    public void deleteMenuItemByIdException() throws Exception {
        menuService.deleteMenuItem(23);
    }*/


    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }

}