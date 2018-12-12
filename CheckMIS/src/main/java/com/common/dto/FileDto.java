package com.common.dto;

import com.biz.dto.gzjl.GzjhDto;

import java.io.FileInputStream;
import java.util.List;

public class FileDto {
    private String fileName;
    private List<GzjhDto> jhList;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<GzjhDto> getJhList() {
        return jhList;
    }

    public void setJhList(List<GzjhDto> jhList) {
        this.jhList = jhList;
    }
}
