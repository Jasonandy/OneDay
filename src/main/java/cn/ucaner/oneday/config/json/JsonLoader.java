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
package cn.ucaner.oneday.config.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import cn.ucaner.oneday.common.utils.RandomHelper;

/**     
* @Package：cn.ucaner.oneday.config.json   
* @ClassName：JsonLoader   
* @Description：   <p> 本地json文件加载器</p>
* @Author： - Jason    
* @CreatTime：2019年1月7日 下午2:31:52   
* @Modify By：   
* @ModifyTime：  2019年1月7日
* @Modify marker：   
* @version    V1.0
*/
public class JsonLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonLoader.class);
	
	/**
	 * json文件位置
	 */
	private static final String ONEDAY_JSON_FILE_PATH = "classpath:json/oneday.json";
	//private static final String AVOID_JSON_FILE_PATH = "classpath:json/avoid.json";
	//private static final String SUITABLE_JSON_FILE_PATH = "classpath:json/suitable.json";
	
	/**
	 * dataMap存储json数据的map容器
	 */
	public static Map<String, Object> ONE_DAY_MAP = new HashMap<String, Object>();
	//public static Map<String, Object> AVOID_MAP = new HashMap<String, Object>();
	//public static Map<String, Object> SUITABLE_MAP = new HashMap<String, Object>();
	
	/**
	 * 初始化加载
	 */
	static {
		convert2Map(ONEDAY_JSON_FILE_PATH);
		//convert2Map(AVOID_JSON_FILE_PATH,AVOID_MAP);
		//convert2Map(SUITABLE_JSON_FILE_PATH,SUITABLE_MAP);
		logger.debug("------------------------JsonLoader加载json文件初始化成功----------------------------------");
	}
	
	
	/**
	 * @Description: convert2Map
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	public static void convert2Map(String filePath) {
		try {
			String jsonData = FileUtils.readFileToString(ResourceUtils.getFile(filePath));
			ONE_DAY_MAP = JSON.parseObject(jsonData,new TypeReference<HashMap<String,Object>>() {});
		} catch (IOException e) {
			logger.error("本地json配置文件加载初始化异常:{}",e.getMessage());
		}
	}
	
	
	/**
	 * @Description: JUST4TEST
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	public static void main(String[] args) {
		//System.out.println(ONE_DAY_MAP);
		//Object randomValueFromMap = RandomHelper.getRandomValueFromMap(JsonLoader.ONE_DAY_MAP);
		//Object suitableObject = ONE_DAY_MAP.get("suitable");
		//Object avoidObject = ONE_DAY_MAP.get("avoid");
		//HashMap<String, Object> parseSuitableObject = JSON.parseObject(suitableObject.toString(),new TypeReference<HashMap<String,Object>>() {});
		//HashMap<String, Object> parseAvoidObject= JSON.parseObject(avoidObject.toString(),new TypeReference<HashMap<String,Object>>() {});
		System.out.println(getSuitable());
		System.out.println(getAvoid());
		//System.out.println(randomValueFromMap);
	}
	
	/**
	 * @Description: getSuitable
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	public static Object getSuitable() {
		Object suitableObject = ONE_DAY_MAP.get("suitable");
		HashMap<String, Object> parseSuitableObject = JSON.parseObject(suitableObject.toString(),new TypeReference<HashMap<String,Object>>() {});
		return RandomHelper.getRandomValueFromMap(parseSuitableObject);
	}
	
	/**
	 * @Description: getAvoid
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	public static Object getAvoid() {
		Object avoidObject = ONE_DAY_MAP.get("avoid");
		HashMap<String, Object> parseAvoidObject= JSON.parseObject(avoidObject.toString(),new TypeReference<HashMap<String,Object>>() {});
		return RandomHelper.getRandomValueFromMap(parseAvoidObject);
	}
	
	/**  
	* JsonLoader.   
	*/  
	private JsonLoader() {
		super();
	}
	
}
