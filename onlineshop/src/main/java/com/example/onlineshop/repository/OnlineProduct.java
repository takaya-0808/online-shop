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

import com.example.onlineshop.entity.OnlineProductEntity;

@Repository
public class OnlineProduct {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class OnlineProductMapper implements RowMapper<OnlineProductEntity>  {

        @Override
        public OnlineProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            OnlineProductEntity entity = new OnlineProductEntity();
            entity.setProductCode(rs.getString("PRODUCT_CODE"));
            entity.setCategoryId(rs.getInt("CATEGORY_ID"));
            entity.setProductName(rs.getString("PRODUCT_NAME"));
            entity.setMaker(rs.getString("MAKER"));
            entity.setCountStock(rs.getInt("STOCK_COUNT"));
            entity.setRegisterDate(rs.getDate("REGISTER_DATE"));
            entity.setUnitPrice(rs.getInt("UNIT_PRICE"));
            entity.setPictureName(rs.getString("PICTURE_NAME"));
            entity.setMemo(rs.getString("MEMO"));
            entity.setDelFlg(rs.getString("DELETE_FLG"));
            entity.setLastUpdDate(rs.getDate("LAST_UPD_DATE"));
            return entity;

        }
    }

    public List<OnlineProductEntity> findAll() {
        String sql = "select * from ONLINE_PRODUCT";
        OnlineProductMapper memberMapper = new OnlineProductMapper();
        return jdbcTemplate.query(sql, memberMapper);
    }

}