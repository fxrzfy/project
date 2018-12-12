
/*
* Project Name: kmfex-platform-trunk
* File Name: KmfexBaseException.java
* Class Name: KmfexBaseException
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
 * Class Name: KmfexBaseException
 * Description: TODO
 * @author zhengqingye
 *
 */

public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected DisplayableError error = EErrorCode.COMM_INTERNAL_ERROR;
    
    public BaseException(){
        super();
    }
    
    public BaseException(DisplayableError error){
        this.error = error;
    }
    
    public BaseException(DisplayableError error, String message){
        super(message);
        this.error = error;
        
    }
    
    public BaseException(DisplayableError error, String message, Throwable cause){
        super(message, cause);
        this.error = error;
    }

    public DisplayableError getError() {
        return error;
    }

    public BaseException(String message) {
        super(message);
    }
}
