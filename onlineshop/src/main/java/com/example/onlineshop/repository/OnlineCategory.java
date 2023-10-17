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

import com.example.onlineshop.entity.OnlineCategoryEntity;

@Repository
public class OnlineCategory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class OnlineCategoryMapper implements RowMapper<OnlineCategoryEntity> {

        @Override
        public OnlineCategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            OnlineCategoryEntity entity = new OnlineCategoryEntity();
            entity.setCategoryID(rs.getInt("CTGR_ID"));
            entity.setCategoryName(rs.getString("NAME"));
            entity.setUpdateDate(rs.getDate("LAST_UPD_DATE"));
            return entity;

        }
    }

    public List<OnlineCategoryEntity> select() {

        String sql = "select * from ONLINE_CATEGORY";
        return jdbcTemplate.query(sql, new OnlineCategoryMapper());
    }

}