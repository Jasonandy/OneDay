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
package cn.ucaner.oneday.mqtt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**     
* @Package：cn.ucaner.oneday.mqtt.config   
* @ClassName：MqttConfiguration   
* @Description：   <p> MqttConfiguration</p>
* @Author： - Jason    
* @CreatTime：2019年1月9日 下午2:50:37   
* @Modify By：   
* @ModifyTime：  2019年1月9日
* @Modify marker：   
* @version    V1.0
*/
@Component
@ConfigurationProperties(prefix = "cn.ucaner.mqtt")
public class MqttConfiguration {
	
	/**
	 * 主机host:port
	 */
	private String host;

	/**
	 * 客户端id
	 */
    private String clientid;
    
    /**
     * 主题
     */
    private String topic;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 超时重连
     */
    private int timeout;

    /**
     * 存活时间
     */
    private int keepalive;

	/**  
	* @return host  
	*/
	public String getHost() {
		return host;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setHost(String host) {
		this.host = host;
	}

	/**  
	* @return clientid  
	*/
	public String getClientid() {
		return clientid;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**  
	* @return topic  
	*/
	public String getTopic() {
		return topic;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**  
	* @return username  
	*/
	public String getUsername() {
		return username;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setUsername(String username) {
		this.username = username;
	}

	/**  
	* @return password  
	*/
	public String getPassword() {
		return password;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setPassword(String password) {
		this.password = password;
	}

	/**  
	* @return timeout  
	*/
	public int getTimeout() {
		return timeout;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**  
	* @return keepalive  
	*/
	public int getKeepalive() {
		return keepalive;
	}

	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setKeepalive(int keepalive) {
		this.keepalive = keepalive;
	}

}
