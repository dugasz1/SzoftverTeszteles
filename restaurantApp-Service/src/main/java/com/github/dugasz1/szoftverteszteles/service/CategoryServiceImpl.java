package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.service.CategoryService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    @Override
    public void addCategory(Category category) throws StorageProblemException {
        try {
            categoryDAO.createCategory(category);
        } catch (AlreadyExistingException e) {
            throw new StorageProblemException(e);
        } catch (StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }

    }

    @Override
    public void updateCategor(Category category) throws StorageProblemException {
        try {
            categoryDAO.updateCategory(category);
        } catch (NotFoundException e) {
            throw new StorageProblemException(e);
        } catch (StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }

    @Override
    public Category getCategory(int id) throws StorageProblemException {
        try {
            return categoryDAO.getCategoryById(id);
        } catch (NotFoundException e) {
            throw new StorageProblemException(e);
        } catch (StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        } catch (StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    @Override
    public void deletaCategory(int id) throws StorageProblemException {
        try {
            categoryDAO.deleteCategory(id);
        } catch (NotFoundException e) {
            throw new StorageProblemException(e);
        } catch (StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }
}
