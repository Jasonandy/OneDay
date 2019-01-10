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
package cn.ucaner.oneday.jfoenix.controller;

import java.util.Objects;

import javax.annotation.PostConstruct;

import cn.ucaner.oneday.jfoenix.control.Event;
import cn.ucaner.oneday.jfoenix.control.EventBus;
import cn.ucaner.oneday.jfoenix.control.ExtendedAnimatedFlowContainer;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.ContainerAnimations;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
* @Package：cn.ucaner.oneday.jfoenix.controller   
* @ClassName：MainController   
* @Description：   <p> MainController </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:16:02   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
@ViewController(value = "/jfx/view/main.fxml")
public class MainController {
	
	/**
	 * ViewFlowContext 
	 */
    @FXMLViewFlowContext
    private ViewFlowContext context;
    
    /**
     * BorderPane 
     */
    @FXML
    private BorderPane root;
    
    /**
     * MenuItem 
     */
    @FXML
    private MenuItem home;
    
    /**
     * MenuItem
     */
    @FXML
    private MenuItem demo;
    
    /**
     * MenuItem 
     */
    @FXML
    private MenuItem save;

    /**
     * BooleanProperty
     */
    private BooleanProperty saveDisable = new SimpleBooleanProperty();

    @PostConstruct
    public void init() throws FlowException {
        Objects.requireNonNull(context);
        // create the inner flow and content, set the default controller
        Flow innerFlow = new Flow(HomeController.class);

        final FlowHandler flowHandler = innerFlow.createHandler(context);
        context.register("ContentFlowHandler", flowHandler);
        context.register("ContentFlow", innerFlow);
        final Duration containerAnimationDuration = Duration.millis(320);
        root.setCenter(flowHandler.start(
        		new ExtendedAnimatedFlowContainer(containerAnimationDuration,
        		ContainerAnimations.SWIPE_LEFT)));
        context.register("ContentPane", root.getCenter());

        // bind events on menu
        JavaFxObservable.actionEventsOf(home).subscribe(actionEvent -> {
            if (!(flowHandler.getCurrentView().getViewContext().getController() instanceof HomeController)) {
                flowHandler.handle(home.getId());
                saveDisable.setValue(Boolean.TRUE);
            }
        });
        JavaFxObservable.actionEventsOf(demo).subscribe(actionEvent -> {
            if (!(flowHandler.getCurrentView().getViewContext().getController() instanceof DemoController)) {
                flowHandler.handle(demo.getId());
                saveDisable.setValue(Boolean.FALSE);
            }
        });
        JavaFxObservable.actionEventsOf(save).subscribe(actionEvent -> {
            EventBus.getInstance().postSave(new Event(Event.EventType.SAVE));
        });

        // bind menu to view in flow
        bindMenuToController(home, HomeController.class, innerFlow);
        bindMenuToController(demo, DemoController.class, innerFlow);

        saveDisable.setValue(Boolean.TRUE);
        save.disableProperty().bindBidirectional(saveDisable);
    }

    private void bindMenuToController(MenuItem menu, Class<?> controllerClass, Flow flow) {
        flow.withGlobalLink(menu.getId(), controllerClass);
    }
}
