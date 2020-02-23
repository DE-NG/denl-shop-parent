package com.nf.shop.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nf.shop.entity.Product;
import com.nf.shop.entity.ProductType;
import com.nf.shop.params.ProductParam;
import com.nf.shop.service.front.ProductService;
import com.nf.shop.service.front.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description: 前台商品接口
 * @author DENG-
 */
@Controller
@RequestMapping("/front/product")
public class ProductController {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;

    /**
     *功能描述: 加载所有商品列表
     */
    @RequestMapping("/searchAllProducts")
    public String searchAllProducts(ProductParam productParam, Integer pageName, Model model){
        if (ObjectUtils.isEmpty(pageName)) {
            pageName = 1;
        }
        PageHelper.startPage(pageName,20);
        List<Product> productList = productService.findByProductParams(productParam);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        model.addAttribute("pageInfo",pageInfo);
        return "main";
    }

    @RequestMapping("/selectAllProduct")
    public String selectAllProduct(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "8")int pageSize,
                                   Model model){
        List<Product> products = productService.findAllProduct(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(products);
        model.addAttribute("pageInfo",pageInfo);
        return "allProduct";
    }

    /**
     *功能描述: 页面初始化
     */
    @ModelAttribute("productTypes")
    public List<ProductType> loadProductTypes(){
        List<ProductType> productTypes = productTypeService.findAllEnableProductTypes();
        return productTypes;
    }

    /**
     *功能描述: 展示商品详情
     */
    @RequestMapping("showProductDetail")
    public String showProductDetail(Model model, Integer id) {

        Product product = productService.findProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
        }
        return "productDetail";
    }
}
