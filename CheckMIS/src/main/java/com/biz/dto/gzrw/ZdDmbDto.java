package com.biz.dto.gzrw;

import com.core.model.checkmis.ZdDmb;

public class ZdDmbDto extends ZdDmb {
    private Long zszId;
    private Long type;

    public Long getZszId() {
        return zszId;
    }

    public void setZszId(Long zszId) {
        this.zszId = zszId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
