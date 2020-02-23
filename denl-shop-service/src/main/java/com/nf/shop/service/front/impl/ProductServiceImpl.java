package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.ProductDao;
import com.nf.shop.entity.Product;
import com.nf.shop.params.ProductParam;
import com.nf.shop.service.front.ProductService;
import com.nf.shop.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date: 2019-03-10 10:18
 * Description:  商品业务层接口实现
 * @author DENG-
 */
@Service
@Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     *功能描述: 根据 id 查找商品
     */
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    @Override
    public Product findProductById(int id) {
        return productDao.selectProductById(id);
    }

    /**
     *功能描述: 修改商品
     */


    /**
     *功能描述: 多条件查找商品
     */
    @Override
    public List<Product> findByProductParams(ProductParam productParam) {
        return productDao.selectByProductParams(productParam);
    }

    @Override
    public List<Product> findAllProduct(int pageNum, int pageSize) {
        return productDao.selectAllProduct(pageNum, pageSize);
    }

    @Override
    public boolean addProduct(ProductVO productVO) {
        return productDao.insertProduct(productVO) > 0 ? true:false;
    }

    @Override
    public boolean modifyProduct(ProductVO productVO) {
        return productDao.updateProduct(productVO) > 0 ? true : false;
    }

    @Override
    public boolean removeProduct(int id) {
        return productDao.deleteProduct(id) > 0 ? true : false;
    }
}
