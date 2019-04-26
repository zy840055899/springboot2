package com.example.demo.service;

public interface PurchaseService {
    /**
     * 购买业务
     *
     * @param userId    用户id
     * @param productId 商品id
     * @param quantity  数量
     * @return 成功或者失败
     */
    boolean purchaseProduct(long userId, long productId, int quantity);
}
