/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved. - https://github.com/Jasonandy</p>
 *  <p> Created on 2019年1月9日 下午2:53:41</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.oneday.mqtt.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**     
* @Package：cn.ucaner.oneday.mqtt.vo   
* @ClassName：PushPayload   
* @Description：   <p> PushPayload </p>
* @Author： - Jason    
* @CreatTime：2019年1月9日 下午2:53:41   
* @Modify By：   
* @ModifyTime：  2019年1月9日
* @Modify marker：   
* @version    V1.0
*/
public class PushPayload {

	/**
	 * 推送类型
	 */
    private String type;
    
    /**
     * 推送对象
     */
    private String mobile;
    
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
    
    /**
     * 数量
     */
    private Integer badge = 1;
    
    /**
     * 铃声
     */
    private String sound = "default";

    /**
    * PushPayload. 
    * @param type  
    * @param mobile
    * @param title
    * @param content
    * @param badge
    * @param sound
     */
    public PushPayload(String type, String mobile, String title, String content, Integer badge , String sound){
        this.type = type;
        this.mobile = mobile;
        this.title = title;
        this.content = content;
        this.badge = badge;
        this.sound = sound;
    }

    /**
    * @Package：cn.ucaner.oneday.mqtt.vo   
    * @ClassName：Builder   
    * @Description：   <p> Builder 构建mqtt载体</p>
    * @Author： - Jason    
    * @CreatTime：2019年1月10日 上午8:34:13   
    * @Modify By：   
    * @ModifyTime：  2019年1月10日
    * @Modify marker：   
    * @version    V1.0
     */
    public static class Builder{
        //推送类型
        private String type;
        //推送对象
        private String mobile;
        //标题
        private String title;
        //内容
        private String content;
        //数量
        private Integer badge = 1;
        //铃声
        private String sound = "default";

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setBadge(Integer badge) {
            this.badge = badge;
            return this;
        }

        public Builder setSound(String sound) {
            this.sound = sound;
            return this;
        }

        public PushPayload bulid(){
           return new PushPayload(type,mobile,title,content,badge,sound);
        }
    }

    /**
     * @Description: getPushPayloadBuider
     * @return Builder
     * @Autor: @Jason - jasonandy@hotmail.com
     */
    public static Builder getPushPayloadBuider(){
        return new Builder();
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }


	/**  
	* @return type  
	*/
	public String getType() {
		return type;
	}


	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setType(String type) {
		this.type = type;
	}


	/**  
	* @return mobile  
	*/
	public String getMobile() {
		return mobile;
	}


	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	/**  
	* @return title  
	*/
	public String getTitle() {
		return title;
	}


	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setTitle(String title) {
		this.title = title;
	}


	/**  
	* @return content  
	*/
	public String getContent() {
		return content;
	}


	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setContent(String content) {
		this.content = content;
	}


	/**  
	* @return badge  
	*/
	public Integer getBadge() {
		return badge;
	}


	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setBadge(Integer badge) {
		this.badge = badge;
	}


	/**  
	* @return sound  
	*/
	public String getSound() {
		return sound;
	}


	/**  
	* @param paramtheparamthe{bare_field_name} to set  
	*/
	public void setSound(String sound) {
		this.sound = sound;
	}
    
}
