package com.core.service.impl;

import com.common.constant.Constant;
import com.core.dto.DropDownDto;
import com.core.model.checkmis.CodeList;
import com.core.model.checkmis.CodeListDetail;
import com.core.model.checkmis.CodeListDetailExample;
import com.core.model.checkmis.CodeListExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.Tree;
import com.core.service.CodelistService;
import com.dao.core.checkmis.CodeListDetailMapper;
import com.dao.core.checkmis.CodeListMapper;
import com.util.BaseException;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: Codelist service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
@Service("codelistService")
public class CodelistServiceImpl implements CodelistService {

	@Autowired
	private CodeListMapper codelistDao;
	@Autowired
	private CodeListDetailMapper  codelistDetailDao;

	@Override
	public void add(CodeList codelist){
        CodeList c=this.queryByCode(codelist.getCode());
	    if(codelist.getId()==null && c!=null){
            throw new BaseException("编号已经存在");
        }
       if(c!=null && !c.getId().equals(codelist.getId())){
           throw new BaseException("编号已经存在");
       }
       if(codelist.getId()==null){
           codelistDao.insert(codelist);
       }else{
           codelistDao.updateByPrimaryKey(codelist);
       }
	}

	@Override
	public CodeList queryById(Long id) {
		return codelistDao.selectByPrimaryKey(id);
	}

	@Override
	public void update(CodeList codelist) throws Exception {
		//codelist.setModifyDateTime(new Date());
		//codelistDao.update(codelist);
	}

//	@Override
//	public void updateBySelect(CodeList codelist) throws Exception {
//		codelistDao.updateBySelect(codelist);
//	}

//	@Override
//	public void delete(Object id) throws Exception {
//		codelistDao.delete(id);
//	}
	
	@Override
	public void deleteBatch(String ids) throws Exception {
		for (String id : ids.split(",")) {
			if (id != null) {
				codelistDao.deleteByPrimaryKey(Long.parseLong(id));
			}
		}
	}

	@Override
	public DataPage queryList(CodeList codelist, PageHelper page) {
		DataPage dataPage=page.initPageBean();
//		Long total = codelistDao.queryCount(codelist);
////		List<Codelist> rows = codelistDao.queryList(codelist, page);
////		dg.setTotal(total);
////		dg.setRows(rows);
		return dataPage;
	}

//	@Override
//	public String loadAllDropdown() {
//		Map<String, Object>map=new HashMap<String, Object>();
//		Codelist co =new Codelist();
//		List<Codelist>baseList=this.codelistDao.queryByObject(co);
//		List<SuggestBean> li=new ArrayList<SuggestBean>();
//		if(null!=baseList && baseList.size()>0){
//			for(Codelist mb:baseList){
//				li.add(new SuggestBean(mb.getName()+"", mb));
//			}
//		}
//		map.put("suggestions", li);
//		return JSON.toJSONString(map);
//	}

	@Override
	public List<DropDownDto> queryAll() {
		return this.codelistDetailDao.queryAllData();
	}

	@Override
	public CodeList queryByCode(String code) {
		CodeListExample example=new CodeListExample();
		example.createCriteria().andCodeEqualTo(code);
		List<CodeList>cl=this.codelistDao.selectByExample(example);
		return cl.size()==0?null:cl.get(0);
	}

	@Override
	public DataPage queryList(CodeListDetail codeListDetail, PageHelper page) {
		DataPage<CodeListDetail>dataPage=page.initPageBean();
		CodeListDetailExample example= new CodeListDetailExample();
		BeanUtils.copyProperties(page,example);
		CodeListDetailExample.Criteria c=example.createCriteria().andMasteridEqualTo(codeListDetail.getMasterid());
		if(!StringUtil.isEmpty(codeListDetail.getKey())){
			c.andKeyEqualTo(codeListDetail.getKey());
		}
		if(!StringUtil.isEmpty(codeListDetail.getName())){
			c.andNameLike("%"+codeListDetail.getName()+"%");
		}
		example.setOrderByClause("sort");
		List<CodeListDetail> cdl=this.codelistDetailDao.selectByExample(example);
		dataPage.setData(cdl);
		dataPage.setTotal(example.getTotal());
		return dataPage;
	}

