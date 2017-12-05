package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

public interface CategoryDAO {

    public void createCategory(Category category) throws AlreadyExistingException,StorageNotAvailableException;

    public void deleteCategory(int id) throws NotFoundException,StorageNotAvailableException;

    public void updateCategory(Category category)throws NotFoundException,StorageNotAvailableException;

    public Category getCategoryById(int id) throws NotFoundException,StorageNotAvailableException,StorageException;
}
