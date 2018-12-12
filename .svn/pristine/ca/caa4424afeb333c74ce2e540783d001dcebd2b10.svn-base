/*

 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSON;
import com.common.exception.BizException;
import com.core.pageModel.Json;
import com.core.pageModel.SessionInfo;
import com.util.ConfigUtil;

/**
 * Class Name: BaseController Description: TODO
 * 
 * @author zhengqingye
 * 
 */

public abstract class BaseApiController {
	private Logger logger=Logger.getLogger(BaseApiController.class);

    public ResultDto<Object> returnSuccessMap(String message,Object data){
    	return returnMap(200, message, data);
    }

    public ResultDto<Object> returnMap(Integer code, String message, Object data){
    	return AppUtil.returnObj(message,code,data);
    }
    
    @ExceptionHandler
    public  void exceptionHandler(HttpServletResponse response, Exception ex) throws Exception{
    	logger.error("", ex);
    	//return returnMap(500, ex.getMessage(), "");
    	response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		if(ex instanceof BizException){
			BizException biz=(BizException)ex;
			response.getWriter().write(JSON.toJSONString(returnMap(biz.getCode(), ex.getMessage(), "")));
	    	response.getWriter().flush();
	    	return;
		}
    	logger.error("", ex);
    	String message=ex.getMessage();
    	if(ex instanceof NullPointerException){
    		message="空指针错误";
    	}
    	
    	response.getWriter().write(JSON.toJSONString(returnMap(500, message, "")));
    	response.getWriter().flush();
    }
    
    public SessionInfo getSessionInfo(HttpServletRequest request){
    	return (SessionInfo)request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
    }
}
