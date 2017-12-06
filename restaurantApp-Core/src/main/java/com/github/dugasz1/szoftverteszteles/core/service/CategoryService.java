package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

public interface CategoryService {

    public void addCategory(Category category) throws StorageProblemException;

    public void updateCategor(Category category) throws StorageProblemException;

    public Category getCategory(int id) throws StorageProblemException;

    public void deletaCategory(int id) throws StorageProblemException;
}
