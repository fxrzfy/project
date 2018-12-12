package com.biz.dto.gzjlsc;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class GzxsGroupDto {
    String ids;
    @JSONField(format = "yyyy-MM-dd")
    Date jckssj;
    @JSONField(format = "yyyy-MM-dd")
    Date jcjssj;
    String ty1;
    String ty2;
    String ty3;
    Integer count;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Date getJckssj() {
        return jckssj;
    }

    public void setJckssj(Date jckssj) {
        this.jckssj = jckssj;
    }

    public Date getJcjssj() {
        return jcjssj;
    }

    public void setJcjssj(Date jcjssj) {
        this.jcjssj = jcjssj;
    }

    public String getTy1() {
        return ty1;
    }

    public void setTy1(String ty1) {
        this.ty1 = ty1;
    }

    public String getTy2() {
        return ty2;
    }

    public void setTy2(String ty2) {
        this.ty2 = ty2;
    }

    public String getTy3() {
        return ty3;
    }

    public void setTy3(String ty3) {
        this.ty3 = ty3;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
