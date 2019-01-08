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

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
* @Package：cn.ucaner.oneday.jfoenix.control   
* @ClassName：EventBus   
* @Description：   <p> EventBus </p>
* @Author： - Jason    
* @CreatTime：2019年1月8日 下午7:06:22   
* @Modify By：   
* @ModifyTime：  2019年1月8日
* @Modify marker：   
* @version    V1.0
 */
public class EventBus {
	
    private static final EventBus INSTANCE = new EventBus();

    private final PublishSubject<Event> mBusSubject = PublishSubject.create();

    public static EventBus getInstance() {
        return INSTANCE;
    }

    public Disposable register(Consumer<Event> onNext) {
        return mBusSubject.subscribe(onNext);
    }

    public void postSave(Event event) {
        mBusSubject.onNext(event);
    }
}
