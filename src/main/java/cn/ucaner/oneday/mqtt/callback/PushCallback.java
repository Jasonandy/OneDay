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
package cn.ucaner.oneday.mqtt.callback;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**     
* @Package：cn.ucaner.oneday.mqtt.callback   
* @ClassName：PushCallback   
* @Description：   <p> PushCallback </p>
* @Author： - Jason    
* @CreatTime：2019年1月9日 下午3:16:39   
* @Modify By：   
* @ModifyTime：  2019年1月9日
* @Modify marker：   
* @version    V1.0
*/
public class PushCallback implements MqttCallback{
	
	private static final Logger logger = LoggerFactory.getLogger(PushCallback.class);

	@Override
	public void connectionLost(Throwable cause) {
		// 连接丢失后，一般在这里面进行重连
        logger.info("***连接断开-可以做重连-开始重连...");
//        while (true){
//            try {//如果没有发生异常说明连接成功，如果发生异常，则死循环
//                Thread.sleep(1000);
//                MqttPushClient.getInstance();//重连
//                logger.info("***MQTT_RECONNECT***");
//                break;
//            }catch (Exception e){
//                continue;
//            }
//        }
	}

	/**
	 * 订阅成功后的处理-subscribe后得到的消息会执行到这里面
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		logger.info("------------------subscribe success-----------");
		logger.info("**接收消息主题  :{} **",topic);
		logger.info("**接收消息Qos  :{} **",message.getQos());
		logger.info("**接收消息内容  :{} **",new String(message.getPayload()));
		logger.info("----------------------------------------------");
	}

	
	/**
	 * 传输完毕
	 */
	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		logger.info("*****DELIVERY_COMPLETE:TOKEN_IS_COMPLETE:{}*****",token.isComplete());
	}

}
