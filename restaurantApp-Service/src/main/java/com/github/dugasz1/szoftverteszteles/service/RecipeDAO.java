package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.menu.Recipe;

public interface RecipeDAO {
    public Recipe Get(int id);

    public boolean Update(int id);
    public boolean Update(Recipe recipe);

    public boolean Delete(int id);
    public boolean Delete(Recipe recipe);
}
