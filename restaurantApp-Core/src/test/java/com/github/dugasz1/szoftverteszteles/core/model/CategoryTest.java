package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    private Category testCategory = null;

    @Before
    public void setUp() throws Exception{
        testCategory = new Category(1, "testcategory");
    }

    @Test
    public void getId() throws Exception{
        assertEquals(testCategory.getId(), 1);
    }

    @Test
    public void getName() throws Exception{
        assertEquals(testCategory.getName(), "testcategory");
    }

    @Test
    public void setName() throws Exception{
        Category localCategory = new Category(2,"localCategory");
        localCategory.setName("renamed");
        assertEquals(localCategory.getName(), "renamed");
    }

    @Test
    public void setId() throws Exception{
        Category localCategory = new Category(3,"localCategory");
        localCategory.setId(300);
        assertEquals(localCategory.getId(),300);
    }

    @Test
    public void equals() throws Exception{
        Category sameCategory = new Category(1,"testcategory");
        assertTrue(testCategory.equals(sameCategory));
    }

}
