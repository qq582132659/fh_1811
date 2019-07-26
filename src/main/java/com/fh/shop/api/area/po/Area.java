package com.fh.shop.api.area.po;

import java.io.Serializable;

public class Area implements Serializable {
    private static final long serialVersionUID = 4804551641242675417L;
    private Integer id;
    private String areaName;
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
