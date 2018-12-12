package com.biz.dto.gzjl;

import java.util.List;

public class GzjlCheckDto {
    private Long gzrwId;
    private String rwmc;
    private String rwjh;
    List<GzjlDto>gzjlList;

    public Long getGzrwId() {
        return gzrwId;
    }

    public void setGzrwId(Long gzrwId) {
        this.gzrwId = gzrwId;
    }

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc;
    }

    public String getRwjh() {
        return rwjh;
    }

    public void setRwjh(String rwjh) {
        this.rwjh = rwjh;
    }

    public List<GzjlDto> getGzjlList() {
        return gzjlList;
    }

    public void setGzjlList(List<GzjlDto> gzjlList) {
        this.gzjlList = gzjlList;
    }
}
