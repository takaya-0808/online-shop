package com.example.onlineshop.repository;

import com.example.onlineshop.entity.OnlineStaffEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class OnlineStaff {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class OnlineStaffMapper implements RowMapper<OnlineStaffEntity>  {

        @Override
        public OnlineStaffEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            OnlineStaffEntity entity = new OnlineStaffEntity();
            entity.setStaffNo(rs.getInt("STAFF_NO"));
            entity.setPassword(rs.getString("PASSWORD"));
            entity.setName(rs.getString("NAME"));
            entity.setAge(rs.getInt("AGE"));
            entity.setSex(rs.getString("SEX"));
            entity.setRegisterDate(rs.getDate("REGISTER_DATE"));
            entity.setLastUpdDate(rs.getDate("LAST_UPD_DATE"));
            return entity;
        }
    }

}