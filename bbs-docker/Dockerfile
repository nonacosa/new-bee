FROM node:8.0.0

MAINTAINER pkwenda(nonacosa@gmail.com)

COPY . /app/

WORKDIR /app

RUN npm install -g cnpm --registry=https://registry.npm.taobao.org && \

npm install && \

npm rebuild node-sass --force 

ENV HOST 0.0.0.0

ENV PORT 3000

EXPORT 3000

CMD["npm","run","dev"]

