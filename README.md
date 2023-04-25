# 在线天气查询网站

---

一个基于JavaWeb的天气查询网站，实现了动态切换地区并根据地区自动更新天气，没有自动定位(~~懒得做~~)

## 网站预览

---

![ioCNpy.png](https://i.328888.xyz/2023/04/24/ioCNpy.png)

## 项目の框架 | 工具

---

- vue3
- [阿里图标库 icofont](https://www.iconfont.cn/)
- axios
- element-plus
- canvas(绘制近七天的最高、最低气温走势)
- [和风天气API](https://console.qweather.com/)

## 項目部署

1. 项目部署在docker

2. 拉取tomcat 9.0.74 jdk17 `docker pull tomcat:9.0.74-jdk17-corretto-al2`

3. 创建容器 `docker run -p <9999>:8080 --name <weather_server> -itd <image>`

4. 进入容器 执行 `rm webapps -r` `mv webapps.dist webapps`

5. 将打包好的war包传入容器 `docker cp weather-1.0-SNAPSHOT.war weather_server:/usr/local/tomcat/webapps`

6. 重新启动容器 `docker restart weather_server`

7. 进入网站即可 `IP:9999/weather-1.0-SNAPSHOT/`
