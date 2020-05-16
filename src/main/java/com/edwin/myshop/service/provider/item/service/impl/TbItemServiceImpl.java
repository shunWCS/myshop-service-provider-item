package com.edwin.myshop.service.provider.item.service.impl;

import com.edwin.myshop.commons.domain.TbItem;
import com.edwin.myshop.commons.mapper.TbItemMapper;
import com.edwin.myshop.commons.utils.Util;
import com.edwin.myshop.service.provider.item.maper.SelfTbItemMapper;
import com.edwin.myshop.service.provider.item.service.TbItemService;
import com.edwin.myshop.service.provider.item.vo.ItemVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private SelfTbItemMapper selfTbItemMapper;

    @Cacheable(cacheNames = "tbItem",key = "#tbItem"/*,keyGenerator = "myKeyGenerator",condition = "#a0>0"*/)
    @Override
    public List<TbItem> page(TbItem tbItem, int num, int size) {
        List<TbItem> itemList = selfTbItemMapper.seleteByItem(tbItem);
        return itemList;
    }

    @Override
    public List<TbItem> list(ItemVo itemVo) {
        List<TbItem> itemList = selfTbItemMapper.list(itemVo);
        return itemList;
    }

    @Override
    public Integer update(TbItem tbItem) {
        TbItem oldInfo = selfTbItemMapper.selectByPrimaryKey(tbItem.getId());
        Util.copyNullProperties(oldInfo,tbItem);
        tbItem.setUpdated(new Date());
        int count = selfTbItemMapper.updateByPrimaryKey(tbItem);
        return count;
    }

    @Override
    public TbItem getInfo(Long id) {
        TbItem tbItem = selfTbItemMapper.selectByPrimaryKey(id);
        return tbItem;
    }


    @Override
    public Integer deleteInfo(Long id) {
        int count = selfTbItemMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public Integer insterItem(TbItem tbItem) {
        Long maxId = selfTbItemMapper.findMaxId();
        tbItem.setId(maxId +1);
        tbItem.setNum(50);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItem.setCid(new Long("1000"));
        tbItem.setStatus(new Byte("1"));
        int count = selfTbItemMapper.insertSelective(tbItem);
        return count;
    }
}
