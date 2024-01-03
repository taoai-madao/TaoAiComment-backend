# TaoAiComment-backend

## nginx 启动与关闭

```nginx
# nginx 所在目录下
start nginx        # 启动
nginx -s stop      # 强制关闭
nginx -s quit      # 安全关闭
nginx -s reload    # 重新加载 nginx 配置文件
nginx -s reopen    #打开日志文件

# 使用命令创建/logs/nginx.pid文件，命令如下所示：
nginx -c conf/nginx.conf
```

# 需求设计与技术分析

## 1，基于Session实现用户登录，用户信息共享



# 项目关注重点 - 应该能够独立描述

### 1.  使用前后端分离技术，前后端交互采用**HTTP协议**，**RestFul**风格接口，**Json**格式数据设计

### 2.  使用**SpringBoot**整合**MyBatisPlus**完成项目的基本业务逻辑代码编写

### 3.  使用**SpringSession**代替传统**Session**实现用户登录，用户信息共享

### 4.  使用**SpringCache**整合**Redis**实现热门数据缓存，查询速度毫秒级，并开启缓存淘汰策略，合理的采用**LRU**，**LFU**策略进行应对内存不足问题

### 5.  使用**布隆过滤器**解决**缓存穿透**，使用逻辑过期解决**缓存击穿**，使用**随机TTL**解决**缓存雪崩**

### 6.  使用**Redisson分布式锁**解决集群部署下超卖以及一人一单问题

### 7.  使用**Redis**进行秒杀资格判断、**RabbitMQ**消息队列进行**异步秒杀下单**，大大提高了吞吐量

### 8.  使用**Redis**计数、**自定义注解**、**AOP**来控制单位时间内对某接口的访问量，防止盗刷接口

### 9.  使用**Redis Set**数据结构实现好友关注、共同关注、Timeline类型的Feed流模式的关注推送

### 10. 使用**Redis Zset**数据结构实现博客的一人一赞功能，并且点赞排行榜可按时间排序

### 11. 使用**Redis Geospatial**数据结构实现附近商户查询功能

### 12. 使用**Redis BitMap**数据结构实现用户签到功能
