package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

public interface IngredientDAO {
    IngredientItem getIngredientItem(int id);

    boolean updateIngredientItem(int id);

    boolean updateIngredientItem(IngredientItem recipe);

    boolean deleteIngredientItem(int id);

    boolean deleteIngredientItem(IngredientItem recipe);
}
