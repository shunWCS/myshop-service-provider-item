package com.edwin.myshop.service.provider.item.maper;

import com.edwin.myshop.commons.utils.Util;
import com.edwin.myshop.service.provider.item.vo.ItemVo;

public class SelfTbItemMapperProvider {

    public String list (ItemVo itemVo){
        StringBuffer sql = new StringBuffer("select * from tb_item where 1 =1 ");
        if(Util.isNotEmpty(itemVo.getId())){
            sql.append(" and id = #{id}");
        }
        if(Util.isNotEmpty(itemVo.getPrice())){
            sql.append(" and price = #{price}");
        }
        sql.append(" order by created desc");
        return sql.toString();
    }
}
