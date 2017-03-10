package com.tkylin.jdfx.core.dto;


import com.tkylin.jdfx.db.model.Goods;

import java.util.List;

/**
 * Created by tkyli on 2017/1/2.
 */
public class FxHhResultDto {
    private List<Goods> list;
    private Integer code;

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
