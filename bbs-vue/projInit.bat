@echo off

rem ### 全局安装rimraf
echo ;;;; call npm install rimraf -g ;;;;
    call npm install rimraf -g

rem npm安装electron可能会超时的问题
echo ";;;; echo electron_mirror=https://npm.taobao.org/mirrors/electron/ >> %USERPROFILE%\.npmrc ;;;;"
    echo electron_mirror=https://npm.taobao.org/mirrors/electron/ >> %USERPROFILE%\.npmrc

rem 清除缓存并执行依赖安装
echo ;;;; call npm run install:clean ;;;;
    call npm run install:clean

pause
