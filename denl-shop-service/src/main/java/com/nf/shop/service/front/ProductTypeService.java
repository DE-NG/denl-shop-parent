package com.nf.shop.service.front;

import com.nf.shop.entity.ProductType;

import java.util.List;

/**
 * Description: 商品类型信息业务层接口
 * @author DENG-
 */
public interface ProductTypeService {


    List<ProductType> findAllEnableProductTypes();

    List<ProductType> findAll(int pageNum,int pageSize);

    boolean addProductType(String name);

    ProductType findProductById(Integer id);

    boolean modifyProductTypeName(Integer id,String name);

    boolean modifyProductTypeStatus(Integer id);

    boolean removeProductType(Integer id);
}
