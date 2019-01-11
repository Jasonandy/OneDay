<p align=center>
  <a href="https://github.com/Jasonandy/OneDay.git">
    <img src="https://raw.githubusercontent.com/Jasonandy/Note-X/master/Media/gif/logo.gif" width="680" height="120" alt="Raspi-X" >
  </a>
</p>

<p align=center>
    You are what you want to be. -wb
</p>

<p align="center">
	<a href="https://github.com/Jasonandy/OneDay.git"><img src="https://img.shields.io/badge/Build-Passing-green.svg?style=for-the-badge" alt=""></a>
	<a href="https://github.com/Jasonandy/OneDay.git"><img src="https://img.shields.io/badge/Author-Jason-orange.svg?style=for-the-badge" alt=""></a>
	<a href="https://github.com/Jasonandy/OneDay.git"><img src="https://img.shields.io/badge/Version-V1.0.0-blue.svg?style=for-the-badge" alt=""></a>
</p>

[Home Page](https://github.com/Jasonandy/OneDay.git) | [英文说明](https://github.com/Jasonandy/andorid-X/blob/master/Media/docs/README-EN.md) | [相关文档](https://github.com/Jasonandy/andorid-X/blob/master/docs/) | [历史版本](https://github.com/Jasonandy/OneDay.git)

# OneDay
* Project：OneDay
* OfficialWebsite：http://OneDay.ucaner.cn
* Describe： 佛系小吴的 微信小程序之(二) ONE DAY


## 一、OneDay

	OneDay 这个项目是基于wechat小程序 Springboot后台搭建的小程序
		1.旨在通过演示学习wechat小程序的开发，后期为树莓派提供上位机微信小程序 远程控制的目的
		2.后期想结合小程序or Vue来开发app 
			参考: [佛系小吴]https://gitee.com/ucanner/xaiowu


## 二、实施方案

> 技术清单
- [X] Java
- [X] LINUX CENTOS 项目部署


[OneDay](https://github.com/Jasonandy/OneDay.git)


## 三、安装发布

> You are what you want to be.

* 1.小程序源码在主干

* 2.springboot源码在分支

```java

*******************https://github.com/Jasonandy********************
*  ______   .__   __.  _______    _______       ___   ____    ____*
* /  __  \  |  \ |  | |   ____|  |       \     /   \  \   \  /   /*
*|  |  |  | |   \|  | |  |__     |  .--.  |   /  ^  \  \   \/   / *
*|  |  |  | |  . `  | |   __|    |  |  |  |  /  /_\  \  \_    _/  *
*|  `--'  | |  |\   | |  |____   |  '--'  | /  _____  \   |  |    *
* \______/  |__| \__| |_______|  |_______/ /__/     \__\  |__|    *
*                   jasonandy@hotmail.com                         *
*******************************************************************

git clone https://github.com/Jasonandy/OneDay.git -b dev

git pull

mvn clean

mvn install 

nohup java -jar oneday-tuna-1.0-exec.jar &

```

```properties
##树莓派部署异常 javafx异常
missing `server' JVM at `/usr/lib/jvm/java-8-openjdk-armhf/jre/lib/arm/server/libjvm.so'.

sudo apt-get purge openjdk-8-jre-headless
sudo apt-get install openjdk-8-jre-headless
sudo apt-get install openjdk-8-jre
```


## Contact
- **Below is my personal contact information. Welcome to exchange and study.**
<p align="center">
    <img src="https://raw.githubusercontent.com/Jasonandy/Note-X/master/Media/contact/WXQRCode.jpg" width="280" height="280" alt="WX" align="left" />
</p>

- CNblog: https://www.cnblogs.com/jasonandy
- E-Mail: jasonandy@hotmail.com 
- Instagram: xxx
- Facebook: xxx
- Twitter: xxx 
- Skype: xxx
- Line: xxx
- QQ: 603043194

#### License
**开源协议** [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)