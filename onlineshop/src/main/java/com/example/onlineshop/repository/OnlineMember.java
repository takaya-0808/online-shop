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

import com.example.onlineshop.entity.OnlineMemberEntity;

@Repository
public class OnlineMember {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class OnlineMemberMapper implements RowMapper<OnlineMemberEntity>  {

        @Override
        public OnlineMemberEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            OnlineMemberEntity entity = new OnlineMemberEntity();
            entity.setMemberNo(rs.getInt("MEMBER_NO"));
            entity.setPassword(rs.getString("PASSWORD"));
            entity.setName(rs.getString("NAME"));
            entity.setAge(rs.getInt("AGE"));
            entity.setSex(rs.getString("SEX"));
            entity.setPostNumber(rs.getString("ZIP"));
            entity.setAddr(rs.getString("ADDRESS"));
            entity.setPhoneNumber(rs.getString("TEL"));
            entity.setRegisterDate(rs.getDate("REGISTER_DATE"));
            entity.setDelFlg(rs.getString("DELETE_FLG"));
            entity.setLstUpdDate(rs.getDate("LAST_UPD_DATE"));
            return entity;
        }

    }

    public List<OnlineMemberEntity> findAllMember() {

        String sql = "select * from ONLINE_MEMBER";
        OnlineMemberMapper memberMapper = new OnlineMemberMapper();
        return jdbcTemplate.query(sql, memberMapper);
    }

}