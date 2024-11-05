# GLados自动签到脚本

## 大纲	

时间2024.11.5

基于java语言，使用**okHttp3**对glados进行自动签到

加入了**log4j**作为日志，暂时无其他特殊功能

使用**Timer**作为定时器，每24小时签到一次

代码内容：

* CheckinTask
  * 处理okhttp3，主要签到逻辑在此
  * Config内部类，用于读取配置
* Main
  * 负责启动
* TimerCheck
  * 继承TimerTask，封装

配置文件仅包含3个字段

* URL，基本不变
* COOKIE，登陆了glados的本地缓存,请填写自己的COOKIE
* BODY，每次签到发送的内容，不确定会不会变

log4j.properties为日志配置文件，不再赘述
## COOKIE获取

1. 打开浏览器（这里以EDGE为例）
2. 登陆自己的glados
3. 到签到页面
4. 使用F12打开开发者
5. 选择网络
6. 点击签到
7. 选择开发者界面的checkin请求
8. 标头->请求标头->Cookie即为所需要的内容

## k8s部署

**Dockerfile**已写好，基础包为国内的一个镜像网站，也可以选择自己的jdk镜像版本

**glados.yaml**用于k8s部署时使用，挂载了checkin.log到容器外部，地址为/root/log/check.log