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
package cn.ucaner.oneday.mqtt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ucaner.oneday.common.utils.RandomHelper;
import cn.ucaner.oneday.common.vo.RespBody;
import cn.ucaner.oneday.mqtt.client.MqttPushClient;
import cn.ucaner.oneday.mqtt.vo.PushPayload;

/**     
* @Package：cn.ucaner.oneday.mqtt   
* @ClassName：MqttController   
* @Description：   <p> MqttController </p>
* @Author： - Jason    
* @CreatTime：2019年1月10日 上午8:53:37   
* @Modify By：   
* @ModifyTime：  2019年1月10日
* @Modify marker：   
* @version    V1.0
*/
@RestController
@RequestMapping(value = "/mqtt/v1")
public class MqttController {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttController.class);
	
	/**
	 * @Description: publishMqtt
	 * @return RespBody
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	@RequestMapping(value="/publish/{topic}")
    public RespBody publishMqtt(@PathVariable(value = "topic") String topic){
		RespBody respBody = new RespBody();
		String publicTopic = "oneday";
		try {
			if (topic!=null) {
				publicTopic=topic;
			}
	        PushPayload pushMessage = PushPayload
	        							.getPushPayloadBuider()
	        							.setTitle("MQTT远程PUSH")
	        							.setMobile(String.valueOf(RandomHelper.getRandomLong(13788409988L)))
	        							.setContent("HelloWorld!")
	        							.setBadge(RandomHelper.getRandomInt(10))
	        							.setType("TYPE")
	        							.bulid();
	        MqttPushClient.getInstance().publish(0, false, publicTopic, pushMessage);
			logger.info("publish-发布成功-PushPayload:{}",pushMessage);
			respBody.addOK(pushMessage, "publish-发布成功");
		} catch (Exception e) {
			respBody.addError("发布失败!");
			logger.error("Exception:{}",e.getMessage());
		}
		return respBody;
    }
	
	/**
	 * @Description: subscribeMqtt 
	 * @return RespBody
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	@RequestMapping(value ="/subscribe/{topic}/{qos}")
    public RespBody subscribeMqtt(@PathVariable(value = "topic") String topic,@PathVariable(value = "qos") Integer qos){
		RespBody respBody = new RespBody();
		String publicTopic = "oneday";
		try {
			MqttPushClient.getInstance().subscribe(topic==null?publicTopic:topic,qos==null?0:qos);
			respBody.addOK("订阅成功!");
		} catch (Exception e) {
			respBody.addError("订阅失败!");
			logger.error("Exception:{}",e.getMessage());
		}
		return respBody;
    }
}
