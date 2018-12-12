package com.core.controller;

import com.core.dto.PersonDto;
import com.core.model.checkmis.Person;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.UserService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.ConfigUtil;
import com.util.SessionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Description: 岗位信息表 Controller类</p>
 * Created on
 *
 * @author
 * @version 1.0
 */
@Controller
@RequestMapping("/personController")
public class PersonController{
    private static final Logger logger = Logger.getLogger(PersonController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/session/get")
    public ResultDto<Person> sessionUser() {
        SessionInfo info= SessionUtil.getSessionInfo();
        return AppUtil.returnSuccess(info);
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public ResultDto<List<PersonDto>> list(PersonDto person, PageHelper page, HttpServletRequest request) {
        SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(userService.dataGrid(person, page, sessionInfo));
    }
    public ResultDto<Person> login(PersonDto personDto){
        return AppUtil.returnSuccess(this.userService.login(personDto));
    }

    @RequestMapping("/get")
    @ResponseBody
    public ResultDto<PersonDto> get(HttpServletRequest request, Long id) {
        return AppUtil.returnSuccess(userService.findByPersonId(id));
    }

    @RequestMapping("/resetPwd")
    @ResponseBody
    public ResultDto<String> resetPwd(HttpServletRequest request,PersonDto personDto) {
        userService.resetPwd(personDto);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public ResultDto<String> add(PersonDto person) {
        userService.addEdit(person, SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/grant")
    @ResponseBody
    public ResultDto<String>  grant(Long userId,String ids) {
            userService.grant(userId,ids);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/changeInuse")
    @ResponseBody
    public ResultDto<String> delete(Long id) {
        userService.changeInuse(id,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/userRoleList")
    @ResponseBody
    public ResultDto<String> userRoleList(Long id,String type) {
        return AppUtil.returnSuccess(userService.userRoleList(id,type));
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public ResultDto<String> updateRole(String ids,Long userId) {
        this.userService.updateRole(ids,userId,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }


}
