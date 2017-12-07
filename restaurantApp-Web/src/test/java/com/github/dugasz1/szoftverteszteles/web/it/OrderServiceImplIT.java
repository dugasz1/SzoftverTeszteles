package com.github.dugasz1.szoftverteszteles.web.it;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.service.CategoryService;
import com.github.dugasz1.szoftverteszteles.core.service.OrderService;
import com.github.dugasz1.szoftverteszteles.dao.mysql.CategoryDAOmysql;
import com.github.dugasz1.szoftverteszteles.dao.mysql.ConnectionManager;
import com.github.dugasz1.szoftverteszteles.dao.mysql.MenuItemDAOmysql;
import com.github.dugasz1.szoftverteszteles.dao.mysql.OrderDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.CategoryServiceImpl;
import com.github.dugasz1.szoftverteszteles.service.OrderServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

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
        Order order = orderService.getOrder(1);
        Category category = new Category(1, "leves");

        IngredientItem ingredientItem = new IngredientItem(1, "bors", new Nutritions(10, 10, 5, 10, 5), "gramm");
        Ingredient ingredient = new Ingredient(ingredientItem, 20);
        Collection<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        Recipe recipe = new Recipe(1, "husleves", category, ingredients);
        MenuItem menuItem = new MenuItem(1, 3000, recipe);

        Collection<MenuItem> collection = new ArrayList<>();
        MenuItem actualMenu = order.getMenuItems().iterator().next();
        Collection<Ingredient> actualIngr = actualMenu.getRecipe().getIngredients();

        Assert.assertThat(actualIngr, CoreMatchers.hasItems(ingredients.toArray(new Ingredient[ingredients.size()])) );
    }
}
