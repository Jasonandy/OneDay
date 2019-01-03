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
package cn.ucaner.oneday.service;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

/**
* @Package：cn.ucaner.raspi.service   
* @ClassName：PinService   
* @Description：   <p> PinService </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:21:13   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PinService {

	/**
	 * 获得pin
	 * @param num
	 * @return
	 */
	Pin getPinByNum(int num);
	
	/**
	 * 定义为GPIO口（数字参数）
	 * @param num
	 * @param name
	 * @param state
	 * @return
	 */
	GpioPinDigitalOutput provisionGpio(int num, String name, PinState state);

	/**
	 * @Description: provisionGpio
	 * @param pin
	 * @param name
	 * @Autor: Jason
	 */
	void  provisionGpio(Pin pin, String name, PinState high);
}
