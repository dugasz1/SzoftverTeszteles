package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;

public class  IngredientItem {
    private int id;
    private String name;
    private Nutritions nutrions;
    private String unit;

    /**
     * Creates IngredientItem object, do not use this use the dao interface.
     * @param id
     * @param name
     * @param nutritions
     * @param unit
     */

    public IngredientItem(int id, String name, Nutritions nutritions, String unit) throws NoNameException,NoIngredientException
    {
        if(name == null)
            throw new NoNameException("Item must have a name.");
        if(nutritions == null)
            throw new NoIngredientException("Ingredient must contain one value.");
        this.id = id;
        this.name = name;
        this.nutrions = nutritions;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public Nutritions getNutrions() {
        return nutrions;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setNutrions(Nutritions nutrions) {
        this.nutrions = nutrions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
