package com.core.service.impl;


import com.common.constant.Constant;
import com.core.dto.PersonDto;
import com.core.dto.RoleDto;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.DeptService;
import com.core.service.UserService;
import com.dao.core.checkmis.PersonMapper;
import com.dao.core.checkmis.PersonRoleMapper;
import com.dao.core.checkmis.RoleMapper;
import com.dao.core.checkmis.UnitMapper;
import com.util.BaseException;
import com.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRoleMapper personRoleMapper;

    @Autowired
    private DeptService deptService;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PersonDto login(PersonDto user) {
        if(StringUtil.isEmpty(user.getUserName())||StringUtil.isEmpty(user.getPassword())){
            throw new BaseException("参数错误，用户名密码不能为空");

        }        PersonExample example = new PersonExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName()).andYxbzEqualTo(Short.valueOf("1"));
        List<Person> pl = this.personMapper.selectByExample(example);
        if (pl.size() == 0) {
            throw new BaseException("用户不存在");
        }
        user.encodePwd();
        Person dbPerson = pl.get(0);
        if (!user.getPassword().equals(dbPerson.getPassword())) {
            throw new BaseException("密码不正确");
        }
        PersonDto personDto= findByPersonId(dbPerson.getId());
        PersonRoleExample personRoleExample=new PersonRoleExample();
        personRoleExample.createCriteria().andPersonIdEqualTo(personDto.getId());
        List<PersonRole>prList=this.personRoleMapper.selectByExample(personRoleExample);
        if(prList.size()>0){
            List<Long>ids=new ArrayList<>();
            for(PersonRole pr:prList){
                ids.add(pr.getRoleId());
            }
            if(ids.size()<1){
                return personDto;
            }
            RoleExample roleExample=new RoleExample();
            roleExample.createCriteria().andIdIn(ids);
            personDto.setRoles(this.roleMapper.selectByExample(roleExample));
        }
        return personDto;
    }


    @Override
    public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd) {
//		Person u = personMapper.selectByPrimaryKey(sessionInfo.getId());
//		Person pp=new Person();
//		if (u.getPassword().equalsIgnoreCase(MD5Util.md5(u.getUserPhone()+oldPwd))) {// 说明原密码输入正确
//			PersonExample example=new PersonExample();
//			example.createCriteria().andPersonIdEqualTo(u.getPersonId());
//			pp.setPassword(MD5Util.md5(u.getUserPhone()+pwd));
//			pp.setModifydate(new Date());
//			personMapper.updateByExampleSelective(pp, example);
//			return true;
//		}
        return false;
    }

    @Override
    public DataPage<PersonDto> dataGrid(PersonDto person, PageHelper pageHelper, SessionInfo sessionInfo) {
        if(StringUtil.isEmpty(person.getQid())){
            return new DataPage<>();
        }
        List<Dept>dl=deptService.selectAllDeptByParam(person.getQid());
        List<Long> idl=new ArrayList<>();
        for(Dept d:dl){
            idl.add(d.getId());
        }
        if(idl.size()==0){
            return new DataPage<>();
        }
        DataPage<PersonDto> dataPage = pageHelper.initPageBean();
        person.setDeptIds(idl);
        List<PersonDto> ll = this.personMapper.dataGrid(person,pageHelper);
        dataPage.setTotal(pageHelper.getTotal());
        dataPage.setData(ll);
//        List<PersonDto> data=new ArrayList<>();
//        for(Person p:ll){
//            PersonDto pd=new PersonDto();
//            BeanUtils.copyProperties(p,pd);
//            if(null!=p.getDeptId()){
//                Dept d=this.deptService.queryById(p.getDeptId());
//                pd.setDeptName(d.getName());
//                Unit u=this.unitMapper.selectByPrimaryKey(d.getUnitId().longValue());
//                pd.setUnitName(u.getName());
//            }
//
//            data.add(pd);
//        }
//        dataPage.setData(data);
        return dataPage;
    }

    void checkDuplicate(List<Person> pl, PersonDto p, String str) {
        if (pl.size() == 0) {
            return;
        }
        if (p.getId() != null && p.getId().equals(pl.get(0).getId())) {
            return;
        }
        throw new BaseException(str + "不能重复");
    }

    @Override
    public void addEdit(PersonDto person, SessionInfo sessionInfo) {
        PersonExample personExample = new PersonExample();

        PersonExample.Criteria c = personExample.createCriteria();
        List<Person> pl=null;
        if(!StringUtil.isEmpty(person.getWorkNumber())){
            c.andWorkNumberEqualTo(person.getWorkNumber());
            pl= this.personMapper.selectByExample(personExample);
            checkDuplicate(pl, person, "工号");
        }

        if(!StringUtil.isEmpty(person.getUserPhone())) {
            personExample.clear();
            c = personExample.createCriteria();
            c.andUserPhoneEqualTo(person.getUserPhone());
            pl = this.personMapper.selectByExample(personExample);
            checkDuplicate(pl, person, "手机号");
        }

        if(!StringUtil.isEmpty(person.getUserName())) {
            personExample.clear();
            c = personExample.createCriteria();
            c.andUserNameEqualTo(person.getUserName());
            pl = this.personMapper.selectByExample(personExample);
            checkDuplicate(pl, person, "用户名");
        }
        if (person.getId() == null) {
            if (StringUtil.isEmpty(person.getPassword())) {//新增时为默认密码
                person.setPassword(Constant.DEFAULT_PASSWORD);
                person.encodePwd();
            }
            person.setCreatedate(new Date());
            person.setCreateuser(sessionInfo.getName());
            person.setYxbz(Short.valueOf("1"));
            this.personMapper.insert(person);
        } else {
            if (!StringUtil.isEmpty(person.getPassword())) {//新增时为默认密码
                person.setPassword(person.getPassword());
                person.encodePwd();
            }
            Person p=this.personMapper.selectByPrimaryKey(person.getId());
            if(Constant.ADMIN.equals(p.getUserName())){
                throw new BaseException("不能修改admin");
            }
            this.personMapper.updateByPrimaryKeySelective(person);
        }
    }

    @Override
    public void changeInuse(Long id,SessionInfo info) {
        Person p=this.personMapper.selectByPrimaryKey(id);
        if(p.getYxbz()==1){//启用
            p.setYxbz(Short.valueOf("0"));
        }else{
            p.setYxbz(Short.valueOf("1"));
        }
        personMapper.updateByPrimaryKey(p);
    }

    @Override
    public void grant(Long userId,String ids) {
        PersonRoleExample example=new PersonRoleExample();
        example.createCriteria().andPersonIdEqualTo(userId);
        this.personRoleMapper.deleteByExample(example);
        for(String id:ids.split(",")){
            PersonRole pr=new PersonRole();
            pr.setPersonId(userId);
            pr.setRoleId(Long.parseLong(id));
            personRoleMapper.insert(pr);
        }
    }

    @Override
    public PersonDto findByPersonId(Long id) {
        Person p= this.personMapper.selectByPrimaryKey(id);
        PersonDto personDto=new PersonDto();
        Dept d=this.deptService.queryById(p.getDeptId());
        BeanUtils.copyProperties(p,personDto);
        personDto.setDeptName(d.getName());
        return personDto;
    }


    @Override
    public List<Dept> findUserDept(SessionInfo sessionInfo) {
        return null;
    }


    @Override
    public void resetPwd(PersonDto person) {
        Person p1=this.personMapper.selectByPrimaryKey(person.getId());
        if(p1.getYxbz()!=0 && "admin".equals(p1.getUserName())){
            throw new BaseException("不能重置admin");
        }
        person.setUserName(p1.getUserName());
        person.setPassword(Constant.DEFAULT_PASSWORD);
        if("admin".equals(person.getUserName())){
            person.setYxbz(Short.valueOf("1"));
        }
        person.encodePwd();
        Person p = new Person();
        BeanUtils.copyProperties(person, p);
        this.personMapper.updateByPrimaryKeySelective(p);
    }

    @Override
    public DataPage<PersonDto> getUserForGzrw(PersonDto personDto) {
        List<PersonDto> data=new ArrayList<>();
        if(personDto.getIsSelectEd()!=null && personDto.getIsSelectEd()==0){
            data=this.personMapper.selectFreePerson(personDto);
        }else{
            data=this.personMapper.selectRwPerson(personDto);
        }

        DataPage<PersonDto> dp= new DataPage<>();
        dp.setTotal(data.size());
        dp.setData(data);
        dp.setPage(1);
        dp.setRows(data.size());
        return dp;
    }

    @Override
    public void resetAdmin() {
        PersonExample personExample=new PersonExample();
        personExample.createCriteria().andUserNameEqualTo("admin");
        List<Person>pl=this.personMapper.selectByExample(personExample);
        if(pl.size()==0||pl.size()>1){
            throw new BaseException("admin不存在");
        }
        Person p=pl.get(0);
        PersonDto pd=new PersonDto();
        BeanUtils.copyProperties(p,pd);
        resetPwd(pd);
    }

    @Override
    public List<RoleDto> userRoleList(Long userId,String type) {
        PersonRoleExample personRoleExample=new PersonRoleExample();
        personRoleExample.createCriteria().andPersonIdEqualTo(userId);
        List<PersonRole> prl=this.personRoleMapper.selectByExample(personRoleExample);
        List<RoleDto>data=new ArrayList<>();
        Set<Long>checkSet=new HashSet<>();
        boolean onshow="show".equals(type);
        for(PersonRole pr:prl){
            Role r=this.roleMapper.selectByPrimaryKey(pr.getRoleId());
            if(onshow){
                RoleDto roleDto=new RoleDto();
               BeanUtils.copyProperties(r,roleDto);
               data.add(roleDto);
            }else{
                checkSet.add(r.getId());
            }
        }
        if(!onshow){//进行下一步处理
            List<Role>rol=this.roleMapper.selectByExample(new RoleExample());
            for(Role r:rol){
                RoleDto roleDto=new RoleDto();
                BeanUtils.copyProperties(r,roleDto);
                if(checkSet.contains(r.getId())){
                    roleDto.setChecked(true);
                }
                data.add(roleDto);
            }
        }
        return data;
    }

    @Override
    public void updateRole(String ids,Long userId, SessionInfo info) {
        PersonRoleExample personRoleExample=new PersonRoleExample();
        personRoleExample.createCriteria().andPersonIdEqualTo(userId);
        this.personRoleMapper.deleteByExample(personRoleExample);
        for(String s:ids.split(",")){
            PersonRole pr=new PersonRole();
            pr.setRoleId(Long.parseLong(s));
            pr.setPersonId(userId);
            this.personRoleMapper.insert(pr);
        }
    }

    @Override
    public List<PersonDto> listByDeptType(String deptType) {
        return personMapper.selectByDeptType(deptType);
    }
}