	@Override
	public void updateDetailSelectiveByPk(CodeListDetail codeListDetail) {
		CodeListDetail db=this.codelistDetailDao.selectByPrimaryKey(codeListDetail.getId());
		codeListDetail.setMasterid(db.getMasterid());
		check(codeListDetail);
		codelistDetailDao.updateByPrimaryKeySelective(codeListDetail);
	}

	private void validList(CodeListDetail codeListDetail,List<CodeListDetail> cdl,String txt){
		if(cdl.size()==0||cdl.size()>1){
			return;
		}
		if(codeListDetail.getId()==null||!codeListDetail.getId().equals(cdl.get(0).getId())){
			throw new BaseException(txt+"已经存在");
		}

	}

	private void check(CodeListDetail codeListDetail){
		if(codeListDetail.getId()==null){
			if(StringUtil.isEmpty(codeListDetail.getName())){
				throw new BaseException("名称不能为空");
			}
			if(StringUtil.isEmpty(codeListDetail.getKey())){
				throw new BaseException("代码不能为空");
			}
		}
		CodeListDetailExample example= new CodeListDetailExample();

		CodeListDetailExample.Criteria c=example.createCriteria().andMasteridEqualTo(codeListDetail.getMasterid());
		if(!StringUtil.isEmpty(codeListDetail.getName())){
			c.andNameEqualTo(codeListDetail.getName());
		}
		validList(codeListDetail,this.codelistDetailDao.selectByExample(example),"名称");
		example.clear();
		c=example.createCriteria().andMasteridEqualTo(codeListDetail.getMasterid());
		if(!StringUtil.isEmpty(codeListDetail.getKey())){
			c.andKeyEqualTo(codeListDetail.getKey());
		}
		validList(codeListDetail,this.codelistDetailDao.selectByExample(example),"代码");
	}



	@Override
	public void addCodeListDetail(CodeListDetail codeListDetail) {
		check(codeListDetail);
		codeListDetail.setStatus("1");
		this.codelistDetailDao.insert(codeListDetail);
	}

	@Override
	public void deleteDetailBatch(String ids){
		for(String id:ids.split(",")){
			codelistDetailDao.deleteByPrimaryKey(Long.parseLong(id));
		}
	}

	@Override
	public List<Tree> tree() {
		List<Tree> lt = new ArrayList<Tree>();
		List<Tree> ltToal = new ArrayList<Tree>();
		Tree total = new Tree();
		total.setPid("-1");
		total.setId("0");
		total.setText("分类");
		total.setChildren(lt);
		ltToal.add(total);
		CodeListExample example=new CodeListExample();
		example.createCriteria().andCodeNotLike("individual_%");
		List<CodeList> cl=this.codelistDao.selectByExample(example);
		for(CodeList c:cl){
			Tree t = new Tree();
			t.setId(c.getCode());
			t.setText(c.getName());
			lt.add(t);
		}
		return ltToal;
	}

    @Override
    public void del(Long id) {
        codelistDao.deleteByPrimaryKey(id);
    }

	@Override
	public List<CodeListDetail> selectCodeListDetailListByCode(String code) {
		CodeListExample cl=new CodeListExample();
		cl.createCriteria().andCodeEqualTo(code);
		List<CodeList> cll=this.codelistDao.selectByExample(cl);
		if(cll.size()==0){
			return  new ArrayList<>();
		}
		CodeListDetailExample example=new CodeListDetailExample();
		example.setOrderByClause("SORT");
		example.createCriteria().andMasteridEqualTo(cll.get(0).getId());
		return codelistDetailDao.selectByExample(example);
	}
}
