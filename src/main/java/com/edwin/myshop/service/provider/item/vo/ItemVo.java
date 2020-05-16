package com.edwin.myshop.service.provider.item.vo;

import lombok.Data;

@Data
public class ItemVo {
    private Integer id;
    private String name;
    private Integer price;
    private Integer pageSize = 10;
    private Integer pageNo = 1;
}
