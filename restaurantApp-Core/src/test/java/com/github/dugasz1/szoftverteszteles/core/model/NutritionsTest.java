package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NutritionsTest {

    private Nutritions testNutritions = null;

    @Before
    public void setUp() throws Exception{
        testNutritions = new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f);
    }

    @Test
    public void getEnergy() throws Exception {
        assertEquals((long) testNutritions.getEnergy(), (long) 1.1f);
    }

    @Test
    public void getFat() throws Exception{
        assertEquals((long)testNutritions.getFat(), (long)2.2f);
    }

    @Test
    public void getCarbohydrate() throws Exception{
        assertEquals((long)testNutritions.getCarbohydrate(),(long)3);
    }

    @Test
    public void getProtein() throws Exception{
        assertEquals((long)testNutritions.getProtein(),(long)4);
    }

    @Test
    public void getSalt() throws Exception{
        assertEquals((long)testNutritions.getSalt(),(long)5);
    }

    @Test
    public void setEnergy() throws Exception{
        Nutritions localNutritions = new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f);
        localNutritions.setEnergy(11.1f);
        assertEquals((long)localNutritions.getEnergy(),(long)11.1f);
    }


    @Test
    public void setFat() throws Exception{
        Nutritions localNutritions = new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f);
        localNutritions.setFat(22.2f);
        assertEquals((long)localNutritions.getFat(),(long)22.2f);
    }


    @Test
    public void setCarbohydrate() throws Exception{
        Nutritions localNutritions = new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f);
        localNutritions.setCarbohydrate(33.3f);
        assertEquals((long)localNutritions.getCarbohydrate(),(long)33.3f);
    }


    @Test
    public void setProtein() throws Exception{
        Nutritions localNutritions = new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f);
        localNutritions.setProtein(44.4f);
        assertEquals((long)localNutritions.getProtein(),(long)44.4f);
    }


    @Test
    public void setSalt() throws Exception{
        Nutritions localNutritions = new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f);
        localNutritions.setSalt(55.5f);
        assertEquals((long)localNutritions.getSalt(),(long)55.5f);
    }

    @Test
    public void equals() throws Exception{
        Nutritions sameNutritions = new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f);
    }
}
