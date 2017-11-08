package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.EmptyNameException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;

public class  IngredientItem {
    private int id;
    private String name;
    private Nutritions nutritions;
    private String unit;

    /**
     * Creates IngredientItem object, do not use this use the dao interface.
     * @param id
     * @param name
     * @param nutritions
     * @param unit
     */

    public IngredientItem(int id, String name, Nutritions nutritions, String unit) throws NoNameException, NoIngredientException, EmptyNameException {
        this.id = id;
        setName(name);
        setNutritions(nutritions);
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setNutritions(Nutritions nutritions) throws NoIngredientException {
        if(nutritions == null)
            throw new NoIngredientException("Ingredient must contain one value.");
        this.nutritions = nutritions;
    }

    public void setName(String name) throws NoNameException, EmptyNameException {
        if(name == null)
            throw new NoNameException("Item must have a name.");
        if(name == "")
            throw new EmptyNameException("Item must have a name.");
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientItem that = (IngredientItem) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!nutritions.equals(that.nutritions)) return false;
        return unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + nutritions.hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }
}
