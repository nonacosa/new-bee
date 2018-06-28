#!/bin/bash

# 全局安装rimraf
echo ">>>> npm install rimraf -g <<<<"
##
npm install rimraf -g

# npm安装electron可能会超时的问题
echo ">>>> echo 'electron_mirror=https://npm.taobao.org/mirrors/electron/' >> ~/.npmrc <<<<"
#
echo 'electron_mirror=https://npm.taobao.org/mirrors/electron/' >> ~/.npmrc

# 清除缓存并执行依赖安装
echo ">>>> npm run install:clean <<<<"
#
npm run install:clean
