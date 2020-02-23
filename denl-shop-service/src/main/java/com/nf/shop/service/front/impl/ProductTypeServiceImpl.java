package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.ProductTypeDao;
import com.nf.shop.entity.ProductType;
import com.nf.shop.service.front.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:商品类型业务实现类
 * @author DENG-
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public List<ProductType> findAllEnableProductTypes() {
        return productTypeDao.findAllEnableProductTypes(1);
    }


    /**
     * 分页查找所有商品类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ProductType> findAll(int pageNum, int pageSize) {
        return productTypeDao.selectAll(pageNum, pageSize);
    }

    @Override
    public boolean addProductType(String name) {
        if ( productTypeDao.insertProductType(name,1) > 0){
            return true;
        }
        return false;
    }

    @Override
    public ProductType findProductById(Integer id) {
        return productTypeDao.selectProductTypeById(id);
    }

    @Override
    public boolean modifyProductTypeName(Integer id, String name) {
        if (productTypeDao.updateProductTypeName(id,name) >0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyProductTypeStatus(Integer id) {
        ProductType productType = productTypeDao.selectProductTypeById(id);
        int status = productType.getStatus();
        if (status == 1){
            status = 0;
        }else {
            status = 1;
        }
        return productTypeDao.updateProductTypeStatus(id,status) > 0 ? true:false;
    }

    @Override
    public boolean removeProductType(Integer id) {

        return productTypeDao.deleteProductType(id) > 0 ? true : false;
    }

}
