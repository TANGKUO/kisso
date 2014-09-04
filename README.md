﻿sso
===

kisso cookie sso framework


Usage
====================

[kisso dependent libs](https://github.com/tuzip/kisso-libs)

[kisso-test-my](https://github.com/leqwang/kisso/tree/master/kisso/test-my)

[kisso-test-sso](https://github.com/leqwang/kisso/tree/master/kisso/test-sso)

（1）sso 登录状态
![GitHub](https://raw.githubusercontent.com/leqwang/kisso/master/kisso/images/sso.jpg "Kisso,login cookie")

（2）跨域登录

hosts:
--------------------------------------------
127.0.0.1 sso.test.com
127.0.0.1 my.web.com


访问 my.web.com:8090/index.html  如果未登录会重定向至sso域登录页面
![GitHub](https://raw.githubusercontent.com/leqwang/kisso/master/kisso/images/nologin.jpg "Kisso,crossdomain login")

登录成功 my.web.com 如图
![GitHub](https://raw.githubusercontent.com/leqwang/kisso/master/kisso/images/login.jpg "Kisso,crossdomain login")


Supports
====================
1、支持单点登录

2、支持登录Cookie缓存

3、支持防止 XSS攻击, SQL注入，脚本注入

4、支持Base64 / MD5 / AES / RSA 算法

5、支持浏览器客户端校验

6、支持Cookie参数配置及扩展

7、支持跨域登录，模拟登录

Futures
====================
1、实现完整 sso 工程实例


开源赞助我(支付宝): 
====================
![GitHub](https://raw.githubusercontent.com/leqwang/kisso/master/kisso/images/donate.png "开源赞助我(支付宝)")

copyright
====================
Apache License, Version 2.0
