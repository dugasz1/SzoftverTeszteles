package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.menu.IngredientItem;

public interface IngredientDAO {
    public IngredientItem Get(int id);

    public boolean Update(int id);
    public boolean Update(IngredientItem recipe);

    public boolean Delete(int id);
    public boolean Delete(IngredientItem recipe);
}
