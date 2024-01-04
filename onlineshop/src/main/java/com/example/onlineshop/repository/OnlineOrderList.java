package com.example.onlineshop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.example.onlineshop.entity.OnlineOrderListEntity;
import com.example.onlineshop.repository.IOnlineOrderList;

@Repository
public class OnlineOrderList implements IOnlineOrderList {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class OnlineOrderListMapper implements RowMapper<OnlineOrderListEntity> {

        @Override
        public OnlineOrderListEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            OnlineOrderListEntity entity = new OnlineOrderListEntity();
            entity.setListNo(rs.getInt("LIST_NO"));
            entity.setCollectNo(rs.getString("COLLECT_NO"));
            entity.setProductCode(rs.getString("PRODUCT_CODE"));
            entity.setOrderCount(rs.getInt("ORDER_COUNT"));
            entity.setOrderPrice(rs.getInt("ORDER_PRICE"));
            return entity;
        }

    }

    @Override
    public OnlineOrderListEntity findById(String id) { return null; }

    @Override
    public List<OnlineOrderListEntity> findAll() {

        return null;
    }

    @Override
    public int insert(OnlineOrderListEntity entity) {
        return -1;
    }

    @Override
    public int update(OnlineOrderListEntity entity) {
        return -1;
    }

    @Override
    public int delete(int listNo) {
        return -1;
    }

}