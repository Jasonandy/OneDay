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
package cn.ucaner.oneday.config.jwt.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import cn.ucaner.oneday.config.jwt.properties.JwtPatternUrl;

/**
* @Package：cn.ucaner.oneday.jwt.filter   
* @ClassName：JWTFilter   
* @Description：   <p> JWTFilter 接口鉴权过滤器 </p>
* @Author： - Jason    
* @CreatTime：2019年1月3日 下午4:06:41   
* @Modify By：   
* @ModifyTime：  2019年1月3日
* @Modify marker：   
* @version    V1.0
 */
@Configuration
//@Import(JwtPatternUrl.class)
public class JWTFilter implements  Filter{
	
	//private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);
	
	//@Autowired(required=true)
    //private JwtProperty jwtProperty;

    /**
     * jwt需要做处理的连接 
     */
    @Autowired
    private JwtPatternUrl jwtPatternUrl;// = SpringContextUtil.getBean(JwtPatternUrl.class);
    
//    @Bean
//    public JwtPatternUrl bulidJwtPatternUrl(){
//        JwtPatternUrl jwtPatternUrl = new JwtPatternUrl();
//        return jwtPatternUrl;
//    }
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if("OPTIONS".equals(httpRequest.getMethod())) {
            chain.doFilter(httpRequest, httpResponse);
            return;
        }
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (isInclude(url)) {
            chain.doFilter(httpRequest, httpResponse);
            return;
		}
		
		//System.out.println(jwtProperty.getAuthorFlag());
	}

	@Override
	public void destroy() {
		//System.out.println("destroy");
	}
	
	 /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
    	//logger.info("jwtProperty -: {}",JSON.toJSONString(jwtProperty));
    	//logger.info("jwtPatternUrl -:{}",JSON.toJSONString(jwtPatternUrl));
    	if (jwtPatternUrl!=null) {
    		for (String patternUrl : jwtPatternUrl.getUrlPatterns()) {
                Pattern p = Pattern.compile(patternUrl);
                 Matcher m = p.matcher(url);
                if (m.find()) {
                    return true;
                }
            }
		}else {
			return true;
		}
    	return false;
    }

}
