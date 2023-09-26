package com.example.onlineshop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.example.onlineshop.entity.SexEntity;

@Repository
public class Sex {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class SexMapper implements RowMapper<SexEntity> {

        @Override
        public SexEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            SexEntity entity = new SexEntity();
            entity.setSexId(rs.getInt("SEX_ID"));
            entity.setSexName(rs.getString("SEX_NAME"));
            return entity;

        }
    }

    public List<SexEntity> getSexList() {

        String sql = "select * from SEX";
        SexMapper sexMapper = new SexMapper();
        return jdbcTemplate.query(sql, sexMapper);

    }

}