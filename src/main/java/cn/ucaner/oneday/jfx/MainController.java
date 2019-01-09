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
package cn.ucaner.oneday.jfx;

import cn.ucaner.oneday.jfx.view.MainStageView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;

/**
* @Package：cn.ucaner.oneday.jfx   
* @ClassName：MainController   
* @Description：   <p> MainController</p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午4:21:04   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
//@SpringBootApplication
public class MainController extends AbstractJavaFxApplicationSupport {

	/**
	 * @Description: The entry point of application. 
	 * @param args the input arguments
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        launchApp(MainController.class, MainStageView.class, args);
    }

    /**
     * Start.
     * @param stage the stage
     * @exception Exception the exception
     */
	@Override
    public void start(Stage stage) throws Exception {
//		try {
//			stage.setTitle("佛系小吴");
//			stage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
		//Scene scene = new Scene("", 600, 500);
		//stage.setTitle("佛系小吴");
		//stage.setScene(scene);
		//stage.show();
        super.start(stage);
    }
}
