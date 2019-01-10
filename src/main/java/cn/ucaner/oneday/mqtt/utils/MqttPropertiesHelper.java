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
package cn.ucaner.oneday.mqtt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.util.PropertiesUtil;

import com.alibaba.fastjson.JSON;

/**     
* @Package：cn.ucaner.oneday.mqtt.utils   
* @ClassName：PropertiesHelper   
* @Description：   <p> PropertiesHelper </p>
* @Author： - Jason    
* @CreatTime：2019年1月9日 下午3:03:45   
* @Modify By：   
* @ModifyTime：  2019年1月9日
* @Modify marker：   
* @version    V1.0
*/
public class MqttPropertiesHelper {
	
   /**
   * 配置文件位置
   */
   private static String MQTT_PROPERTIES = "/mqtt/mqtt.properties";

	
   /**
    * MQTT_HOST 
    */
   public static String MQTT_HOST;
   
   /**
    * MQTT_CLIENTID
    */
   public static String MQTT_CLIENTID;
   
   /**
    * MQTT_USER_NAME 
    */
   public static String MQTT_USER_NAME;
   
   /**
    * MQTT_PASSWORD
    */
   public static String MQTT_PASSWORD;
   
   /**
    * MQTT_TIMEOUT
    */
   public static int MQTT_TIMEOUT;
   
   /**
    * MQTT_KEEP_ALIVE
    */
   public static int MQTT_KEEP_ALIVE;
   
   /**
    * 静态加载mqtt配置文件
    */
   static {
      MQTT_HOST = loadMqttProperties().getProperty("cn.ucaner.mqtt.host");
      MQTT_CLIENTID = loadMqttProperties().getProperty("cn.ucaner.mqtt.clientid");
      MQTT_USER_NAME = loadMqttProperties().getProperty("cn.ucaner.mqtt.username");
      MQTT_PASSWORD = loadMqttProperties().getProperty("cn.ucaner.mqtt.password");
      MQTT_TIMEOUT = Integer.valueOf(loadMqttProperties().getProperty("cn.ucaner.mqtt.timeout"));
      MQTT_KEEP_ALIVE = Integer.valueOf(loadMqttProperties().getProperty("cn.ucaner.mqtt.keepalive"));
   }

   
   /**
    * @Description: loadMqttProperties 加载配置文件  
    * @return Properties
    * @Autor: @Jason - jasonandy@hotmail.com
    */
   private static Properties loadMqttProperties() {
      InputStream inputstream = PropertiesUtil.class.getResourceAsStream(MQTT_PROPERTIES);
      Properties properties = new Properties();
      try {
         properties.load(inputstream);
         return properties;
      } catch (IOException e) {
         throw new RuntimeException(e);
      } finally {
         try {
            if (inputstream != null) {
               inputstream.close();
            }
         } catch (IOException e) {
            throw new RuntimeException(e);
         }
      }
   }
   
   public static void main(String[] args) {
	   System.out.println(JSON.toJSONString(MqttPropertiesHelper.loadMqttProperties()));
   }

}
