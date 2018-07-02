#!/bin/bash

app_path=/opt/
pid_list=`ps -ef | grep newBee | grep -v "grep" | awk '{print $2}'`
if [ -z "$pid_list" ]
  then
    echo "no newBee pid alive!"
else
  echo "kill newBee pid $pid_list ..."
  kill -9 $pid_list
  echo "stop newbnewBeeee success."
fi
echo "start newBee ..."
cd $app_path
nohup java -jar newBee-0.0.1.jar >> /mnt/logs/newbee.log &
tail -f /mnt/logs/newBee.log
