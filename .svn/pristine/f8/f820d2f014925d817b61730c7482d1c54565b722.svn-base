package com.core.service.impl;

import com.core.model.checkmis.CodeListDetail;
import com.core.pageModel.DataGrid;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.CodelistDetailService;
import com.dao.core.checkmis.CodeListDetailMapper;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: CodelistDetail service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
@Service("codelistDetailService")
public class CodelistDetailServiceImpl implements CodelistDetailService {

	@Autowired
	private CodeListDetailMapper codeListDetailMapper;

	@Override
	public void add(CodeListDetail codeListDetail) throws Exception {
		codeListDetailMapper.insert(codeListDetail);
	}

	@Override
	public CodeListDetail queryById(Long id) {
		return codeListDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(CodeListDetail codelistDetail) throws Exception {
		codeListDetailMapper.updateByPrimaryKey(codelistDetail);
	}

	@Override
	public void updateBySelect(CodeListDetail codelistDetail) throws Exception {
		codeListDetailMapper.updateByPrimaryKeySelective(codelistDetail);
	}

	@Override
	public void delete(Object id) throws Exception {
		for(String sid:((String)id).split(",")){
			codeListDetailMapper.deleteByPrimaryKey(Long.parseLong(sid));
		}
	}
	
	@Override
	public void deleteBatch(String ids) throws Exception {
		for (String id : ids.split(",")) {
			if (id != null) {
				codeListDetailMapper.deleteByPrimaryKey(Long.parseLong(id));
			}
		}
	}

	@Override
	public DataPage<CodeListDetail> queryList(CodeListDetail codelistDetail, PageHelper page) {
		DataPage<CodeListDetail> res=page.initPageBean();
//
//		Long total = codelistDetailDao.queryCount(codelistDetail);
//		List<CodelistDetail> rows = codelistDetailDao.queryList(codelistDetail, page);
//		dg.setTotal(total);
//		dg.setRows(rows);
		return res;
	}

	@Override
	public void addEdit(CodeListDetail codelistDetail, SessionInfo sessionInfo) {
		//checkSDuplicate(codelistDetail);
//		CodeListDetail fromDb=this.codelistDetailDao.queryById(codelistDetail.getId());
//		if(null!=fromDb){
//			this.codelistDetailDao.update(codelistDetail);
//		}else{
//			this.codelistDetailDao.add(codelistDetail);
//		}
		
	}
	
	@Override
	public List<CodeListDetail> queryByObject(CodeListDetail codelistDetail) {
		//return this.codelistDetailDao.queryByObject(codelistDetail);
		return null;
	}

//	private void checkSDuplicate(CodelistDetail codelistDetail){
//		CodelistDetail cd =new CodelistDetail();
//		cd.setMasterId(codelistDetail.getMasterId());
//		List<CodelistDetail> list= this.codelistDetailDao.queryByObject(cd);
//		if(list.size()>0){
//			for(CodelistDetail fromdb:list){
//				if(!StringUtil.equal(fromdb.getId(),codelistDetail.getId()) && (StringUtil.equalsIgnoreCase(fromdb.getKey(), codelistDetail.getKey())||
//						StringUtil.equalsIgnoreCase(fromdb.getName(), codelistDetail.getName())
//						)){
//					throw new RuntimeException("输入名字或者值重复，请重新输入");
//				}
//			}
//		}
//	}
}
