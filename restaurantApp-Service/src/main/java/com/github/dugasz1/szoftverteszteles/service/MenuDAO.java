package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.menu.MenuItem;

public interface MenuDAO {
    public MenuItem Get(int id);

    public boolean Update(int id);
    public boolean Update(MenuItem recipe);

    public boolean Delete(int id);
    public boolean Delete(MenuItem recipe);
}
