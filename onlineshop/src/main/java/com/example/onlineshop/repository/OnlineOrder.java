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

import com.example.onlineshop.entity.OnlineOrderEntity;


@Repository
public class OnlineOrder implements IOnlineOrder {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class OnlineOrderMapper implements RowMapper<OnlineOrderEntity>  {

        @Override
        public OnlineOrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            OnlineOrderEntity entity = new OnlineOrderEntity();
            entity.setOrderNo(rs.getInt("ORDER_NO"));
            entity.setMemberNo(rs.getInt("MEMBER_NO"));
            entity.setTotalMoney(rs.getInt("TOTAL_MONEY"));
            entity.setTotalTax(rs.getInt("TOTAL_TAX"));
            entity.setOrderDate(rs.getDate("ORDER_DATE"));
            entity.setCollectNo(rs.getString("COLLECT_NO"));
            entity.setLstUpdDate(rs.getTimestamp("LAST_UPD_DATE"));
            return entity;
        }
    }

    @Override
    public OnlineOrderEntity findById(String oid) {return null;}

    @Override
    public List<OnlineOrderEntity> findAll() {return null;}

    @Override
    public int insert(OnlineOrderEntity entity) {return -1;}

    @Override
    public int update(OnlineOrderEntity entity) {return -1;}

    @Override
    public int delete(int orderNo) {return -1;}

}