package com.biz.service;

import com.biz.dto.gzrw.ZdDmbDto;
import com.core.model.checkmis.ZdDmb;
import com.core.model.checkmis.ZzdwDmb;
import com.core.pageModel.*;

import java.util.List;
import java.util.Map;

public interface ZszService {
     List<Tree> tree(SessionInfo sessionInfo,String typeids);
     void addEdit(ZzdwDmb zzdwDmb,SessionInfo info);
     ZzdwDmb getById(Long id);
     void delZszById(Long id);
     DataPage<ZdDmb>datatGrid(ZdDmbDto zdDmb, PageHelper pageHelper);
     ZdDmb getZdDmById(Long id);
     void delZDmById(String ids,Long deptID);
     void addEditZdSelecttive(ZdDmb zdDmb, SessionInfo info);
     List<SuggestBean> suggest(String type, String name);
     String sync(String type);
     Map listAll();



}

