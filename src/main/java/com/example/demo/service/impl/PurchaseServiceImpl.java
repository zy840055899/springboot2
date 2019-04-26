package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.PurchaseRecordDao;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.PurchaseRecord;
import com.example.demo.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    @Resource
    ProductDao productDao;

    @Resource
    PurchaseRecordDao purchaseRecordDao;

    @Override
    @Transactional
    public boolean purchaseProduct(long userId, long productId, int quantity) {

        Product product = productDao.getSingleProduct(productId);
        if (quantity > product.getStock()) {
            logger.info("商品：" + product + "库存不足" + quantity);
            return false;
        }
        // 扣减库存
        productDao.decreaseStock(productId, quantity);
        // 新增购买记录
        purchaseRecordDao.addPurchaseRecord(initPurchaseRecord(userId, product, quantity));

        return true;
    }

    private PurchaseRecord initPurchaseRecord(long userId, Product product, int quantity) {
        PurchaseRecord record = new PurchaseRecord();
        record.setNote("购买时间：" + System.currentTimeMillis());
        record.setPrice(product.getPrice());
        record.setProductId(product.getId());
        record.setQuantity(quantity);
        record.setSum(product.getPrice() * quantity);
        record.setUserId(userId);
        return record;
    }

}
