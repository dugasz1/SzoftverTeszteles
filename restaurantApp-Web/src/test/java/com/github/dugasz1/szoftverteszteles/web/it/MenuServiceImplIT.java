package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.service.MenuService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MenuItemNotFoundException;
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

    private MenuItem menuItem;

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Conection string: " + System.getProperty("mysql_connection_string"));
        conn = ConnectionManager.getConnection(System.getProperty("mysql_connection_string"));

        menuService = new MenuServiceImpl(new MenuItemDAOmysql(conn));


    }

    @Before
    public void setUp() throws Exception {
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_menu_setup"));

        Nutritions nutritions = new Nutritions(1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
        IngredientItem ingredientItem = new IngredientItem(1, "testIngredientItem", nutritions, "testUnit");
        Ingredient ingredient = new Ingredient(ingredientItem, 2.0f);
        Category category = new Category(1, "Category1");
        Collection collection = new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, "Test1", category, collection);
        menuItem = new MenuItem(1, 2000.0f, recipe);
    }

    @After
    public void tearDown() throws Exception {
        TestUtil.executeSQLFile(conn, System.getProperty("mysql_file_menu_teardown"));
    }

    @Test
    public void getMenuItemById() throws Exception {
        MenuItem actual = menuService.getMenuItem(1);

        Assert.assertTrue(actual.equals(menuItem));
    }

    @Test(expected = MenuItemNotFoundException.class)
    public void getNotExistingMenuItem() throws Exception {
        menuService.getMenuItem(23);
    }

    @Test
    public void updateMenuItemByMenuItem() throws Exception {
        menuItem.setPrice(1000);
        Assert.assertTrue( menuService.updateMenuItem(menuItem));
    }

    public void deleteMenuItemByMenuItem() throws Exception {
        Assert.assertTrue(menuService.deleteMenuItem(menuItem));
    }

    @Test(expected = MenuItemNotFoundException.class)
    public void deleteMenuItemByMenuItem2() throws Exception {
        menuService.deleteMenuItem(menuItem);
        menuService.getMenuItem(menuItem.getId());
    }

    @Test
    public void deleteMenuItemById() throws Exception {
        Assert.assertTrue(menuService.deleteMenuItem(menuItem.getId()));
    }

    @Test(expected = MenuItemNotFoundException.class)
    public void deleteMenuItemById2() throws Exception {
        menuService.deleteMenuItem(menuItem.getId());
        menuService.getMenuItem(menuItem.getId());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        conn.close();
    }

}