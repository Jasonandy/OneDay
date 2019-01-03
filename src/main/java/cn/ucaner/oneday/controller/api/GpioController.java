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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.oneday.common.vo.RespBody;
import cn.ucaner.oneday.config.listener.GpioListener;
import cn.ucaner.oneday.service.PinService;

/**
* @Package：cn.ucaner.oneday.controller.api   
* @ClassName：GpioController   
* @Description：   <p> GpioController </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:05:44   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@RestController
@RequestMapping(value = "/gpio/v1")
public class GpioController {
	
	private static final Logger logger = LoggerFactory.getLogger(GpioController.class);
	
	@Autowired
	private PinService pinService;
	
	@RequestMapping("/test")
    public RespBody gpioTest() throws InterruptedException {
		RespBody respBody = new RespBody();
		int num = 1;
		Pin pinByNum = pinService.getPinByNum(num);
		String raspiData = JSON.toJSONString(pinByNum);
		if (raspiData!=null) {
			respBody.addOK(JSON.toJSONString(raspiData));
		}else {
			respBody.addFail("调用错误");
		}
		
		for (int i = 0; i < 10; i++) {
			if (i%2 == 0) {
				pinService.provisionGpio(RaspiPin.GPIO_05, "LED", PinState.HIGH);
				logger.info("LED亮起来!");
				Thread.sleep(1000);
//				gpio.shutdown();
//				gpio.unProvisionPin(pin);
			}else {
				//RaspiPin.GPIO_00
				pinService.provisionGpio(RaspiPin.GPIO_05, "LED", PinState.LOW);
				logger.info("LED关掉!");
				Thread.sleep(1000);
			}
		}
		return respBody;
    }
	
	/**
	 * @Description: gpioDemo  gpio demo演示
	 * @return
	 * @throws InterruptedException RespBody
	 * @Autor: Jason
	 */
	@RequestMapping("/demo")
    public RespBody gpioDemo() throws InterruptedException {
		RespBody respBody = new RespBody();
		int num = 1;
		Pin pinByNum = pinService.getPinByNum(num);
		String raspiData = JSON.toJSONString(pinByNum);
		if (raspiData!=null) {
			respBody.addOK(JSON.toJSONString(raspiData));
		}else {
			respBody.addFail("调用错误");
		}
		return respBody;
    }
	
	
	/**
	 * @Description: gpioGood 
	 * @return  RespBody
	 * @throws InterruptedException 
	 * @Autor: Jason
	 */
	@RequestMapping("/good")
    public void gpioGood() throws InterruptedException {
		final com.pi4j.io.gpio.GpioController gpio = GpioFactory.getInstance();
		final GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
		pin.setShutdownOptions(true, PinState.LOW);
		int sleep_time = 10;
	    int sleep_time2 = 7;
	    while(true) {
          // lighting....
          for (int i=0; i<=100; i++) {
              pin.setPwm(i);           
              Thread.sleep(sleep_time);
              System.out.println("第"+i+"次");
          }
          // darking...
          for (int i=100; i>0; i--) {
              pin.setPwm(i);     
              Thread.sleep(sleep_time2);
              System.out.println("第"+i+"次");
          }
          Thread.sleep(1000); // break 1 second
      }
    }
	
	
	/**
	 * @Description: gpioLed
	 * @throws InterruptedException 
	 * @Autor: Jason
	 */
	@RequestMapping("/led")
    public void gpioLed() throws InterruptedException {
		final com.pi4j.io.gpio.GpioController gpio = GpioFactory.getInstance();
	    /**
		 * 定义编号为0的引脚为数字输出引脚,初始化为低电平
		 */
	    GpioPinDigitalOutput ledBlink = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "01" ,PinState.LOW);
	    int i = 100;
	    while(i <= 150){
	    	ledBlink.high();
	    	logger.info("LED亮起来!");
	        Thread.sleep(500);
	        ledBlink.low();
	        logger.info("LED被灭掉!");
	        Thread.sleep(500);
	        i++;
	    }
	    GpioListener.startUp();
    }
	
	
	/**
	 * @Description: 启动监听器
	 * @Autor: Jason
	 */
	@RequestMapping("/listen")
    public void gpioStartUp(){
	    GpioListener.startUp();
    }
	
	

}
