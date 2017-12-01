package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

public interface MenuService {

    void createMenuItem(MenuItem menuItem) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    MenuItem getMenuItem(int id) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    boolean updateMenuItem(int id) throws StorageProblemException, ExistingProblemException;

    boolean updateMenuItem(MenuItem recipe) throws StorageProblemException, ExistingProblemException;

    boolean deleteMenuItem(int id) throws StorageProblemException, ExistingProblemException;

    boolean deleteMenuItem(MenuItem recipe) throws StorageProblemException, ExistingProblemException;
}
