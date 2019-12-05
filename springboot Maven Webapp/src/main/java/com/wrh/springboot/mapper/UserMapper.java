package com.wrh.springboot.mapper;

import com.wrh.springboot.model.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "birthday",  column = "birthday", javaType=java.util.Date.class),
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    UserEntity getOne(Long id);

    @Insert("INSERT INTO t_user (name,birthday) VALUES( #{name},#{birthday})")
    void insert(UserEntity user);

    @Update("UPDATE t_user SET name=#{name} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    void delete(Long id);

}
