#!/bin/bash
#jdk1.8
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home
export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
#tomcat service
echo "======START====[$(date +'%F %H:%M:%S')]======="
ProjectHome=/Users/yuchao/IdeaProjects/openapi
TomcatHome=/Users/yuchao/Downloads/Platform/apache-tomcat-8.0.29

TomcatID=$(ps -ef |grep java|grep tomcat | awk ' { print $2 } ')  
echo "tomcat的pid为$TomcatID"  
Monitor(){
        echo "[info]开始监控tomcat...[$(date +'%F %H:%M:%S')]"  
        if [[ $TomcatID ]]  
		# 这里判断TOMCAT进程是否存在  
           then  
                echo "tomcat启动正常"  
                kill -9 $TomcatID  
                sleep 1
                tempTomcatID=$(ps -ef |grep java|grep tomcat | awk ' { print $2 } ')  
                if [[ $tempTomcatID ]]  
                        then  
                        echo "停止失败"  
                else   
                        echo "成功停止"  
                fi  
        else  
            echo "tomcat没有启动"  
        fi  
}
Monitor

#restart tomcat
$TomcatHome/bin/startup.sh 
echo "======END====[$(date +'%F %H:%M:%S')]======="

exit
