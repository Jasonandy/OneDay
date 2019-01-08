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
package cn.ucaner.oneday.jfoenix.util;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


/**
* @Package：cn.ucaner.oneday.jfoenix.util   
* @ClassName：NotificationUtils   
* @Description：   <p> NotificationUtils </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:13:42   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class NotificationUtils {
	
    private static final String WARN_IMAGE_PATH = NotificationUtils.class.getResource("/jfx/image/notification-pane-warning.png").toExternalForm();

    private NotificationUtils() {
    }

    public static void notifyError(final String message, final Object owner) {
        final ImageView WARN_IMAGE = new ImageView(WARN_IMAGE_PATH);
        Notifications.create()
            .title("信息")
            .darkStyle()
            .owner(owner)
            .hideAfter(Duration.seconds(2))
            .position(Pos.CENTER)
            .graphic(WARN_IMAGE)
            .text(message)
            .show();
    }

    public static void notifySuccess(final String message, final Object owner) {
        Notifications.create()
            .title("信息")
            .darkStyle()
            .owner(owner)
            .hideAfter(Duration.seconds(2))
            .position(Pos.CENTER)
            .text(message)
            .showInformation();
    }
}
