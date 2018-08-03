
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
elif [ -d "/bbs/newbee/" ]
then
    rm /bbs/newbee/
fi

# cp need deploy's  file --> nodeJs build
echo "cp newbee.zip | nginx.conf... !"
cp  /home/ubuntu/newbee.zip /bbs && cp  /home/ubuntu/nginx.conf/nginx.conf /bbs
echo "unzip newbee.zip..."
unzip -o /bbs/newbee.zip

#docker cp /bbs/newbee/ nginx:/etc/nginx/html/

#docker cp /bbs/nginx.config nginx:/etc/nginx/nginx.config

# if you first run this script and behind the create-nginx-docker.sh maybe echo some error ,dont worry
docker restart nginx
echo "script complete !"



