package com.biz.service;

import com.biz.dto.gzjlsc.GzxsGroupDetailDto;
import com.biz.dto.gzjlsc.GzxsGroupDto;
import com.biz.dto.gzxs.GzxsDto;
import com.core.model.checkmis.Gzxs;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;

public interface GzxsService {

    DataPage<Gzxs> dataGrid(Gzxs gzxs, PageHelper pageHelper);

    GzxsDto get(Long id);

    void add(GzxsDto gzxsDto);

    void delete(Long id);

    void update(GzxsDto gzxsDto);

    DataPage<GzxsGroupDto> groupList(Gzxs gzxs, PageHelper pageHelper);

    GzxsGroupDetailDto groupDetail(String ids);
}
