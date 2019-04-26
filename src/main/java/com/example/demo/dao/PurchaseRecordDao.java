package com.example.demo.dao;

import com.example.demo.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRecordDao {
    int addPurchaseRecord(PurchaseRecord record);
}
