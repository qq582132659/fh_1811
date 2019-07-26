package com.fh.shop.api.area.biz;

import com.fh.shop.api.area.po.Area;

import java.util.List;

public interface IAreaService {
    /**
     * 根据id查询 用于多级联动
     * @param id
     * @return
     */
    List<Area> getAreaById(Integer id);
}
