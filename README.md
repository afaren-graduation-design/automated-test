# thoughtworks-academy-recruiting-system-automated-test

## Environment
###  JDK
###  gradle
###  nginx
###  Docker
###  WebDriver
下载并将 WebDriver 放置在系统可执行路径 PATH 下  
1. [ChromeDriver](http://chromedriver.storage.googleapis.com/index.html)  
2. [FireFoxDriver](https://github.com/mozilla/geckodriver/releases)  
3. [PhantomJSDriver](http://phantomjs.org/download.html)  

## Initialize 
1. 启动 **nginx**
2. 启动 **Docker Container ( mysql, mongo, paper-api )**
3. 启动 web-api (test 环境)


## Run Test

```

./gradlew test

```

> 注意： 每次运行测试之前都需要刷新数据库（Mysql & Mongo）

也可以在第1步启动 nginx 之后直接使用 `execTest.sh` 执行测试

```
# 初始化环境
./execTest.sh init

# 运行测试
./execTest.sh run
```


参考： [Concordion Office site](http://concordion.org/) 

