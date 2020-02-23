package com.nf.shop.dao.front;

import com.nf.shop.entity.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:商品类型dao层接口
 * @author DENG-
 */
public interface ProductTypeDao {

    /**
     *功能描述: 查找所有启用的（有效的）商品类型
     */
    List<ProductType> findAllEnableProductTypes(int status);

    List<ProductType> selectAll(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    /**
     * 添加商品类型
     * @param name
     * @param status
     * @return
     */
    int insertProductType(@Param("name") String name,@Param("status") int status);

    ProductType selectProductTypeById(Integer id);

    int updateProductTypeName(@Param("id") int id, @Param("name") String name);

    int updateProductTypeStatus(@Param("id") int id,@Param("status") int status);

    int deleteProductType(int id);

}
