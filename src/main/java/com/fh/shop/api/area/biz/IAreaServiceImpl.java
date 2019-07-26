package com.fh.shop.api.area.biz;

import com.fh.shop.api.area.mapper.IAreaMapper;
import com.fh.shop.api.area.po.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class IAreaServiceImpl implements IAreaService {
    @Autowired
    private IAreaMapper areaMapper;
    @Override
    public List<Area> getAreaById(Integer id) {
        return areaMapper.getAreaById(id);
    }
}
