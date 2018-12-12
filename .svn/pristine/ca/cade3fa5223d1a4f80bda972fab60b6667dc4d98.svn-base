package com.biz.service;

import com.core.model.checkmis.LqsknrflDmb;
import com.core.model.checkmis.LqsknrxdDmb;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

import java.util.List;

public interface LqsknrService {
    List<LqsknrflDmb> tree(String type);

    DataPage<LqsknrxdDmb>wtxList(LqsknrxdDmb lqsknrxdDmb, PageHelper pageHelper);

    void addWtfl(LqsknrflDmb lqsknrflDmb, SessionInfo info);

    void addWtXd(LqsknrxdDmb lqsknrxdDmb, SessionInfo info);

    void delWtFl(Long id);

    void delWtxd(Long id);
}
