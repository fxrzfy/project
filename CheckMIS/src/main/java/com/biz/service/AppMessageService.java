package com.biz.service;

import com.biz.dto.gzrw.GzrwxzcyDto;
import com.core.model.checkmis.AppMessage;
import com.core.model.checkmis.Gzjl;
import com.core.model.checkmis.Gzrw;
import com.core.model.checkmis.Qjsq;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

import java.util.Map;

public interface AppMessageService {
    void addRwMessage(Gzrw gzrw);

    void addQjRwMessage(Qjsq qjsq);

    void addJlMessage(Gzjl gzjl);

    void readMsgAll(String type, SessionInfo info);

    DataPage<AppMessage> selectMessage(String type, PageHelper pageHelper, SessionInfo info);

    Map<String, Integer> messageCount(SessionInfo info);

    void readAll(String type, SessionInfo info);

    DataPage<Qjsq> selectQjMessage( PageHelper pageHelper, SessionInfo info);

    DataPage<GzrwxzcyDto> selectRWMessage(PageHelper pageHelper, SessionInfo info);

    DataPage<Gzjl> selectJlMessage( PageHelper pageHelper, SessionInfo info);

    GzrwxzcyDto selectRwDteail(Long id);

}
