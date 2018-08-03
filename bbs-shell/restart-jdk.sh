#!/bin/bash


pid_list=`ps -ef | grep newBee | grep -v "grep" | awk '{print $2}'`
if [ -z "$pid_list" ]
then
    echo "no newBee pid alive!"
else
    echo "kill newBee pid $pid_list ..."
    kill -9 $pid_list
    echo "stop newBee success."
fi
echo "start newBee ..."

nohup java -jar /bbs/newBee-0.0.1.jar >> /mnt/logs/newBee.log & tail -f /mnt/logs/newBee.log