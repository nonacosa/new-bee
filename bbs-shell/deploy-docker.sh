#!/bin/bash

# discription : new bee deploy script
# author      : sis.nonacosa@gmail.com

# del redundant file
echo "del local file ... "
if   [ -f "/bbs/nginx.conf" ]
then
    rm /bbs/nginx.conf
elif [ -f "/bbs/newbee.zip" ]
then
    rm /bbs/newbee.zip
elif [ -f "/bbs/newBee-0.0.1.jar" ]
then
    rm /bbs/newBee-0.0.1.jar
elif [ -d "/bbs/newbee/" ]
then
    rm /bbs/newbee/
fi

# cp need deploy's  file --> nodeJs build
echo "cp newbee.zip | nginx.conf... !"
cp  /home/ubuntu/newbee.zip /bbs && cp  /home/ubuntu/nginx.conf/nginx.conf /bbs && cp /home/ubuntu/newBee-0.0.1.jar /bbs
echo "unzip newbee.zip..."
unzip -o /bbs/newbee.zip

#docker cp /bbs/newbee/ nginx:/etc/nginx/html/

#docker cp /bbs/nginx.config nginx:/etc/nginx/nginx.config

# if you first run this script and behind the create-nginx-docker.sh maybe echo some error ,dont worry
docker restart nginx

# restart java
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

echo "script complete !"




    rm /bbs/newBee-0.0.1.jar
elif [ -d "/bbs/newbee/" ]
then
    rm /bbs/newbee/
fi

# cp need deploy's  file --> nodeJs build
echo "cp newbee.zip | nginx.conf... !"
cp  /home/ubuntu/newbee.zip /bbs && cp  /home/ubuntu/nginx.conf/nginx.conf /bbs && cp /home/ubuntu/newBee-0.0.1.jar
echo "unzip newbee.zip..."
unzip -o /bbs/newbee.zip

#docker cp /bbs/newbee/ nginx:/etc/nginx/html/

#docker cp /bbs/nginx.config nginx:/etc/nginx/nginx.config

# if you first run this script and behind the create-nginx-docker.sh maybe echo some error ,dont worry
docker restart nginx

# restart java 
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

echo "script complete !"



