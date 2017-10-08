package com.github.dugasz1.szoftverteszteles.core.menu;

public class IngredientItem {
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

    public IngredientItem(int id, String name, Nutritions nutritions, String unit)
    {
        if(name == null)
            throw new NullPointerException("Name cannot be null.");
        if(nutritions == null)
            throw new NullPointerException("Ingredient must be contain one value.");
        this.id = id;
        this.name = name;
        this.nutrions = nutritions;
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
