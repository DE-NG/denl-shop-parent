package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.CartDao;
import com.nf.shop.dao.front.ProductDao;
import com.nf.shop.entity.Cart;
import com.nf.shop.entity.Product;
import com.nf.shop.exception.OrderCartNotFoundException;
import com.nf.shop.service.front.CartService;
import com.nf.shop.vo.CartVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 购物车业务实现类
 * @Author:DENG-
 * @Date:2019/12/11 10:45
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Cart> findCustomerAllCarts(Integer customerId) {
        return cartDao.selectAllCartByCustomerId(customerId);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Boolean saveToCart(CartVO cartVo) {
        Cart cartResult = cartDao.selectCartByCustomerIdAndProductId(cartVo.getCustomerId(),cartVo.getProductId());

        if (cartResult == null){
            Cart cart = new Cart();
            Product product = productDao.selectProductById(cartVo.getProductId());
            //计算总价
            Double totalPrice = product.getPrice() * cartVo.getProductNum();

            BeanUtils.copyProperties(cartVo,cart);
            cart.setTotalPrice(totalPrice);
            cart.setProduct(product);
            cart.setCreateTime(new Date());
            cart.setStatus(1);

            int rows = cartDao.insertCart(cart);

            if(rows >= 1){
                return true;
            }else {
                return false;
            }
        }

        /**
         * 如果购物车中已存在该商品则直接修改数量就可以了
         */
        int products = cartResult.getProductNum() + cartVo.getProductNum();
        Product product = productDao.selectProductById(cartVo.getProductId());
        Double totalPrice = product.getPrice() * products;

        int rows = cartDao.updateCartNumAndTotalPriceById(cartResult.getId(),products,totalPrice);
        if (rows >= 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 清空用户的购物车
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Boolean modifyCartStatus(Integer id) {
        int rows = cartDao.updateCartStatusByCustomerId(id,0);
        if (rows > 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 清空购物车中的某一商品
     * @param cartId
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Boolean modifyCartStatusByCartIdAndCustomerId(Integer cartId, Integer id) {
        int rows = cartDao.updateCartStatusByCartIdAndCustomerId(cartId,id,0);
        if (rows > 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 从购物车中移除选中的商品
     * @param cartIds
     * @param customerId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Boolean modifyCartStatusByCartIdAndCustomerIds(Integer[] cartIds, Integer customerId) {
        int rows = cartDao.updateCartStatusByCartIdAndCustomerIds(cartIds,customerId,0);
        if (rows > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Boolean modifyNumAndPriceByCartIdAndCustomerIdAndStatus(Integer cartId, Integer productNum, Integer id) {
        Cart cart = cartDao.selectCartByCustomerIdAndCartId(id,cartId);
        Double totalPrice = (cart.getProduct().getPrice()) * productNum;

        int rows = cartDao.updateProductNumAndPriceByCartIdAndCustomerIdAndStatus(cartId,productNum,id,1,totalPrice);
        if (rows > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Cart> findCartByCartIdsAndCustomerId(Integer[] orderCartIds, Integer id) {
        List<Cart> cartList = cartDao.selectCartByCartIdsAndCustomerId(orderCartIds, id, 1);

        if (cartList.size() == 0) {
            throw new OrderCartNotFoundException("购物车信息不存在");
        }
        return cartList;
    }

    @Override
    public List<Cart> findRedirectCartByCartIdsAndCustomerId(Integer[] orderCartIds, Integer id) {
        List<Cart> cartList = cartDao.selectRedirectCartByCartIdsAndCustomerId(orderCartIds,id,2);
        if (cartList.size() == 0){
            throw new OrderCartNotFoundException("购物车信息不存在");
        }
        return cartList;
    }

    @Override
    public int redirectToCart(CartVO cartVo) {
        Cart cart = cartDao.selectRedirectCartByCustomerIdAndProductId(cartVo.getCustomerId(),cartVo.getProductId());

        if (cart == null){
            Cart cart1 = new Cart();
            Product product = productDao.selectProductById(cartVo.getProductId());

            Double totalPrice = product.getPrice() * cartVo.getProductNum();

            BeanUtils.copyProperties(cartVo,cart1);
            cart1.setTotalPrice(totalPrice);
            cart1.setCreateTime(new Date());
            cart1.setProduct(product);
            cart1.setStatus(2);

            int rows = cartDao.insertCart(cart1);
            if (rows > 0){
                return cart1.getId();
            }else {
                return 0;
            }
        }

        int productNum = cartVo.getProductNum();

        Product product = productDao.selectProductById(cartVo.getProductId());

        Double totalPrice = product.getPrice() * productNum;
        int rows = cartDao.updateCartNumAndTotalPriceById(cart.getId(),productNum,totalPrice);
        if (rows > 0){
            return cart.getId();
        }
        return 0;
    }
}
