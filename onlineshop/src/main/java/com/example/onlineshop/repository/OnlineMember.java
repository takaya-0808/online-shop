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

import com.example.onlineshop.entity.OnlineMemberEntity;
import com.example.onlineshop.repository.IOnlineMember;
import com.example.onlineshop.model.RegisterModel;

@Repository
public class OnlineMember implements IOnlineMember {

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

    @Override
    public OnlineMemberEntity findById(String id) {

        String sql = "select * from ONLINE_MEMBER where MEMBER_NO = ?";
        OnlineMemberMapper memberMapper = new OnlineMemberMapper();
        return jdbcTemplate.queryForObject(sql, memberMapper, id);
    }

    @Override
    public List<OnlineMemberEntity> findAll() {

        String sql = "select * from ONLINE_MEMBER";
        OnlineMemberMapper memberMapper = new OnlineMemberMapper();
        return jdbcTemplate.query(sql, memberMapper);
    }

    @Override
    public int insert(OnlineMemberEntity entity) {

        String sql = "insert into ONLINE_MEMBER (MEMBER_NO, PASSWORD, NAME, AGE, SEX, ZIP, ADDRESS, TEL, REGISTER_DATE, DELETE_FLG, LAST_UPD_DATE)" 
                +  " values (?, ?, ?, ?, ?, ?, ?, ?, Now(), 1, Now())";

        return jdbcTemplate.update(
                            sql, 
                            entity.getMemberNo(), 
                            entity.getPassword(), 
                            entity.getName(), 
                            entity.getAge(), 
                            entity.getSex(), 
                            entity.getPostNumber(), 
                            entity.getAddr(), 
                            entity.getPhoneNumber()
        );
    }

    @Override
    public int edit(RegisterModel model) {return 0;}

    @Override
    public int delete(String id) {return 0;}

    
}