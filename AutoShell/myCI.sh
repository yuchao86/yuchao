#!/bin/bash
#jdk1.8
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home
export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
#tomcat service
echo "======START====[$(date +'%F %H:%M:%S')]======="
ProjectHome=/Users/yuchao/Documents/workspace/openapi
TomcatHome=/Users/yuchao/Downloads/Platform/apache-tomcat-8.0.29

TomcatID=$(ps -ef |grep java|grep tomcat | awk ' { print $2 } ')  
echo "tomcat的pid为$TomcatID"  
echo "[info]开始监控tomcat...[$(date +'%F %H:%M:%S')]"  
if [[ $TomcatID ]]  
# 这里判断TOMCAT进程是否存在  
   then  
    #cp war
    ProjectOpenapi=$ProjectHome/target/openapi.war
    TomcatOpenapi=$TomcatHome/webapps/openapi.war
    if [ -f "$ProjectOpenapi" ];then
        MD5Project=`md5 $ProjectOpenapi|awk '{print $4}'`
    fi
    MD5Tomcat=`md5 $TomcatOpenapi|awk '{print $4}'`
    echo  "ProjectMD5 is $MD5Project [TomcatMD5 is $MD5Tomcat "
    if [ "$MD5Project" != "$MD5Tomcat" ];then
        if [ "$MD5Project" != "" ];then
        cp -rf $ProjectHome/target/openapi.war $TomcatHome/webapps/
        echo "cp -rf  $ProjectHome/target/openapi.war $TomcatHome/webapps/";
        fi
    fi
else  
    echo "tomcat没有启动 restarting..."  
    #restart tomcat
    $TomcatHome/bin/startup.sh
fi 
echo "======END====[$(date +'%F %H:%M:%S')]======="

exit
