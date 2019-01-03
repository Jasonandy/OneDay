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
package cn.ucaner.oneday.config.jwt.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
* @Package：cn.ucaner.oneday.jwt.properties   
* @ClassName：JwtPatternUrl   
* @Description：   <p> JwtPatternUrl 需要做鉴权的url </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:06:59   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@ConfigurationProperties(prefix = "jwt.exclude")
@PropertySource("classpath:/jwt/jwt.properties")
public class JwtPatternUrl {

	/**
	 * 需要过滤的url
	 */
	private List<String> urlPatterns;

    public List<String> getUrlPatterns() {
        return urlPatterns;
    }
    
    public void setUrlPatterns(List<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }

}
