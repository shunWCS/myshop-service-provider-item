package com.edwin.myshop.service.provider.item.service;

import com.edwin.myshop.commons.domain.TbItem;
import com.edwin.myshop.service.provider.item.vo.ItemVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TbItemService {
    List<TbItem> page(TbItem tbItem, int num, int size);

    List<TbItem> list(ItemVo itemVo);

    Integer update(TbItem tbItem);

    TbItem getInfo(Long id);

    Integer deleteInfo(Long id);

    Integer insterItem(TbItem tbItem);
}
