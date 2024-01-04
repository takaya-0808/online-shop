package com.example.onlineshop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.onlineshop.entity.OnlineStaffEntity;
import com.example.onlineshop.repository.IOnlineStaff;
import com.example.onlineshop.model.StaffModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class OnlineStaff implements IOnlineStaff {

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

    @Override
    public OnlineStaffEntity findById(String staffNo) {
        String sql = "select * from ONLINE_STAFF where STAFF_NO = ?";
        return jdbcTemplate.queryForObject(sql, new OnlineStaffMapper(), staffNo);
    }

    @Override
    public List<OnlineStaffEntity> findAll() {
        String sql = "select * from ONLINE_STAFF";
        return jdbcTemplate.query(sql, new OnlineStaffMapper());
    }

    @Override
    public int insert(StaffModel model) {
        return 1;
    }

}