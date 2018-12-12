package com.biz.service;

import com.api.dto.ApiGzjlDto;
import com.biz.dto.gzrw.GzrwDto;
import com.biz.dto.gzrw.GzrwXzDto;
import com.core.model.checkmis.Gzrw;
import com.core.model.checkmis.Gzrwxz;
import com.core.model.checkmis.Gzrwxzcy;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

import java.util.List;
import java.util.Map;

public interface GzrwService {
    List<GzrwXzDto> getGzrwXzByRwId(Long rwId);

    Gzrw addEditGzrw(Gzrw gzrw, SessionInfo info);

    List<GzrwXzDto> getInitGzrwXz();

    DataPage<GzrwDto> list(GzrwDto gzrw, PageHelper pageHelper);

    Gzrw getById(Long id);

    //void zfGzrw(Gzrw gzrw, SessionInfo info);

    void delGzxz(Long id);

    void updateTeam(Long id,String name ,String value,SessionInfo info);

    void addXzcy(Gzrwxzcy gzrwxzcy,SessionInfo info);

    void freeXzcy(Long id);

    void updateCyRole(Long id,SessionInfo info);

    void dimissXz(String ids,String type,SessionInfo info);

    void delGzrw(Long id);

    List<Gzrwxzcy> selectXzcy(Long xzId);

    Map<String,List<Gzrwxzcy>> getSignstatus(Long gzrwid);

    DataPage<GzrwDto> currentList(String workNumber,String valid, PageHelper pageHelper);

    void addTempCy(Gzrwxzcy gzrwxzcy, SessionInfo info);

    void sign(Long id,SessionInfo info);

    List<ApiGzjlDto>selectAppGzjlList();

    GzrwXzDto selectXzInfo(Gzrwxz gzrwxz);
    void addGzrwxzcys(String ids,Long xzId,SessionInfo info);
}
