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
package cn.ucaner.oneday.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**     
* @Package：cn.ucaner.oneday.common.utils   
* @ClassName：SpringContextUtil   
* @Description：   <p> 容器助手  -- 拿取对应的bean </p>
* @Author： - Jason    
* @CreatTime：2019年1月7日 上午11:51:45   
* @Modify By：   
* @ModifyTime：  2019年1月7日
* @Modify marker：   
* @version    V1.0
*/
@Component
@Scope //singleton[默认] //prototype
public class SpringContextUtil implements ApplicationContextAware{
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);
	
	/**
	 * appContext容器对象 - ApplicationContextAware.applicationContext  相当于包装模式
	 */
	private static ApplicationContext applicationContext;
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringContextUtil.applicationContext == null) {
			SpringContextUtil.applicationContext = applicationContext;
        }
		logger.debug("---SpringContextUtil.applicationContext:{}---",applicationContext.getApplicationName());
	}
	
	/**
	 * @Description: 获取applicationContext
	 * @return ApplicationContext
	 * @Autor: @Jason - jasonandy@hotmail.com
	 */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @Description: 通过name获取 Bean.
     * @param name
     * @return Object
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * @Description: 通过class获取Bean.
     * @param clazz   T.clazz
     * @return T      Bean<T>
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * @Description: 通过name,以及Clazz返回指定的Bean
     * @param name    BeanName
     * @param clazz   BeanClazzName
     * @return T      BeanClazzType
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
    
    /**
    * @Description: 判断以给定名字注册的bean定义是一个singleton还是一个prototype 
    * 				<br/>如果与给定名字相应的bean定义没有被找到
    * 				<br/>将会抛出一个异常(NoSuchBeanDefinitionException).
    * @param name 
    * @return boolean
    * @Autor: @Jason - jasonandy@hotmail.com
    * @throws NoSuchBeanDefinitionException
    */
   public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
       return applicationContext.isSingleton(name);
   }

}
