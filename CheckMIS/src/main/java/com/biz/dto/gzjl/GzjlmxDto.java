package com.biz.dto.gzjl;

import com.core.model.checkmis.Gzjlmx;

import java.util.List;
import java.util.Map;

public class GzjlmxDto extends Gzjlmx {
    private  String type;

    private String edit;

    private List<Map> datacz;

    private List<Map> datalc;

    public List<Map> getDatacz() {
        return datacz;
    }

    public void setDatacz(List<Map> datacz) {
        this.datacz = datacz;
    }

    public List<Map> getDatalc() {
        return datalc;
    }

    public void setDatalc(List<Map> datalc) {
        this.datalc = datalc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
}
