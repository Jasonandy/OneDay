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

	@Override
	public void connectionLost(Throwable cause) {
		// 连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		 // subscribe后得到的消息会执行到这里面
        System.out.println("接收消息主题 : " + topic);
        System.out.println("接收消息Qos : " + message.getQos());
        System.out.println("接收消息内容 : " + new String(message.getPayload()));
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("deliveryComplete---------" + token.isComplete());
	}

}
