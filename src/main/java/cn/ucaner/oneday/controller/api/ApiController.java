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
package cn.ucaner.oneday.controller.api;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.ucaner.oneday.common.utils.SpringContextUtil;
import cn.ucaner.oneday.common.vo.RespBody;
import cn.ucaner.oneday.common.vo.RespBody.Status;
import cn.ucaner.oneday.config.jwt.properties.JwtPatternUrl;
import cn.ucaner.oneday.config.jwt.properties.JwtProperty;

/**
* @Package：cn.ucaner.oneday.controller.api   
* @ClassName：ApiController   
* @Description：   <p>  ApiController api接口测试类 </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:05:19   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	 /**
     * jwt需要做处理的连接
     */
    @Autowired
    private JwtPatternUrl jwtPatternUrl;
    
    @Autowired
    private JwtProperty jwtProperty;
    
	@RequestMapping("/test")
    public RespBody jwtToken() {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("name", "jwt");
		hashMap.put("value", "pass");
		JwtPatternUrl bean = SpringContextUtil.getBean(JwtPatternUrl.class);
		logger.info("Api--配置注入jwtPatternUrl:{},jwtProperty:{},BEAN:{}",JSON.toJSONString(jwtPatternUrl),JSON.toJSONString(jwtProperty),bean);
		return new RespBody(Status.OK,hashMap);
    }

}
