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
package cn.ucaner.oneday.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ucaner.oneday.config.jwt.filter.JWTFilter;

/**
* @Package：cn.ucaner.oneday.config   
* @ClassName：JwtConfig   
* @Description：   <p> jwt 过滤器配置 </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:04:38   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@Configuration
public class JwtConfig {
	
	/**
	 * @Description: Jwt 过滤器
	 * @return FilterRegistrationBean<JWTFilter>
	 * @Autor: Jason
	 */
    @Bean
    public FilterRegistrationBean<JWTFilter> basicFilterRegistrationBean(){
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<JWTFilter>();
        JWTFilter filter = new JWTFilter();
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}
