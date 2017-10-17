package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

public interface IngredientService {
    public IngredientItem getIngredientItem(int id);

    public boolean updateIngredientItem(int id);
    public boolean updateIngredientItem(IngredientItem recipe);

    public boolean deleteIngredientItem(int id);
    public boolean deleteIngredientItem(IngredientItem recipe);
}
