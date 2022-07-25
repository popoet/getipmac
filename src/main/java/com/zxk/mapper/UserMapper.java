package com.zxk.mapper;

import com.zxk.entity.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //查询
    @Select("SELECT * FROM boot_ip WHERE bi_name = #{bi_name} AND bi_department = #{bi_department} AND bi_ip = #{bi_ip} AND bi_mac = #{bi_mac}")
    UserBean getInfo(@Param("bi_name") String bi_name, @Param("bi_department") String bi_department,
                     @Param("bi_ip") String bi_ip, @Param("bi_mac") String bi_mac);

    //多个参数要加@Param修饰
    //增加
    @Insert("insert into boot_ip(bi_name,bi_department,bi_ip,bi_mac)values(#{bi_name},#{bi_department},#{bi_ip},#{bi_mac})")
    int saveInfo(@Param("bi_name") String bi_name, @Param("bi_department") String bi_department,
                  @Param("bi_ip") String bi_ip, @Param("bi_mac") String bi_mac);

}