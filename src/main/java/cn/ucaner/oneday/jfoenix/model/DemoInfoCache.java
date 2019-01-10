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
package cn.ucaner.oneday.jfoenix.model;

import java.io.Serializable;

/**
* @Package：cn.ucaner.oneday.jfoenix.model   
* @ClassName：DemoInfoCache   
* @Description：   <p> DemoInfoCache </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:15:21   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class DemoInfoCache implements Serializable {
	
    private static final long serialVersionUID = -4833209259288828879L;
    
    /**
     * DemoInfo 
     */
    private DemoInfo demoInfo;
    
    /**
     * url 
     */
    private String url;

    public DemoInfo getDemoInfo() {
        return demoInfo;
    }

    public void setDemoInfo(DemoInfo demoInfo) {
        this.demoInfo = demoInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
