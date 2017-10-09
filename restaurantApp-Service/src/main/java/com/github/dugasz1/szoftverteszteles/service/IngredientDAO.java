package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.menu.IngredientItem;

public interface IngredientDAO {
    public IngredientItem getIngredientItem(int id);

    public boolean updateIngredientItem(int id);
    public boolean updateIngredientItem(IngredientItem recipe);

    public boolean deleteIngredientItem(int id);
    public boolean deleteIngredientItem(IngredientItem recipe);
}
