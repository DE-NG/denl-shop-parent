package com.nf.shop.dao.front;


import com.nf.shop.entity.Product;
import com.nf.shop.params.ProductParam;
import com.nf.shop.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: 小莫
 * Date: 2019-03-10 10:39
 * Description: 商品数据操作层接口
 * @author DENG-
 */
public interface ProductDao {

    /**
     *
     * @param id
     * @return
     */
    Product selectProductById(int id);

    List<Product> selectByProductParams(ProductParam productParam);

    List<Product> selectAllProduct(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    int insertProduct(ProductVO productVO);

    int updateProduct(ProductVO productVO);

    int deleteProduct(int id);
}
