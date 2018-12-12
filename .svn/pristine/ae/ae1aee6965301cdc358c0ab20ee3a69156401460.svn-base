package com.biz.service;

import com.biz.dto.leave.QjsqDto;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

public interface LeaveService {

	QjsqDto get(Long id);

	Long saveUpdate(QjsqDto r, SessionInfo info);

	void del(Long id);

	DataPage<QjsqDto> dataGrid(QjsqDto role, PageHelper pageHelper);

	void check(QjsqDto qjsqDto,SessionInfo info);

	void apply(Long id ,SessionInfo info);

}
