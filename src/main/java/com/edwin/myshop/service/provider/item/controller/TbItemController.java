package com.edwin.myshop.service.provider.item.controller;


import com.edwin.myshop.commons.domain.TbItem;
import com.edwin.myshop.commons.dto.Result;
import com.edwin.myshop.commons.utils.ResultUtil;
import com.edwin.myshop.commons.web.AbstractBaseController;
import com.edwin.myshop.service.provider.item.service.TbItemService;
import com.edwin.myshop.service.provider.item.vo.ItemVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item")
@Api(tags = "商品服务",description = "商品服务接口")
public class TbItemController extends AbstractBaseController<TbItem> {
    @Autowired
    private TbItemService tbItemService;

    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "笔数", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping(value = "page/{num}/{size}")
    public Result<List<TbItem>> page(@PathVariable int num, @PathVariable int size) {
        PageHelper.startPage(num,size);
        TbItem tbItem = new TbItem();
        List<TbItem> itemList = tbItemService.page(tbItem, num, size);
        Result result = ResultUtil.successResultReturnMsgAndData("商品分页查询成功", new PageInfo<>(itemList));
        return result;
    }

    @ApiOperation(value = "查询")
    @GetMapping(value = "/list")
    public Result<List<TbItem>> list(ItemVo itemVo) {
        PageHelper.startPage(itemVo.getPageNo(),itemVo.getPageSize());
        List<TbItem> itemList = tbItemService.list(itemVo);
        Result result = ResultUtil.successResultReturnMsgAndData("商品分页查询成功", new PageInfo<>(itemList));
        return result;
    }

    @ApiOperation(value = "编辑")
    @PostMapping(value = "/update")
    public Result update(@RequestBody TbItem tbItem) {
        Integer count = tbItemService.update(tbItem);
        Result result = ResultUtil.successResultReturnMsgAndData("修改成功!", count);
        return result;
    }

    @ApiOperation(value = "新增")
    @GetMapping(value = "/create")
    public Result create(TbItem tbItem) {
        Integer count = tbItemService.insterItem(tbItem);
        Result result = ResultUtil.successResultReturnMsgAndData("新增成功!", count);
        return result;
    }

    @ApiOperation(value = "获取详情")
    @GetMapping(value = "/get")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query")
    public Result<TbItem> getInfo(Long id) {
        TbItem tbItem = tbItemService.getInfo(id);
        Result result = ResultUtil.successResultReturnMsgAndData("获取详情成功!", tbItem);
        return result;
    }

    @ApiOperation(value = "删除")
    @GetMapping(value = "/delete")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query")
    public Result delete(Long id) {
        Integer count = tbItemService.deleteInfo(id);
        Result result = ResultUtil.successResultReturnMsgAndData("删除成功!", count);
        return result;
    }

}
