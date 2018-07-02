# new-bee

## 开发者如何启动项目
- `bbs-java` spring-boot 配置 `application.properties` 修改`mysql配置`   启动 `NewBeeApplication.java`
- `bbs-vue` `npm run install `  `npm run dev` 
-  打开浏览器输入`localhost`

- 开发过程中端口不冲突尽量不要修改 `application.properties` 中 `server.port` 因为开发过程中前端以 `node` 作为`proxy` 中间件 ，若要修改请同时修改`vue-bbs/config/index.js/tarServ` 与 `server.ip` 相同

  
 
## 我们想做什么样的BBS
- 富强、民主、文明、和谐、自由、平等、公正...
- 支持使用 `GitHub`授权 进行评论
- 支持区块链打赏
- 等级排名制度
- 支持个人专栏、提供优质的内容
- 高度自由、可以自由自在的吐槽
- 任何人都可以把`idea` `PR` 到`new-bbe`

## bbs目前功能以及以后一些技术想法
  - 登录登出(暂未加密)
  - 发布博客
  - 阅读博客
  - 评论博客 

  - 将增加 消息功能 ： `protobuf` `MQ` 作为消息推送中间件
  - 修改 `gitalk` 源码增加一些功能
  - 以前写的cdn链接本地化，`webpack`打包
  - 尽量解决单页面SEO问题或不解决
  - 一键部署脚本
  - 将增加邮件服务
  - 若博客量很大将增加`elasticSearch`处理部分搜索功能
  - `electron`简单发布一个非缓存`pc app` 
  - auth2.0 微信 github qq 登录
  只是暂时来看，可能中间件太多对于开源并不合适，以后部署维护困难大，先实现基本功能观测下

 



## 部署项目
  项目完成会提供部署脚本
 

![Vue](http://op0c7euw0.bkt.clouddn.com/newbee_login.png)

![Vue](http://op0c7euw0.bkt.clouddn.com/newbee_me.png)

![Vue](http://op0c7euw0.bkt.clouddn.com/newbee_index.png)

![Vue](http://op0c7euw0.bkt.clouddn.com/newbee_editBlog.png)

![Vue](http://op0c7euw0.bkt.clouddn.com/newbee_blog.png)

![Vue](http://op0c7euw0.bkt.clouddn.com/newbee_comment.gif)

