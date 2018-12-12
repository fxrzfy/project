package com.core.dto;

import com.core.model.checkmis.Role;

public class RoleDto extends Role {
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
