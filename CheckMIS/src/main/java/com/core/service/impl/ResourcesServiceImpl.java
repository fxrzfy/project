package com.core.service.impl;

import com.common.constant.Constant;
import com.core.dto.SysMenu;
import com.core.model.checkmis.Resources;
import com.core.model.checkmis.ResourcesExample;
import com.core.model.checkmis.RoleResources;
import com.core.model.checkmis.RoleResourcesExample;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;
import com.core.service.ResourcesService;
import com.dao.core.checkmis.ResourcesMapper;
import com.dao.core.checkmis.RoleResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ResourcesServiceImpl implements ResourcesService {
	@Autowired
	private ResourcesMapper resourcesMapper;
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;

	private List<Tree> tree(SessionInfo sessionInfo,String type,List<Long> checkIds){
		List<Tree> lt = new ArrayList<Tree>();
		List<Tree> ltToal = new ArrayList<Tree>();
		Tree total = new Tree();
		total.setPid("-1");
		total.setId("0");
		total.setText("所有菜单");
		total.setChildren(lt);
		ltToal.add(total);
		List<SysMenu> data=loadTree(sessionInfo,type);
		for(SysMenu s:data){
			Tree x = new Tree();
			x.setText(s.getMenuName());
			x.setPid("0");
			x.setId(s.getId().toString());
			if(null!=checkIds && checkIds.contains(s.getId())){
				x.setChecked(true);
			}
			List<SysMenu> sysMenus=s.getSysMenuList();
			List<Tree> childRec=new ArrayList<>();
			x.setChildren(childRec);
			lt.add(x);
			if(s.getSysMenuList()==null){
				continue;
			}
			for(SysMenu ss:sysMenus){
				Tree y = new Tree();
				y.setPid(s.getId().toString());
				y.setText(ss.getMenuName());
				y.setId(ss.getId().toString());
				if(null!=checkIds && checkIds.contains(ss.getId())){
					y.setChecked(true);
				}
				childRec.add(y);
			}

		}
		return ltToal;
	}
	@Override
	public List<Tree> tree(SessionInfo sessionInfo,String roleId) {
		List<Long>checkList=new ArrayList<>();
		if(roleId!=null){
			List<String> ids=Arrays.asList(roleId.split(","));
			RoleResourcesExample example=new RoleResourcesExample();
			example.createCriteria().andRoleStrIdIn(ids);
			List<RoleResources> rrList=this.roleResourcesMapper.selectByExample(example);
			if(!Collections.EMPTY_LIST.equals(rrList)){
				for(RoleResources rr:rrList){
					checkList.add(rr.getNodeId());
				}
			}
		}
		return tree(sessionInfo,Constant.RESOURCES_ALL,checkList);
	}

	@Override
	public Resources get(Long id) {
		if(id==0){
			Resources r= new Resources();
			r.setId(0l);
			r.setName("所有菜单");
			r.setType(Short.valueOf("1"));
			return r;
		}
		Resources r=this.resourcesMapper.selectByPrimaryKey(id);
		return r;
	}

	@Override
	public Long saveOrUpdate(Resources resources) {
		if(resources.getId()==null){
			this.resourcesMapper.insert(resources);
		}else{
			this.resourcesMapper.updateByPrimaryKey(resources);
		}
		return 0l;
	}

	@Override
	public void del(Long id) {
		this.resourcesMapper.deleteByPrimaryKey(id);
	}

	private SysMenu convert(Resources r){
		SysMenu s=new SysMenu();
		s.setMenuName(r.getName());
		s.setUrl(r.getUrl());
		s.setId(r.getId());
		s.setLogoTag(r.getIcons());
		if(r.getType()!=null)
		s.setMenuType(r.getType().toString());
        if(r.getOrders()!=null)
		s.setOrders(r.getOrders().longValue());
		s.setParentId(r.getPid());
		return s;
	}

	@Override
	public List<SysMenu> loadTree(SessionInfo sessionInfo,String type) {
		ResourcesExample resourcesExample=new ResourcesExample();
		ResourcesExample.Criteria  criteria=resourcesExample.createCriteria();
		if(Constant.RESOURCES_MENU.equals(type)){
			criteria.andTypeEqualTo(Short.valueOf("1"));
			if(!Constant.ADMIN.equals(sessionInfo.getPerson().getUserName())){
				criteria.andUserIdEqualTo(sessionInfo.getId());
			}
		}
		List<Resources> rl=this.resourcesMapper.selectByExample(resourcesExample);
		Map<Long,SysMenu>allMap=new HashMap<>();
		for(Resources r:rl){
			SysMenu ss=convert(r);
			allMap.put(r.getId(),ss);
		}
		List<SysMenu> result=new ArrayList<>();
		for(Long id:allMap.keySet()){
			SysMenu sysMenu=allMap.get(id);
			if(sysMenu.getParentId()==null){
                sysMenu.setParentId(0l);
            }
			if(sysMenu.getParentId()==0){
				result.add(sysMenu);
			}else{
				SysMenu p=allMap.get(sysMenu.getParentId());
				if(p.getSysMenuList()==null){
					p.setSysMenuList(new ArrayList<>());
				}
				p.getSysMenuList().add(sysMenu);
			}
		}
		Collections.sort(result, new Comparator<SysMenu>() {
			@Override
			public int compare(SysMenu o1, SysMenu o2) {
			    if(o1.getOrders()==null){
			        return -1;
                }
				return o1.getOrders().compareTo(o2.getOrders());
			}
		});
		for(SysMenu s:result){
			if(s.getSysMenuList()==null){
				continue;
			}
			Collections.sort(s.getSysMenuList(), new Comparator<SysMenu>() {
				@Override
				public int compare(SysMenu o1, SysMenu o2) {
					return o1.getOrders().compareTo(o2.getOrders());
				}
			});
		}
		return result;
	}
}
