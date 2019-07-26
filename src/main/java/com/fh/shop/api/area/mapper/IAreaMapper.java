package com.fh.shop.api.area.mapper;

import com.fh.shop.api.area.po.Area;

import java.util.List;

public interface IAreaMapper {



    /**
     * 根据Id查询用于下拉框拼接
     * @param id
     * @return
     */
    List<Area> getAreaById(Integer id);
}
