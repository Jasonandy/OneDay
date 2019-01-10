/******************************************************************************
* ~ Copyright (c) 2019 [jasonandy@hotmail.com | https://github.com/Jasonandy] *
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.util.PropertiesUtil;

import com.alibaba.fastjson.JSON;

/**
* @Package：cn.ucaner.oneday.config.jwt.properties   
* @ClassName：JwtPropertiesHelper   
* @Description：   <p> JwtPropertiesHelper </p>
* @Author： - Jason    
* @CreatTime：2019年1月10日 下午6:57:02   
* @Modify By：   
* @ModifyTime：  2019年1月10日
* @Modify marker：   
* @version    V1.0
 */
public class JwtPropertiesHelper {
	
   /**
   * 配置文件位置  - 这里耦合性还是太强
   */
   private static String JWT_PROPERTIES = "/jwt/jwt.properties";

	
   /**
    * AUTHOR_FLAG 
    */
   public static String AUTHOR_FLAG;
   
   /**
    * SECRET
    */
   public static String SECRET;
   
   /**
    * USER_NAME 
    */
   public static String USER_NAME;
   
   /**
    * EXPIRE_TIME
    */
   public static String EXPIRE_TIME;
   
   /**
    * 静态加载jwt配置文件
    */
   static {
	   AUTHOR_FLAG = loadMqttProperties().getProperty("jwt.info.authorFlag");
	   SECRET = loadMqttProperties().getProperty("jwt.info.secret");
	   USER_NAME = loadMqttProperties().getProperty("jwt.info.username");
	   EXPIRE_TIME = loadMqttProperties().getProperty("jwt.info.expireTime");
   }
   
   /**
    * @Description: loadMqttProperties 加载配置文件  
    * @return Properties
    * @Autor: @Jason - jasonandy@hotmail.com
    */
   private static Properties loadMqttProperties() {
      InputStream inputstream = PropertiesUtil.class.getResourceAsStream(JWT_PROPERTIES);
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
   
   
   
   /**  
	* JwtPropertiesHelper.   
	*/  
	private JwtPropertiesHelper() {
		super();
	}

	
	/**
    * @Description: JUST4TEST
    * @Autor: @Jason - jasonandy@hotmail.com
    */
   public static void main(String[] args) {
	   System.out.println(JSON.toJSONString(JwtPropertiesHelper.loadMqttProperties()));
   }

}
