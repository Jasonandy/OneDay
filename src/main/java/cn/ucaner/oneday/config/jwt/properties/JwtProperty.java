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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
* @Package：cn.ucaner.oneday.jwt.properties   
* @ClassName：JwtProperty   
* @Description：   <p> JwtProperty </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:07:13   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@Component
@ConfigurationProperties(prefix = "jwt.info")
@PropertySource(value = "classpath:/jwt/jwt.properties")
public class JwtProperty {

	/**
	 * 用户登录flag标志
	 */
	private String authorFlag;
	
    /**
     * 用户名
     */
    private String username;
    
    /**
	 * 密钥
	 */
    private String secret;
    
    
    /**
     * 过期时间
     */
    private int expireTime;

	public String getAuthorFlag() {
		return authorFlag;
	}

	public void setAuthorFlag(String authorFlag) {
		this.authorFlag = authorFlag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
    
}
