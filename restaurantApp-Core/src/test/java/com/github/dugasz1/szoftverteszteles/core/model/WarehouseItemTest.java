package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoDateException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientItemException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoUserException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class WarehouseItemTest {
    private WarehouseItem testWarehouseItem = null;
    private IngredientItem testIngredientItem = null;

    @Before
    public void setUp() throws Exception{
        testIngredientItem = new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit");
        testWarehouseItem = new WarehouseItem(1, testIngredientItem, new User(1, "tesztuser"),
                        new Date(2017-11-8), new Date(2017-12-8));
    }

    @Test
    public void getId() throws Exception{
        assertEquals(testWarehouseItem.getId(), 1);
    }

    @Test
    public void getIngredientItem() throws Exception{
        IngredientItem localIngredientItem = new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit");

        assertEquals(testWarehouseItem.getIngredientItem(), localIngredientItem);
    }

    @Test
    public void getUser() throws Exception{
        User localUser = new User(1, "tesztuser");
        assertEquals(testWarehouseItem.getUser(), localUser);
    }

    @Test
    public void setUser()throws Exception{
        User localUser = new User(2, "localuser");
        testWarehouseItem.setUser(localUser);
        assertEquals(testWarehouseItem.getUser(),localUser);
    }

    @Test
    public void setIngredientItem()throws Exception{
        IngredientItem localIngredientItem = new IngredientItem(2, "localingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "localtestunit");
        testWarehouseItem.setIngredientItem(localIngredientItem);
        assertEquals(testWarehouseItem.getIngredientItem(),localIngredientItem);
    }

    @Test
    public void getRegistered() throws Exception{
        assertEquals(testWarehouseItem.getRegistered(), new Date(2017-11-8));
    }

    @Test
    public void setRegistered() throws Exception{
        testWarehouseItem.setRegistered(new Date(2017-12-25));
        assertEquals(testWarehouseItem.getRegistered(), new Date(2017-12-25));
    }

    @Test
    public void getWarrant() throws Exception{
        assertEquals(testWarehouseItem.getWarrant(), new Date(2017-12-8));
    }

    @Test
    public void setWarrant() throws Exception{
        testWarehouseItem.setWarrant(new Date(2017-12-26));
        assertEquals(testWarehouseItem.getWarrant(), new Date(2017-12-26));
    }

    @Test
    public void equals() throws Exception{
        WarehouseItem localWarehouseItem = new WarehouseItem(1, new IngredientItem(1, "testingredientitem",
                        new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), new User(1, "tesztuser"),
                new Date(2017-11-8), new Date(2017-12-8));

        assertEquals(testWarehouseItem,localWarehouseItem);
    }

    @Test(expected = NoIngredientItemException.class)
    public void noIngredientException() throws Exception{
        WarehouseItem localWarehouseItem = new WarehouseItem(1, null, new User(1, "tesztuser"),
                new Date(2017-11-8), new Date(2017-12-8));
    }

    @Test(expected = NoUserException.class)
    public void noUserException() throws Exception{
        WarehouseItem localWarehouseItem = new WarehouseItem(1, new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), null,
                new Date(2017-11-8), new Date(2017-12-8));
    }

    @Test(expected = NoDateException.class)
    public void noRegistratedDateException() throws Exception{
        WarehouseItem localWarehouseItem = new WarehouseItem(1, new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), new User(1, "tesztuser"),
                null, new Date(2017-12-8));
    }

    @Test(expected = NoDateException.class)
    public void noWarrantDateException() throws Exception{
        WarehouseItem localWarehouseItem = new WarehouseItem(1, new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), new User(1, "tesztuser"),
                new Date(2017-11-8), null);
    }

    @Test
    public void notEquals() throws Exception {
        WarehouseItem notSameWHItem = new WarehouseItem(22, testIngredientItem, new User(2, "tuser"),
                new Date(2017-12-26), new Date(2018-12-26));
        assertFalse(testWarehouseItem.equals(notSameWHItem));
    }

    @Test
    public void equalsWrongObj() throws Exception {
        Category category = new Category(1, "tcat");
        assertFalse(testWarehouseItem.equals(category));
    }

    @Test
    public void equalsNull() throws Exception {
        assertFalse(testWarehouseItem.equals(null));
    }

    @Test
    public void equalsSameObject() throws Exception {
        assertTrue(testWarehouseItem.equals(testWarehouseItem));
    }
}
