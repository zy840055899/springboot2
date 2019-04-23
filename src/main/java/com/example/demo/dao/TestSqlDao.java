package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface TestSqlDao {
    int testSql();

    void addMoney(@Param("id") String accountId, @Param("money") BigDecimal money);

    void minusMoney(@Param("id") String accountId, @Param("money") BigDecimal money);

}
