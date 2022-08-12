package com.zxk.mapper;

import com.zxk.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface InfoMapper {
    @Select("SELECT * FROM boot_ip")
    List<UserBean> findAll();
}




