package com.core.service.impl;

import com.core.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * <p>Description: 岗位信息表 service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {

//	@Autowired
////	private PositionMapper positionMapper;
////
////	@Autowired
////	private DeptService  deptService;
////
////	@Override
////	public void add(Position position) throws Exception {
////		// TODO Auto-generated method stub
////		//position.setCreateDateTime(new Date());
////		//positionDao.add(position);
////	}
////
////	@Override
////	public Position queryById(Object id) {
////		if(id==null){
////			return null;
////		}
////        return positionMapper.selectByPrimaryKey((Long)id);
////	}
////
////	@Override
////	public void update(Position position) throws Exception {
////		// TODO Auto-generated method stub
////		position.setModifydate(new Date());
////		positionMapper.updateByPrimaryKey(position);
////	}
////
////	@Override
////	public void updateBySelect(Position position) throws Exception {
////		// TODO Auto-generated method stub
////		//positionDao.updateBySelect(position);
////	}
////
////	@Override
////	public void delete(String ids) throws Exception {
////		// TODO Auto-generated method stub
////		for(String id:ids.split(",")){
////            positionMapper.deleteByPrimaryKey(Long.valueOf(id));
////        }
////	}
////
////	@Override
////	public void deleteBatch(String ids) throws Exception {
////		// TODO Auto-generated method stub
////		for (String id : ids.split(",")) {
////			if (id != null) {
////				//positionDao.delete(id);
////			}
////		}
////	}
////
////	@Override
////	public DataGrid queryList(Position position, PageHelper page) {
////		List<Long>deptids=this.deptService.getDeptList(position.getDeptIdstr());
////		DataGrid dg = new DataGrid();
////        PositionExample positionExample = new PositionExample();
////        PositionExample.Criteria c=positionExample.createCriteria();
////        if(!StringUtil.isEmpty(position.getPositionName())){
////            c.andPositionNameLike("%" + position.getPositionName() + '%');
////        }
////        if(deptids.size()>0){
////        	c.andDeptIdIN(deptids);
////        }
////		List<Position> rows = positionMapper.selectByExample(positionExample);
////		dg.setTotal((long)rows.size());
////		dg.setRows(rows);
////		return dg;
////	}
////
////    @Override
////    public void save(Position position) {
////    	if(StringUtil.isEmpty(position.getPositionName())){
////    		throw new RuntimeException("岗位名称不能为空");
////    	}
////    	if(StringUtil.isEmpty(position.getPositionCode())){
////    		throw new RuntimeException("岗位编码不能为空");
////    	}
////        PositionExample pe = new PositionExample();
////        pe.createCriteria().andPositionNameEqualTo(position.getPositionName());
////        List<Position> positionListWithName = positionMapper.selectByExample(pe);
////        pe = new PositionExample();
////        pe.createCriteria().andPositionCodeEqualTo(position.getPositionCode());
////        List<Position> positionListWithCode = positionMapper.selectByExample(pe);
////        if(position.getPositionId() == null){
////            if(positionListWithCode.size()>0){
////                throw new RuntimeException("岗位编码不能重复");
////            }else if(positionListWithName.size()>0){
////                throw new RuntimeException("岗位名称不能重复");
////            }
////            position.setSerial(100L);
////            positionMapper.insert(position);
////        }else{
////            if(positionListWithCode.size()>0 && position.getPositionId().longValue() != positionListWithCode.get(0).getPositionId()){
////                throw new RuntimeException("岗位编码不能重复");
////            }else if(positionListWithName.size()>0 && position.getPositionId().longValue() != positionListWithName.get(0).getPositionId()){
////                throw new RuntimeException("岗位名称不能重复");
////            }
////            positionMapper.updateByPrimaryKey(position);
////        }
////    }
////
////	@Override
////	public List<Position> getAllPositionList() {
////		PositionExample example=new PositionExample();
////        example.setOrderByClause("serial");
////		return positionMapper.selectByExample(example);
////	}
////
////	@Override
////	public List<Tree> roleTree(Long deptId) {
////		List<Tree> t=new ArrayList<Tree>();
////		PositionExample example=new PositionExample();
////		example.createCriteria().andDeptIdEqualTo(deptId);
////		List<Position>pl=positionMapper.selectByExample(example);
////		for(Position p:pl){
////			Tree t1=new Tree();
////			t1.setId(p.getPositionId().toString());
////			t1.setText(p.getPositionName());
////			t.add(t1);
////		}
////		return t;
////	}
////
////	@Override
////	public void move(Long deptId, String ids) {
////		for(String s:ids.split(",")){
////			Position p=this.positionMapper.selectByPrimaryKey(Long.parseLong(s));
////			p.setDeptId(deptId);
////			this.positionMapper.updateByPrimaryKey(p);
////		}
////
////	}
////
////    @Override
////    public Map<String, String> getPositionDpm() {
////        List<Position> pl=this.positionMapper.selectByExample(new PositionExample());
////        Map<String, String>m=new HashMap<String, String>();
////        for(Position p:pl ){
////            m.put(p.getPositionId().toString(), p.getPositionName());
////        }
////        return m;
////    }


}
