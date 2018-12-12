package com.biz.dto.gzjl;

import com.core.model.checkmis.Gzjl;

public class GzjlDto extends Gzjl {

    private  String workNumber;

    private String rwmc;

    private Long copytarget;

    private String persionStr;

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc;
    }

    public Long getCopytarget() {
        return copytarget;
    }

    public void setCopytarget(Long copytarget) {
        this.copytarget = copytarget;
    }

    public String getPersionStr() {
        return persionStr;
    }

    public void setPersionStr(String persionStr) {
        this.persionStr = persionStr;
    }
}
