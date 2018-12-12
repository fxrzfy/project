
/*
* Project Name: kmfex-platform-trunk
* File Name: EBizError.java
* Class Name: EBizError
*
* Copyright 2014 showtao.com
*
* Licensed under the showtao.com
*
* http://showtao.com
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
* implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
	
package com.util;




/**
 * Class Name: EBizError
 * Description: business errors which may be recoverable, or should be displayed on web page.
 * @author zhengqingye
 *
 */
public enum EErrorCode implements DisplayableError{
    //Default error
    COMM_INTERNAL_ERROR("COMM0001"),
    
    //Errors for internal technical issues.
    TECH_PARAM_REQUIRED("TECH0001"),
    TECH_DATA_NOT_EXIST("TECH0002"),
    TECH_DATA_INVALID("TECH0003"),
    TECH_OPTIMISTIC_LOCK("TECH0004"),
    
    NULL("","");

    private String errorCode;
    
    //this field is only for display, do not set it if it is not needed.
    private String displayMsg;
    
    private Object[] args;
    
    private static final String DEFAULT_ERROR_MSG = "error.common.unknown";
   
    private EErrorCode(String errorCode, String displayMsg){
        this.errorCode = errorCode;
        this.displayMsg = displayMsg;
    }
    
    private EErrorCode(String errorCode, String displayMsg, String[] args){
        this.errorCode = errorCode;
        this.displayMsg = displayMsg;
        this.args = args;
    }
    
    private EErrorCode(String errorCode){
        this.errorCode = errorCode;
        this.displayMsg = DEFAULT_ERROR_MSG;
    }
    
    @Override
    public boolean isBizError(){
        return !displayMsg.equals(DEFAULT_ERROR_MSG);
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getDisplayMsg() {
        return displayMsg;
    }

    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }

    /**
     * @return return the value of the var args
     */
    @Override
    public Object[] getArgs() {
        return args;
    }

    /**
     * set dynamic args for the message template
     * @param args Set args value
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }
    
}
