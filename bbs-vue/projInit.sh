#!/bin/bash

# 全局安装rimraf
echo ">>>> npm install rimraf -g <<<<"
##
sudo npm install rimraf -g



# 清除缓存并执行依赖安装
echo ">>>> npm run install:clean <<<<"
#
sudo npm run install:clean
