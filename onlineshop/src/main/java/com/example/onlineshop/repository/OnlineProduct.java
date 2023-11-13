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
import com.example.onlineshop.model.SearchModel;
import com.example.onlineshop.repository.IOnlineProduct;

@Repository
public class OnlineProduct implements IOnlineProduct {

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

    @Override
    public List<OnlineProductEntity> findAll() {
        String sql = "select * from ONLINE_PRODUCT";
        return jdbcTemplate.query(sql, new OnlineProductMapper());
    }

    @Override
    public OnlineProductEntity findById(String productCode) {
        String sql = "select * from ONLINE_PRODUCT where PRODUCT_CODE = ?";
        return jdbcTemplate.queryForObject(sql, new OnlineProductMapper(), productCode);
    }

    @Override
    public List<OnlineProductEntity> findSelect(SearchModel model) {return null;}

    
}