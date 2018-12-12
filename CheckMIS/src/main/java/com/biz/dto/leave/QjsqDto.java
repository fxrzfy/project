package com.biz.dto.leave;

import com.core.model.checkmis.Qjsq;

public class QjsqDto extends Qjsq{
    private String deptName;
    private String jl;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJl() {
        return jl;
    }

    public void setJl(String jl) {
        this.jl = jl;
    }
}
