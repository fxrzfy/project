package com.core.service;

import com.core.model.checkmis.CodeListDetail;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

import java.util.List;

/**
 * <p>Description: CodelistDetail service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
public interface CodelistDetailService {

	public void add(CodeListDetail codelistDetail) throws Exception;

	public CodeListDetail queryById(Long id);

	public void update(CodeListDetail codelistDetail) throws Exception;

	public void updateBySelect(CodeListDetail codelistDetail) throws Exception;

	public void delete(Object id) throws Exception;
	
	public void deleteBatch(String ids) throws Exception;

	public DataPage<CodeListDetail> queryList(CodeListDetail codelistDetail, PageHelper page);
	
	public void addEdit(CodeListDetail codelistDetail,SessionInfo sessionInfo);
	
	public List<CodeListDetail> queryByObject(CodeListDetail codelistDetail);

}
