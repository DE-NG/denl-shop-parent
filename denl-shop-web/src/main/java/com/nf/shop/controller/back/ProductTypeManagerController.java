package com.nf.shop.controller.back;

import com.github.pagehelper.PageInfo;
import com.nf.shop.entity.ProductType;
import com.nf.shop.service.front.ProductTypeService;
import com.nf.shop.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author DENG-
 */
@Controller
@RequestMapping("/back/product_type")
@Slf4j
public class ProductTypeManagerController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/find_all")
    public String findAllType(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize,
                              Model model){
        List<ProductType> productTypes = productTypeService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(productTypes);
        model.addAttribute("pageInfo",pageInfo);
        return "productTypeManager";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseVO add(String name){
        if(productTypeService.addProductType(name)){
            return ResponseVO.newBuilder().code("200").msg("添加成功").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("添加失败").build();
        }
    }

    @RequestMapping("/findProductTypeById")
    @ResponseBody
    public ResponseVO findProductTypeById(int id){
        ProductType productType = productTypeService.findProductById(id);
        return ResponseVO.newBuilder().code("200").msg("查找成功").data(productType).build();
    }

    @RequestMapping("/modifyProductTypeName")
    @ResponseBody
    public ResponseVO modifyProductTypeName(int id,String name){
        if (productTypeService.modifyProductTypeName(id,name)){
            return ResponseVO.newBuilder().code("200").msg("修改成功").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("修改失败").build();
        }
    }

    @RequestMapping("/modifyProductTypeStatus")
    @ResponseBody
    public ResponseVO modifyProductTypeStatus(int id){
        if (productTypeService.modifyProductTypeStatus(id)){
            return ResponseVO.newBuilder().code("200").msg("修改状态成功").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("修改状态失败").build();
        }
    }

    @RequestMapping("/removeProductType")
    @ResponseBody
    public ResponseVO removeProductType(int id){
        if (productTypeService.removeProductType(id)){
            return ResponseVO.newBuilder().code("200").msg("删除成功").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("删除失败").build();
        }
    }
}
