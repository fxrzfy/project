package com.api.controller;

import com.biz.dto.leave.QjsqDto;
import com.biz.service.LeaveService;
import com.core.dto.PersonDto;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.UserService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.BaseException;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/user/")
public class UserApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private LeaveService leaveService;
    @ResponseBody
    @RequestMapping("get")
    public ResultDto<PersonDto> login(){
        SessionInfo info= SessionUtil.getSessionInfo();
        return AppUtil.returnAppSuccess(info);
    }
    @ResponseBody
    @RequestMapping("edit")
    public ResultDto<PersonDto> edit(PersonDto person){
        if(null==person.getId()){
            throw new BaseException("用户id不能为空");
        }
        userService.addEdit(person, SessionUtil.getSessionInfo());
        return AppUtil.returnAppSuccess("");
    }

    @ResponseBody
    @RequestMapping("leaveList")
    public ResultDto<PersonDto> leaveList(PageHelper pageHelper){
        pageHelper.initApi();
        QjsqDto qjsqDto=new QjsqDto();
        SessionInfo info=SessionUtil.getSessionInfo();
        qjsqDto.setWorkNumber(info.getWorkNumber());
        return AppUtil.returnAppSuccess(leaveService.dataGrid(qjsqDto,pageHelper));
    }
    @ResponseBody
    @RequestMapping("leaveAddEdit")
    public ResultDto<PersonDto> leaveAdd(QjsqDto qjsqDto){
        SessionInfo info=SessionUtil.getSessionInfo();
        qjsqDto.setWorkNumber(info.getWorkNumber());
        qjsqDto.setDeptName(info.getPerson().getDeptName());
        qjsqDto.setDeptId(info.getPerson().getDeptId());
        leaveService.saveUpdate(qjsqDto,info);
        return AppUtil.returnAppSuccess("");
    }

    @ResponseBody
    @RequestMapping("list")
    public ResultDto<List<PersonDto>> list(String deptType){
        return AppUtil.returnAppSuccess(userService.listByDeptType(deptType));
    }
}
