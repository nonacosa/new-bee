rm -rf ../bbs-java/target/
mvn package -f ../bbs-java
cd ../bbs-vue
npm run buildProd
cd ../bbs-docker
docker-compose stop
docker rm nginx mysql newbee
docker-compose up -d