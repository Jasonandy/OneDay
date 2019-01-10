/******************************************************************************
* ~ Copyright (c) 2018 [jasonandy@hotmail.com | https://github.com/Jasonandy] *
* ~                                                                           *
* ~ Licensed under the Apache License, Version 2.0 (the "License”);           * 
* ~ you may not use this file except in compliance with the License.          *
* ~ You may obtain a copy of the License at                                   *
* ~                                                                           *
* ~    http://www.apache.org/licenses/LICENSE-2.0                             *
* ~                                                                           *
* ~ Unless required by applicable law or agreed to in writing, software       *
* ~ distributed under the License is distributed on an "AS IS" BASIS,         *
* ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
* ~ See the License for the specific language governing permissions and       *
* ~ limitations under the License.                                            *
******************************************************************************/
package cn.ucaner.oneday.jfoenix.util;

import org.apache.http.HttpStatus;

/**
* @Package：cn.ucaner.oneday.jfoenix.util   
* @ClassName：HttpResponse   
* @Description：   <p> HttpResponse </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:15:02   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class HttpResponse {
	
	/**
	 * SC_INTERNAL_SERVER_ERROR - 500
	 */
    private int status = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    
    /**
     * data
     */
    private String data;
    
    /**
     * 异常
     */
    private Exception exception;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
