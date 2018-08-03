rm /bbs/newbee.zip && rm /bbs/nginx.conf && rm -rf /bbs/newbee/

cp  /home/ubuntu/newbee.zip /bbs && cp  /home/ubuntu/nginx.conf/nginx.conf /bbs

unzip -o /bbs/newbee.zip

#docker cp /bbs/newbee/ nginx:/etc/nginx/html/

#docker cp /bbs/nginx.config nginx:/etc/nginx/nginx.config

docker restart nginx



