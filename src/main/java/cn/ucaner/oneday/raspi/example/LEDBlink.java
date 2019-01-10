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
package cn.ucaner.oneday.raspi.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.oneday.config.listener.ApplicationContextListener;

/**
* @Package：cn.ucaner.oneday.example   
* @ClassName：LEDBlink   
* @Description：   <p> LEDBlink </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:06:20   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
public class LEDBlink {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class);

	
	/**
	 * 获取全局GPIO 引脚控制器对象
	 */
    public static final GpioController gpio = GpioFactory.getInstance();

    
    public static void main(String[] args) throws InterruptedException {
    	
		/**
		 * 定义编号为0的引脚为数字输出引脚,初始化为低电平
		 */
	    GpioPinDigitalOutput ledBlink = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "01" ,PinState.LOW);
	    
	    while(true){
	    	ledBlink.high();
	    	logger.info("LED亮起来!");
	        Thread.sleep(500);
	        ledBlink.low();
	        logger.info("LED被灭掉!");
	        Thread.sleep(500);
	        
	    }
	}
}
