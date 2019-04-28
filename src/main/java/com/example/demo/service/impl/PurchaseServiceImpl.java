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

        long start = System.currentTimeMillis();

        while (true){
            long end = System.currentTimeMillis();

            if(end - start > 200){
                logger.info("用户："+userId+"库存不确定，200ms内重复下单也没成功，终止下单");
                return false;
            }

            Product product = productDao.getSingleProduct(productId);
            if (quantity > product.getStock()) {
                logger.info("商品：" + product.getId() + "库存不足" + quantity);
                return false;
            }
            /*乐观锁*/
            long version = product.getVersion();
            // 乐观锁,减库存
            int result = productDao.decreaseStock2(productId, quantity, version);
            // 悲观锁，扣减库存
            //productDao.decreaseStock(productId, quantity);

            if (result == 0) {
                logger.info("商品：" + product.getId() + "库存不确定，继续尝试下单");
                continue;
            }
            // 新增购买记录
            purchaseRecordDao.addPurchaseRecord(initPurchaseRecord(userId, product, quantity));
            return true;
        }

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
