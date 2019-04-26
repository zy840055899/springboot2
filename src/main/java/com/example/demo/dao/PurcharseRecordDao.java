package com.example.demo.dao;

import com.example.demo.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurcharseRecordDao {
    int addPurchaseRecord(PurchaseRecord record);
}
