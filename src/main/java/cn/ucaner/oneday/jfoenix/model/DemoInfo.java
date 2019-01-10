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
package cn.ucaner.oneday.jfoenix.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
* @Package：cn.ucaner.oneday.jfoenix.model   
* @ClassName：DemoInfo   
* @Description：   <p> DemoInfo </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:15:36   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class DemoInfo {
	
	/**
	 * SimpleIntegerProperty 
	 */
    private SimpleIntegerProperty type = new SimpleIntegerProperty();
    
    /**
     * SimpleStringProperty
     */
    private SimpleStringProperty name = new SimpleStringProperty();
    
    /**
     * SimpleStringProperty
     */
    private SimpleStringProperty description = new SimpleStringProperty();


    public int getType() {
        return type.get();
    }

    public SimpleIntegerProperty typeProperty() {
        return type;
    }

    public void setType(int type) {
        this.type.set(type);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
