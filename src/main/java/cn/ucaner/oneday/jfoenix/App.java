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
package cn.ucaner.oneday.jfoenix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.oneday.jfoenix.control.CustomJFXDecorator;
import cn.ucaner.oneday.jfoenix.controller.MainController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
* @Package：cn.ucaner.oneday.jfoenix   
* @ClassName：App   
* @Description：   <p> App </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:13:17   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class App extends Application {
	
    private static Logger logger = LoggerFactory.getLogger(App.class);
    
	public static void main(String[] args) {
    	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(App::logError);

        ViewFlowContext flowContext = new ViewFlowContext();
        flowContext.register("Stage", primaryStage);

        // create flow and flow container, flow container controls view decoration and view exchange
        Flow flow = new Flow(MainController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);

        // JFXDecorator will be applied to primaryStage, and decorated on view which is created by flow container
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage, container.getView(),
            false, true, true);

        // init scene with a decorator
        Scene scene = new Scene(decorator, 750, 500);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(App.class.getResource("/jfx/css/main.css").toExternalForm());
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("佛系小吴");
        primaryStage.getIcons().add(new Image("/jfx/image/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void logError(Thread t, Throwable e) {
        if (Platform.isFxApplicationThread()) {
            logger.error("Catch unexpected fx exception", e);
        } else {
            logger.error("An unexpected error occurred in {}", t, e);
        }
    }
}
