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
package cn.ucaner.oneday.config.listener;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
* @Package：cn.ucaner.oneday.listener   
* @ClassName：GpioListener   
* @Description：   <p> GpioListener </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:08:05   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
public class GpioListener  implements GpioPinListenerDigital{
	

	private static final Logger logger = LoggerFactory.getLogger(GpioListener.class);
	

	/**
	 * GpioController 
	 */
	private static final GpioController CONTROLLER = GpioFactory.getInstance();
	
	/**
	 * input 输入
	 */
	private static final GpioPinDigitalInput BUTTON = CONTROLLER.provisionDigitalInputPin(RaspiPin.GPIO_16);
	
	/**
	 * output 输出
	 */
	private static final GpioPinDigitalOutput LED = CONTROLLER.provisionDigitalOutputPin(RaspiPin.GPIO_15);
	private Scanner scanner;
	
	/**
	 * @Description: GpioListener RUN
	 * @Autor: Jason
	 */
	public static void main(String[] args) {
        new GpioListener().run();
    }
	
	
	/**
	 * @Description: 启动 - 监听器
	 * @Autor: Jason
	 */
	public static void startUp() {
		logger.info("startUp启动成功!");
		new GpioListener().run();
	}
	
	
	/**
	 * @Description:run
	 * @Autor: Jason
	 */
	public void run() {
        BUTTON.addListener(this);//时间加入进去
        scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        logger.info("输入的信息为：{}",nextLine);
    }
	
	
	/**
	 * handleGpioPinDigitalStateChangeEvent 
	 */
	@Override
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
		boolean state = event.getState().isHigh();
		//System.out.println("--->pin:" + event.getPin() + "|state:" + state);
		logger.info("--->pin: {} |state: {}",event.getPin(),state);
		if (state) {
			LED.high();
		}else {
			LED.low();
		}
	}
	

}
