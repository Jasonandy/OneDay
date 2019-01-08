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
package cn.ucaner.oneday.jfx.view;

import de.felixroske.jfxsupport.SplashScreen;

/**
* @Package：cn.ucaner.oneday.jfx.view   
* @ClassName：CustomSplash   
* @Description：   <p> CustomSplash </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午4:21:20   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class CustomSplash extends SplashScreen {
	
	private static String SPLASH_PATH = "/jfx/splash/splash.png";
    
	/**
     * Use your own splash image instead of the default one
     * @return "/splash/javafx.png"
     */
    @Override
    public String getImagePath() {
    	return SPLASH_PATH;
        //return super.getImagePath();
    }

    @Override
    public boolean visible() {
        return super.visible();
    }
}
