package com.zxk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

    private Integer bi_id;
    private String bi_name;
    private String bi_department;
    private String bi_ip;
    private String bi_mac;

}