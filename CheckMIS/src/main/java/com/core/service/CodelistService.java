package com.core.service;

import com.core.dto.DropDownDto;
import com.core.model.checkmis.CodeList;
import com.core.model.checkmis.CodeListDetail;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.Tree;

import java.util.List;

/**
 * <p>Description: Codelist service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
public interface CodelistService {

	void add(CodeList codelist);

	public CodeList queryById(Long id);


	public void update(CodeList codelist) throws Exception;

//	public void updateBySelect(CodeList codelist) throws Exception;

	//public void delete(Long id) throws Exception;
	
	public void deleteBatch(String ids) throws Exception;

	public DataPage queryList(CodeList codelist, PageHelper page);
	
//	public String loadAllDropdown();

	public List<DropDownDto> queryAll();

	public CodeList queryByCode(String code);

	DataPage queryList(CodeListDetail codeListDetail, PageHelper page);

	void updateDetailSelectiveByPk(CodeListDetail codeListDetail);

	void addCodeListDetail(CodeListDetail codeListDetail);

	void deleteDetailBatch(String ids);

	List<Tree> tree();

	void del(Long id);

	List<CodeListDetail> selectCodeListDetailListByCode(String code);

}
