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
package cn.ucaner.oneday.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.oneday.mqtt.callback.PushCallback;
import cn.ucaner.oneday.mqtt.utils.MqttPropertiesHelper;
import cn.ucaner.oneday.mqtt.vo.PushPayload;

/**     
* @Package：cn.ucaner.oneday.mqtt.client   
* @ClassName：MqttPushClient   
* @Description：   <p> MqttPushClient </p>
* @Author： - Jason    
* @CreatTime：2019年1月9日 下午2:56:43   
* @Modify By：   
* @ModifyTime：  2019年1月9日
* @Modify marker：   
* @version    V1.0
*/
public class MqttPushClient {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttPushClient.class);
	
	/**
	 * MqttClient 
	 */
	private MqttClient client;

	/**
	 * mqttPushClient 
	 */
    private static volatile MqttPushClient mqttPushClient = null;

    /**
     * @Description: MqttPushClient.getInstance() 单例
     * @return MqttPushClient
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static MqttPushClient getInstance(){
        if(null == mqttPushClient){
            synchronized (MqttPushClient.class){
                if(null == mqttPushClient){
                    mqttPushClient = new MqttPushClient();
                }
            }
        }
        return mqttPushClient;
    }

    /**
    * MqttPushClient. - connect连接
     */
    private MqttPushClient() {
        connect();
    }

    private void connect(){
	    try {
	        client = new MqttClient(MqttPropertiesHelper.MQTT_HOST, MqttPropertiesHelper.MQTT_CLIENTID, new MemoryPersistence());
	        MqttConnectOptions options = new MqttConnectOptions();
	        options.setCleanSession(false);
	        options.setUserName(MqttPropertiesHelper.MQTT_USER_NAME);
	        options.setPassword(MqttPropertiesHelper.MQTT_PASSWORD.toCharArray());
	        options.setConnectionTimeout(MqttPropertiesHelper.MQTT_TIMEOUT);
	        options.setKeepAliveInterval(MqttPropertiesHelper.MQTT_KEEP_ALIVE);
	        try {
	        	/**
	        	 * 这里设置回调
	        	 */
	            client.setCallback(new PushCallback());
	            client.connect(options);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }

    /**
     * 发布，默认qos为0，非持久化
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic,PushPayload pushMessage){
        publish(0, false, topic, pushMessage);
    }

    /**
     * @Description: 发布 
     * @param qos
     * @param retained
     * @param topic
     * @param pushMessage void
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public void publish(int qos,boolean retained,String topic,PushPayload pushMessage){
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.toString().getBytes());
        MqttTopic mTopic = client.getTopic(topic);
        if(null == mTopic){
        	logger.error("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mTopic.publish(message);
            token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 订阅某个主题，qos默认为0
     * @param topic 
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public void subscribe(String topic){
        subscribe(topic,0);
    }

    /**
     * @Description: 订阅某个主题
     * @param topic
     * @param qos 
     */
    public void subscribe(String topic,int qos){
        try {
            client.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        String kdTopic = "good";
        PushPayload pushMessage = PushPayload
        							.getPushPayloadBuider()
        							.setMobile("18688880000")
        							.setContent("designModel")
        							.bulid();
        MqttPushClient.getInstance().publish(0, false, kdTopic, pushMessage);
    }

}
