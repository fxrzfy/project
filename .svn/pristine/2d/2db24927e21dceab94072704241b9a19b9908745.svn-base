package com.biz.service;

import com.core.model.checkmis.WtflDmb;
import com.core.model.checkmis.WtxdDmb;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;

import java.util.List;

public interface WentiService {
    List<WtflDmb> tree(String type);

    DataPage<WtxdDmb>wtxList(WtxdDmb wtxdDmb     , PageHelper pageHelper);

    void addWtfl(WtflDmb wtflDmb, SessionInfo info);

    void addWtXd(WtxdDmb wtxdDmb,SessionInfo info);

    void delWtFl(Long id);

    void delWtxd(Long id );
}
