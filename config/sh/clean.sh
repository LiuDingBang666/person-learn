#!/bin/bash

# 一、删除源文件
#rm -rf /root/usr/env/server/app.jar

appname=$1
# 二、获取传入参数
echo "arg_1=$1"

# 三、获取当前执行jar 指定模块名-指定jar文件
pid=`ps -ef | grep $1 | grep 'java -jar' | awk '{printf $2}'`

echo $pid

# 四、如果pid为空，提示用户。否则执行kill
if [ -z $pid ];
	then
		echo "$appname not started"
	else
		kill -9 $pid
		echo "$appname stop..."
fi

# 五、最终提示
check=`ps -ef | grep -w $pid | grep java`
if [ -z $pid ];
  then
    echo "$appname $pid:$check is stop!"
  else
    echo "$appname $pid:$check stop failed!"
fi