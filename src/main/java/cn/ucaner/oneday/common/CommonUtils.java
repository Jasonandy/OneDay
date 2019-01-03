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
package cn.ucaner.oneday.common;

import com.pi4j.system.SystemInfo;
import com.pi4j.system.SystemInfo.BoardType;

/**
* @Package：cn.ucaner.oneday.common   
* @ClassName：CommonUtils   
* @Description：   <p> CommonUtils</p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午3:58:50   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
public class CommonUtils {
	
	/**
	 * 树莓派板子类型设为2B
	 */
	public static final BoardType boardType = SystemInfo.BoardType.RaspberryPi_2B;
}
