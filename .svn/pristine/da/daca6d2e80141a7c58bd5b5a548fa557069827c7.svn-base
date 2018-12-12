package com.util;

import com.common.constant.Constant;
import com.core.dto.DropDownDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SessionConstantUtil {
	public static final Map<String,List<DropDownDto>>allDropDown=new HashMap<>();

	public static void addData(String key,DropDownDto ddd){
		List<DropDownDto> al=allDropDown.get(key);
		if(al==null){
			al=new ArrayList<>();
		}
		al.add(ddd);
		allDropDown.put(key,al);
	}
	public static boolean isInit(){
		return allDropDown.get(Constant.SESSION_UTIL_INIT_KEY)==null;
	}
	public static void initDone(){
		 allDropDown.put(Constant.SESSION_UTIL_INIT_KEY,new ArrayList<>());
	}
	public static void clear(){
		allDropDown.clear();
	}

//	public final static String  SESSION_DROPDOWN_PREFIX="session_dropdown_";
//	public final static String  SESSION_DROPDOWN_ALL="session_dropdown_all";
//	public final static String  SESSION_DROPDOWN_INITSTATUS="session_dropdown_initstatus";
//	public final static String  SESSION_DROPDOWN_STATUSREADY="session_dropdown_initReady";
//	public final static String  SESSION_MATERIAL_DETAIL_PREFIX="session_material_detail_";
//	//标记session中的物料明细有没有被修改
//	public final static String  SESSION_MATERIAL_CHANGEFLAG="session_material_changflag";
//
//	public static String getMaterialDetailKey(String materidalID){
//		return SESSION_MATERIAL_DETAIL_PREFIX+materidalID;
//	}
//	public static Map<String, String> CODELISTSHOW=StringUtil.newmapinstance();
//	static{
//		CODELISTSHOW.put("0", "显示");
//		CODELISTSHOW.put("1", "隐藏");
//	}

//    @Autowired
//    private AccidentTypeService accidentTypeService;

    private static SessionConstantUtil sessionConstantUtil;

//    public void setAccidentTypeService(AccidentTypeService accidentTypeService) {
//        this.accidentTypeService = accidentTypeService;
//    }

//    @PostConstruct
//    public void init() {
//        sessionConstantUtil = this;
//        sessionConstantUtil.accidentTypeService = this.accidentTypeService;
//    }

//	public static String getSessionConstansStatus(HttpSession session){
//		ServletContext context=session.getServletContext();
//		return (String)context.getAttribute(SESSION_DROPDOWN_INITSTATUS);
//	}
//	public static void addContextValue(HttpSession session,String key,Object value){
//		ServletContext context=session.getServletContext();
//		context.setAttribute(key, value);
//	}
//	public static Map<String, String> getDropdownMapByType(HttpSession session,String ...params){
//		String key="null";
//		String display="0";
//		boolean addselectoption=true;
//		boolean returnnamemap=false;//如果选择了这个返回name为key value
//		try {
//			key=params[0];
//			display=params[1];
//			addselectoption=Boolean.valueOf(params[2]);
//			returnnamemap=Boolean.valueOf(params[3]);
//		} catch (Exception e) {
//			//
//		}
//		@SuppressWarnings("unchecked")
//		Map<String, List<CodelistDetail>> allmap=((Map<String, List<CodelistDetail>>)session.getServletContext().getAttribute(SESSION_DROPDOWN_ALL));
//		List<CodelistDetail> cdList=allmap.get(SESSION_DROPDOWN_PREFIX+key);
//		Map<String, String> resultMap=new HashMap<String, String>();
//		if(addselectoption){
//			resultMap.put("", "请选择");
//		}
//		if(null!=cdList && cdList.size()>0){
//			for(CodelistDetail cd:cdList){
//				if("0".equals(display) && "1".equals(cd.getStatus())){
//					continue;
//				}
//				String K,V;
//				K=cd.getKey();
//				V=cd.getName();
//				if(returnnamemap){
//					String tmp;
//					tmp=K;
//					K=V;
//					V=tmp;
//				}
//				resultMap.put(K, V);
//			}
//		}
//		//Collections.sort();
//		return resultMap;
//	}
//
//	private static List<Map.Entry<String, String>> sortMapResult(Map<String, String> resultMap){
//		List<Map.Entry<String, String>> listmap =
//			    new ArrayList<Map.Entry<String, String>>(resultMap.entrySet());
//		Collections.sort(listmap, new Comparator<Map.Entry<String, String>>() {
//		    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//		        return (o1.getKey()).toString().compareTo(o2.getKey());
//		    }
//		});
//		return listmap;
//	}
//
//
//
//	public static Map<String, String> getDropdownMap(HttpSession session,String key){
//		return getDropdownMapByType(session, key, "0");
//	}
//	public static Map<String, String> getDropdownShowMap(HttpSession session,String key){
//		return getDropdownMapByType(session, key, null);
//	}
//	public static Map<String, String> getDropNameMap(HttpSession session,String key){
//		return getDropdownMapByType(session, key, null,"false","true");
//	}
//	public static void addDropdownMap(HttpServletRequest request,String key){
//		request.setAttribute(SESSION_DROPDOWN_PREFIX+key,sortMapResult(getDropdownMap(request.getSession(), key)));
//	}
//	public static void addDropdownShowMap(HttpServletRequest request,String key){
//		request.setAttribute(SESSION_DROPDOWN_PREFIX+key,sortMapResult(getDropdownShowMap(request.getSession(), key)));
//	}
//	/**
//	 * 使用逗号分割字符串，将所有的添加到对应的地方
//	 * @param request
//	 * @param keys
//	 */
//	public static void addALLDropdownMap(HttpServletRequest request,String ...keys){
//		if(null==keys){
//			return;
//		}
//		boolean isShow=false;
//		if(keys.length>1){
//			if("show".equals(keys[1])){
//				isShow=true;
//			}
//		}
//		for(String key:keys[0].split(",")){
//            if("smalltype".equals(key)){
//                //addDropdownMapForSmallType(request);
//                continue;
//            }
//			if(isShow){
//				addDropdownShowMap(request, key);
//			}else{
//				addDropdownMap(request, key);
//			}
//		}
//	}
//
//	public static DataGrid initMapForDataGrid(DataGrid dg,HttpSession session,String keys){
//		if(null==keys||"".equals(keys)){
//			return dg;
//		}
////		for(String key:keys.split(",")){
////            Map<String,String> m;
////            if("smalltype".equalsIgnoreCase(key)){
////                m = sessionConstantUtil.accidentTypeService.getDropdownMap();
////            }else {
////                m = getDropdownMapByType(session, key, null, "false");//不添加请选择
////            }
////            dg.addDpm(key, m);
////		}
//
//		return dg;
//	}
//	public static String getDropDownValue(Map<String, Map<String,String>> dropMap,String codeKey,String key){
//		return dropMap.get(codeKey)==null?null:dropMap.get(codeKey).get(key);
//	}
//
////    public static void addDropdownMapForSmallType(HttpServletRequest request){
////        Map smallMap = new HashMap();
////        List<AccidentType> accidentTyleList = sessionConstantUtil.accidentTypeService.queryByObject(new AccidentType());
////        for(AccidentType accidentType:accidentTyleList){
////            if(!StringUtils.isEmpty(accidentType.getParentId())){
////                if(smallMap.get(accidentType.getParentId()) == null){
////                    Map map = new HashMap();
////                    //map.put("","请选择");
////                    smallMap.put(accidentType.getParentId(), map);
////                }
////                ((Map) smallMap.get(accidentType.getParentId())).put(String.valueOf(accidentType.getId()), accidentType.getTypeName());
////            }
////        }
////        List smallTypeList = new ArrayList();
////        for(Object key:smallMap.keySet()) {
////            Map map = new HashMap();
////            map.put("id", key);
////            map.put("dropDown",sortMapResult((Map<String, String>) smallMap.get(key)));
////            smallTypeList.add(map);
////            //request.setAttribute(SESSION_DROPDOWN_PREFIX + "smalltype_" + key.toString(), sortMapResult((Map<String, String>) smallMap.get(key)));
////        }
////        request.setAttribute(SESSION_DROPDOWN_PREFIX + "smalltype",smallTypeList);
////
//    }

}
