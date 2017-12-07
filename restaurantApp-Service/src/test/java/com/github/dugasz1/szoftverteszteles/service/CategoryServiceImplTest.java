package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.*;

public class CategoryServiceImplTest {
    private CategoryServiceImpl categoryService;

    static Category leves;
    static Category teszta;
    static Category nokedli;
    static Category parizel;
    static Category rizs;
    @BeforeClass
    public static void beforeClass() throws Exception {
        leves = new Category(1,"Leves");
        teszta = new Category(2,"Teszta");
        nokedli = new Category(3,"Nokedli");
        parizel = new Category(4,"Parizel");
        rizs = new Category(5,"Rizs");


    }

    @Before
    public void setUp() throws StorageException, NotFoundException, StorageNotAvailableException, AlreadyExistingException, NoNameException {
        CategoryDAO categoryDAO = EasyMock.createMock(CategoryDAO.class);

        EasyMock.expect(categoryDAO.getCategoryById(1)).andReturn(leves);
        EasyMock.expect(categoryDAO.getCategoryById(2)).andReturn(teszta);
        EasyMock.expect(categoryDAO.getCategoryById(3)).andReturn(nokedli);
        EasyMock.expect(categoryDAO.getCategoryById(4)).andReturn(parizel);
        EasyMock.expect(categoryDAO.getCategoryById(5)).andReturn(rizs);

        categoryDAO.createCategory(nokedli);

        categoryDAO.createCategory(teszta);
        EasyMock.expectLastCall().andThrow(new AlreadyExistingException());

        categoryDAO.createCategory(parizel);
        EasyMock.expectLastCall().andThrow(new AlreadyExistingException());

        categoryDAO.createCategory(rizs);
        EasyMock.expectLastCall().andThrow(new AlreadyExistingException());

        categoryDAO.deleteCategory(5);
        categoryDAO.getCategoryById(5);
        EasyMock.expectLastCall().andThrow(new NotFoundException());

        categoryDAO.updateCategory(new Category(3, "kifi"));
        EasyMock.expect(categoryDAO.getCategoryById(3)).andReturn(new Category(3,"kifli"));

        EasyMock.replay(categoryDAO);
        this.categoryService = new CategoryServiceImpl(categoryDAO);
    }

    @Test
    public void getCategoryNokedli() throws Exception {
        assertEquals(categoryService.getCategory(3), nokedli);
    }

    @Test
    public void addCategory() throws Exception {
        categoryService.addCategory(nokedli);
    }

    @Test
    public void addCategoryLeves() throws Exception {
        categoryService.addCategory(leves);
    }

    @Test
    public void getCategoryLeves() throws Exception {
        assertEquals(categoryService.getCategory(1),leves);
    }

    @Test
    public void getCategoryParizel() throws Exception {
        assertEquals(categoryService.getCategory(1),parizel);
    }


    @Test
    public void getCategoryRizs() throws Exception {
        assertEquals(categoryService.getCategory(1),rizs);
    }

    @Test
    public void deletaCategory() throws Exception {
        assertNull(categoryService.getCategory(5));
    }

    @Test
    public void updateCategory() throws Exception{
        assertEquals(categoryService.getCategory(3), nokedli);
    }

}