package com.nf.shop.service.front;

import com.nf.shop.entity.Product;
import com.nf.shop.params.ProductParam;
import com.nf.shop.vo.ProductVO;

import java.util.List;

/**
 * Description: 商品业务层接口
 * @author DENG-
 */
public interface ProductService {

    /**
     *功能描述: 根据id 查找商品信息
     */
    Product findProductById(int id);

    List<Product> findByProductParams(ProductParam productParam);

    /**
     * 分页查询所有的商品
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Product> findAllProduct(int pageNum,int pageSize);

    boolean addProduct(ProductVO productVO);

    boolean modifyProduct(ProductVO productVO);

    boolean removeProduct(int id);
}
