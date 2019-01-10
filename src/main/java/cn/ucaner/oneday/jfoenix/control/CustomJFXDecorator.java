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
package cn.ucaner.oneday.jfoenix.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
* @Package：cn.ucaner.oneday.jfoenix.control   
* @ClassName：CustomJFXDecorator   
* @Description：   <p> CustomJFXDecorator </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:02:55   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class CustomJFXDecorator extends JFXDecorator {
	
	/**
	* CustomJFXDecorator. 
	* @param stage
	* @param node
	 */
    public CustomJFXDecorator(Stage stage, Node node) {
        this(stage, node, true, true, true);
    }

    /**
    * CustomJFXDecorator. 
    * @param stage
    * @param node
    * @param fullScreen
    * @param max
    * @param min
     */
    public CustomJFXDecorator(Stage stage, Node node, boolean fullScreen, boolean max, boolean min) {
        super(stage, node, fullScreen, max, min);
        // top area is a buttons container and with a class 'jfx-decorator-buttons-container'
        Node btnContainerOpt = this.lookup(".jfx-decorator-buttons-container");
        if (btnContainerOpt != null) {
            // buttons container is a HBox
            final HBox buttonsContainer = (HBox) btnContainerOpt;

            // check and get the index of maximum button
            ObservableList<Node> buttons = buttonsContainer.getChildren();
            int btnMaxIdx = 0;
            if (fullScreen) {
                btnMaxIdx++;
            }
            if (min) {
                btnMaxIdx++;
            }
            if (buttons.size() >= btnMaxIdx) {
                final JFXButton btnMax = (JFXButton) buttons.get(btnMaxIdx);
                // set max button triggered when buttons container is double clicked
                buttonsContainer.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2) {
                        btnMax.fire();
                    }
                });
            }

            // add HBox in the left of buttons container
            HBox leftBox = new HBox();
            leftBox.setAlignment(Pos.CENTER_LEFT);
            leftBox.setPadding(new Insets(0, 0, 0, 10));
            leftBox.setSpacing(10);

            // add icon in the left of HBox
            HBox iconBox = new HBox();
            iconBox.setAlignment(Pos.CENTER_LEFT);
            iconBox.setSpacing(5);

            // bind icon
            stage.getIcons().addListener((ListChangeListener<Image>) c -> {
                while (c.next()) {
                    iconBox.getChildren().clear();
                    ObservableList<? extends Image> icons = c.getList();
                    if (icons != null && !icons.isEmpty()) {
                        ImageView imageView;
                        for (Image icon : icons) {
                            imageView = new ImageView();
                            imageView.setFitWidth(20);
                            imageView.setFitHeight(20);
                            imageView.setImage(icon);
                            iconBox.getChildren().add(imageView);
                        }
                    }
                }
            });

            // bind title
            Label title = new Label();
            title.textProperty().bindBidirectional(stage.titleProperty());
            // set title to white because of the black background
            title.setTextFill(Paint.valueOf("#fdfdfd"));

            leftBox.getChildren().addAll(iconBox, title);

            HBox.setHgrow(leftBox, Priority.ALWAYS);
            buttonsContainer.getChildren().add(0, leftBox);
        }
    }
}
