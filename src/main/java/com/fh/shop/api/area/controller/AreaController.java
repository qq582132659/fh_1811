package com.fh.shop.api.area.controller;

import com.fh.shop.api.area.biz.IAreaService;
import com.fh.shop.api.area.po.Area;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("area")
public class AreaController {
    @Resource(name = "areaService")
    private IAreaService areaService;
    /**
     * 根据传过来的Id查询  用于三级联动
     * @param id
     * @return
     */
    @RequestMapping( value = "getAreaById",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getAreaById(Integer id){
        List<Area> areaList = areaService.getAreaById(id);
        return ServerResponse.success(areaList);
    }
}
