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

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ucaner.oneday.common.utils.DateHelper;
import cn.ucaner.oneday.common.utils.LunarUtils;
import cn.ucaner.oneday.common.vo.OneDayVo;
import cn.ucaner.oneday.common.vo.RespBody;
import cn.ucaner.oneday.config.json.JsonLoader;

/**     
* @Package：cn.ucaner.oneday.controller.api   
* @ClassName：OneDayController   
* @Description：   <p> OneDayController </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:19:51   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
*/
@RestController
@RequestMapping(value = "/oneday/v1")
public class OneDayController {
	
	private static final Logger logger = LoggerFactory.getLogger(OneDayController.class);
	
	/*	
	{
	    "avoid": {
	        "msg": "搞学习"
	    },
	    "day": 2,
	    "lunar": "You are what you want to be.",
	    "month": 1,
	    "slogan": "勿忘初心，方得始终！",
	    "suitable": {
	        "msg": "睡觉觉"
	    },
	    "time": 1546424942685,
	    "week": "星期一",
	    "year": "2019"
	}
	*/
	@RequestMapping("/oneday")
    public RespBody test() {
		RespBody respBody = new RespBody();
		/**
		 * 
		 * 这里做一次数据的封装
		 * 			-- 时间日期封装进去
		 * 			-- 名言格言 --?? 采用什么样的方案? 使用第三方接口还是?
		 * 
		 */
		OneDayVo oneDayVo = null;
		try {
			oneDayVo = new OneDayVo();
			Conver2OneDayVo(oneDayVo);
			respBody.addOK(oneDayVo, "恭喜请求成功!");
		} catch (Exception e) {
			respBody.addError("请求Error!");
			e.printStackTrace();
			logger.error("NowDate:{} api /oneday/v1/oneday 调用失败--:{}",new Date().toString(),e.getMessage());
		}
		return respBody;
    }
	
	
	/**
	 * @Description: Conver2OneDayVo
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
	public static void Conver2OneDayVo(OneDayVo oneDayVo) {
		String today = DateHelper.today();
		String[] strToday = today.split("-");
		oneDayVo.setYear(strToday[0]);
		oneDayVo.setMonth(strToday[1]);
		oneDayVo.setDay(strToday[2]); 
		oneDayVo.setWeek(DateHelper.getChineseWeek());
		oneDayVo.setTime(new Date());
		oneDayVo.setSlogan("勿忘初心方得始终！");
		oneDayVo.setLunar(LunarUtils.getLunarDayStr());
		//oneDayVo.setAvoid(RandomHelper.getRandomValueFromMap(JsonLoader.ONE_DAY_MAP));
		//oneDayVo.setSuitable(RandomHelper.getRandomValueFromMap(JsonLoader.ONE_DAY_MAP));
		oneDayVo.setAvoid(JsonLoader.getAvoid());
		oneDayVo.setSuitable(JsonLoader.getSuitable());
	}
	

}
