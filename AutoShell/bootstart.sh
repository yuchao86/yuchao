#!/bin/bash
# zookeeper is a service 
nohup /Users/yuchao/Zookeeper/server1/zookeeper-3.4.6/bin/zkServer.sh start >/dev/null 2>zookeeper1.out &
nohup /Users/yuchao/Zookeeper/server2/zookeeper-3.4.6/bin/zkServer.sh start >/dev/null 2>zookeeper2.out &
nohup /Users/yuchao/Zookeeper/server3/zookeeper-3.4.6/bin/zkServer.sh start >/dev/null 2>zookeeper3.out &

#redis service
nohup redis-server /usr/local/etc/redis.conf >/dev/null 2> redis.log &

#mysql service
#nohup mysql.server start >/dev/null 2> mysql.log &

exit
