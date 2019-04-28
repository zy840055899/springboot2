package com.example.demo.dao;

import com.example.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface ProductDao {
    Product getSingleProduct(long id);
    int decreaseStock(@Param("id") long productId, @Param("quantity") int quantity);
    int decreaseStock2(@Param("id") long productId, @Param("quantity") int quantity, @Param("version")long version);
}
