package com.biz.service;

import com.biz.dto.GzzdDto;
import com.core.model.checkmis.Gzzd;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

public interface GzzdService {

	Gzzd get(Long id);

	Long saveUpdate(GzzdDto gzzd, SessionInfo info);

	void del(Long id);

	DataPage<Gzzd> dataGrid(GzzdDto gzzd, PageHelper pageHelper);

	void check(Gzzd gzzd, SessionInfo info);

	void apply(Long id, SessionInfo info);

	void valiadate(Gzzd gzzd);

}
