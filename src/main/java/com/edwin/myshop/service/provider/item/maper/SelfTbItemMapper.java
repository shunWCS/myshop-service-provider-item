package com.edwin.myshop.service.provider.item.maper;

import com.edwin.myshop.commons.domain.TbItem;
import com.edwin.myshop.service.provider.item.vo.ItemVo;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.MyMapper;

import java.util.List;


public interface SelfTbItemMapper extends MyMapper<TbItem> {

    @SelectProvider(type = SelfTbItemMapperProvider.class,method = "list")
    List<TbItem> list(ItemVo itemVo);

    @Select(" select *from tb_item ")
    List<TbItem> seleteByItem(TbItem item);

    @Select(" select max(id) from tb_item")
    Long findMaxId();
}
