package com.biz.service;

import com.biz.dto.gzjl.*;
import com.common.dto.FileDto;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface GzjlService {

    GzjlDto getById(Long id, Long gzrwId, Long gzrwxzId, SessionInfo info);

    void addEditGzjl(GzjlDto gzjl,SessionInfo info);

    void deleteGzjl(Long id,SessionInfo info);

    //void checkGzjl(Gzjl gzjl,SessionInfo info);

    DataPage<GzjhDto> selectGzjlmx(GzjlmxDto gzjlmxDto);

    void addGzjlmx(GzjlmxDto gzjlmx,SessionInfo info);

    DataPage<GzjlJcczDto>selectJccz(GzjlmxDto gzjlmxDto, PageHelper pageHelper);

    DataPage<GzjlJclcDto>selectJclc(GzjlmxDto gzjlmxDto, PageHelper pageHelper);

    Gzjlmx getGzmxById(Long id);

    void deleteGzjlMx(Long id);

    void copy(Long id,Long toxzId,SessionInfo info);

    void apply(Long id,SessionInfo info);

    GzjlCheckDto getCheckData(String ids,SessionInfo info);

    void check(BatchGzjl batchGzjl, SessionInfo info);

    FileDto getDownPdfData(GzjlmxDto gzjlDto);


}
