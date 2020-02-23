package com.nf.shop.controller.back;

import com.github.pagehelper.PageInfo;
import com.nf.shop.entity.Product;
import com.nf.shop.entity.ProductType;
import com.nf.shop.service.front.ProductService;
import com.nf.shop.service.front.ProductTypeService;
import com.nf.shop.vo.ProductVO;
import com.nf.shop.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author DENG-
 */
@Controller
@RequestMapping("/back/product")
public class ProductManagerController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @ModelAttribute("productTypes")
    public List<ProductType> loadProductTypes() {
        List<ProductType> productTypes = productTypeService.findAllEnableProductTypes();
        return productTypes;
    }

    @RequestMapping("/findAllProduct")
    public String findAllProduct(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize,
                                 Model model){
        List<Product> products = productService.findAllProduct(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(products);
        model.addAttribute("pageInfo",pageInfo);
        return "productManager";
    }

    @RequestMapping("/addProduct")
    public String addProduct(ProductVO productVO , Integer pageNum, HttpSession session ,Model model){
        String filePath = "E:\\IdeaProjects\\denl-shop-parent\\denl-shop-web\\src\\main\\resources\\static\\images";
        String originalFilename = productVO.getMultipartFile().getOriginalFilename();
        String path = filePath + File.separator + originalFilename;
        File file = new File(path);
        String newFile = "/static/images/" + originalFilename;
        ProductVO productVO1 = new ProductVO(productVO.getName(),productVO.getPrice(),productVO.getInfo(),newFile,productVO.getProductTypeId());
        try{
            productVO.getMultipartFile().transferTo(file);
            productService.addProduct(productVO1);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("failMsg", "添加失败");
        }
        model.addAttribute("successMsg", "添加成功");
        return "forward:findAllProduct?pageNum="+pageNum;
    }

    @RequestMapping("/findProductById")
    @ResponseBody
    public ResponseVO findProductById(int id){
        Product product = productService.findProductById(id);
        if (product != null){
            return ResponseVO.newBuilder().code("200").msg("成功").data(product).build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("失败").build();
        }
    }

    @RequestMapping("/modifyProduct")
    @ResponseBody
    public ResponseVO modifyProduct(ProductVO productVO, HttpSession session){
        System.out.println("productVO = " + productVO);
        ProductVO productVO1 = null;
        if (productVO.getMultipartFile() == null){
            productVO1 = new ProductVO(productVO.getId(),productVO.getName(),productVO.getPrice(),productVO.getInfo(),productVO.getProductTypeId());

            if (productService.modifyProduct(productVO1)){
                return ResponseVO.newBuilder().code("200").msg("修改成功").build();
            }else {
                return ResponseVO.newBuilder().code("500").msg("修改失败").build();
            }
        }else {
            String filePath = "E:\\IdeaProjects\\denl-shop-parent\\denl-shop-web\\src\\main\\resources\\static\\images";
            String originalFilename = productVO.getMultipartFile().getOriginalFilename();
            String path = filePath + File.separator + originalFilename;
            File file = new File(path);
            String newFile = "/static/images/" + originalFilename;
            productVO1 = new ProductVO(productVO.getId(),productVO.getName(), productVO.getPrice(), productVO.getInfo(), newFile, productVO.getProductTypeId());
            try {
                productVO.getMultipartFile().transferTo(file);
                productService.modifyProduct(productVO1);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseVO.newBuilder().code("500").msg("修改失败").build();
            }
            return ResponseVO.newBuilder().code("200").msg("修改成功").build();
        }
    }

    @RequestMapping("/removeProductById")
    @ResponseBody
    public ResponseVO removeProductById(int id){
        if (productService.removeProduct(id)){
            return ResponseVO.newBuilder().code("200").msg("删除成功").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("删除失败").build();
        }
    }
}
