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
package cn.ucaner.oneday.service.impl;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.oneday.common.CommonUtils;
import cn.ucaner.oneday.service.PinService;

/**
* @Package：cn.ucaner.oneday.service.impl   
* @ClassName：PinServiceImpl   
* @Description：   <p> PinServiceImpl </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:09:02   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@Service("pinService")
public class PinServiceImpl implements PinService{
	
	
	private static Pin[] pinList = null; 
	
	
	private static GpioPinDigitalOutput[] outputList = null; 

	
	/**
	 * gitPinByNum
	 */
	@Override
	public Pin getPinByNum(int num) {
		if (num < 0 || num > 31) {
			return null;
		}
		if (pinList == null) {
			pinList = RaspiPin.allPins(CommonUtils.boardType);
		}
		return pinList[num];
	}

	@Override
	public GpioPinDigitalOutput provisionGpio(int num, String string, PinState state) {
		if (num < 0 || num > 31) {
			return null;
		}
		if (pinList == null) {
			pinList = RaspiPin.allPins(CommonUtils.boardType);
		}
		if (outputList == null) {
			outputList = new GpioPinDigitalOutput[pinList.length];
		}
		if (outputList[num] == null) {
			GpioController gpio = GpioFactory.getInstance();
			outputList[num] = gpio.provisionDigitalOutputPin(getPinByNum(num), "PIN"+num, state);
		}
		return outputList[num];
	}

	/**
	 * provisionGpio
	 */
	@Override
	public void provisionGpio(Pin pin, String name, PinState state) {
		GpioController gpio = GpioFactory.getInstance();
		gpio.provisionDigitalOutputPin(pin, name, state);
	}
	

}
