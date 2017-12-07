package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.EmptyMenuitemException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoDateException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoMenuitemException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class OrderTest {
    private Order orderTest = null;
    private Collection<MenuItem> menuItemCollection = new HashSet<MenuItem>();
    private List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    @Before
    public void setUp() throws Exception{
        ingredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));
        ingredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        menuItemCollection.add(new MenuItem(1, 1550f, new Recipe(1,"name",  new Category(1, "testCategory1"), ingredientList)));
        menuItemCollection.add(new MenuItem(2,2000f, new Recipe(2,"name",  new Category(2, "testCategory2"), ingredientList)));

        orderTest = new Order(1, new Date(2017-11-07), menuItemCollection);
    }

    @Test
    public void getId() throws Exception{
        assertEquals(orderTest.getId(),1);
    }

    @Test
    public void getDate() throws Exception{
        assertEquals(orderTest.getDate(), new Date(2017-11-07));
    }

    @Test
    public void setDate() throws Exception{
        orderTest.setDate(new Date(2017-12-25));
        assertEquals(orderTest.getDate(), new Date(2017-12-25));
    }

    @Test
    public void isCompleted() throws Exception{
        assertEquals(orderTest.isCompleted(), false);
    }

    @Test
    public void setCompleted() throws Exception{
        orderTest.setCompleted(true);
        assertEquals(orderTest.isCompleted(), true);
    }

    @Test
    public void getMenuItems() throws Exception{
        List<Ingredient> localIngredientList = new ArrayList<Ingredient>();
        Collection<MenuItem> localMenuItemCollection = new HashSet<MenuItem>();

        localIngredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));
        localIngredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        localMenuItemCollection.add(new MenuItem(1, 1550f, new Recipe(1,"name",  new Category(1, "testCategory1"), localIngredientList)));
        localMenuItemCollection.add(new MenuItem(2,2000f, new Recipe(2,"name",  new Category(2, "testCategory2"), localIngredientList)));

        assertEquals(orderTest.getMenuItems(), localMenuItemCollection);
    }

    @Test
    public void setMenuItems() throws Exception{
        List<Ingredient> localIngredientList = new ArrayList<Ingredient>();
        Collection<MenuItem> localMenuItemCollection = new HashSet<MenuItem>();

        localIngredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));
        localIngredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        localMenuItemCollection.add(new MenuItem(3, 3000f, new Recipe(1,"name",  new Category(3, "testCategory1"), localIngredientList)));
        localMenuItemCollection.add(new MenuItem(4,4f, new Recipe(2,"name",  new Category(4, "testCategory2"), localIngredientList)));

        orderTest.setMenuItems(localMenuItemCollection);
        assertEquals(orderTest.getMenuItems(), localMenuItemCollection);
    }

    @Test
    public void calculateTotalPrice() throws Exception{
        assertEquals((long)orderTest.calculateTotalPrice(), (long)(3550f));
    }

    @Test(expected = NoDateException.class)
    public void noDateException() throws Exception{
        Order localOrder = new Order(1,null, menuItemCollection);
    }

    @Test(expected = NoMenuitemException.class)
    public void noMenuitemException() throws Exception{
        Collection<MenuItem> localMenuItemCollection = null;
        Order localOrder = new Order(1, new Date(2017-11-07), localMenuItemCollection);
    }

    @Test(expected = EmptyMenuitemException.class)
    public void emptyMenuitemCollection() throws Exception{
        Collection <MenuItem> localMenuItemCollection = new HashSet<MenuItem>();
        Order localOrder = new Order(1, new Date(2017-11-07), localMenuItemCollection);
    }
}
