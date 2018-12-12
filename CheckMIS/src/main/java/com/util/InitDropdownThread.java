package com.util;

import com.core.service.CodelistDetailService;

import javax.servlet.http.HttpSession;

public class InitDropdownThread extends Thread {
	private Logger logger=Logger.getLogger(InitDropdownThread.class);
	private CodelistDetailService codelistDetailService;
	private HttpSession httpSession;
	@Override
	public void run() {
//		logger.info("开始加载数据");
//		Long start=System.currentTimeMillis();
//		List<CodelistDetail> all=this.codelistDetailService.queryByObject(new CodelistDetail());
//		logger.info("加载数据完成，共有"+all.size()+"条");
//		Map<String, List<CodelistDetail>> allmap=StringUtil.newmapinstance();
//		if(null!=all&& all.size()>0){
//			for(CodelistDetail cd:all){
//				String key=SessionConstantUtil.SESSION_DROPDOWN_PREFIX+cd.getMasterId();
//				List<CodelistDetail>al=allmap.get(key);
//				if(al==null){
//					al=StringUtil.newListInstance();
//				}
//				al.add(cd);
//				allmap.put(key, al);
//			}
//		}
//		logger.info("转换数据完成，共有"+allmap.size()+"条");
//		SessionConstantUtil.addContextValue(httpSession, SessionConstantUtil.SESSION_DROPDOWN_ALL, allmap);
//		SessionConstantUtil.addContextValue(httpSession, SessionConstantUtil.SESSION_DROPDOWN_INITSTATUS, SessionConstantUtil.SESSION_DROPDOWN_STATUSREADY);
//		Long end=System.currentTimeMillis();
//		logger.info("加载数据完成,共耗时"+((end-start)/1000)+"秒。");
	}
	public InitDropdownThread(CodelistDetailService codelistDetailService,
			HttpSession httpSession) {
		super();
		this.codelistDetailService = codelistDetailService;
		this.httpSession = httpSession;
	}
}
