package com.biz.service;

import com.core.model.checkmis.Gzjlsc;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;

public interface GzjlscService {

    DataPage<Gzjlsc> dataGrid(Gzjlsc gzjlsc, PageHelper pageHelper);


}
