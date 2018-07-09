// import { app, BrowserWindow } from 'electron'
// import { autoUpdater } from "electron-updater"
// require('electron-debug')({ showDevTools: true })
// /**
//  * Set `__static` path to static files in production
//  * https://simulatedgreg.gitbooks.io/electron-vue/content/en/using-static-assets.html
//  */
// if (process.env.NODE_ENV !== 'development') {
//   global.__static = require('path').join(__dirname, '/static').replace(/\\/g, '\\\\')
// }

// let mainWindow
// const winURL = process.env.NODE_ENV === 'development' ?
//   ' ' :
//   ' '

// function createWindow() {
//   /**
//    * Initial window options
//    */
//   mainWindow = new BrowserWindow({
//     height: 563,
//     useContentSize: true,
//     webPreferences: { webSecurity: false },
//     width: 1000
//   })
//   if (process.env.NODE_ENV === 'development') {
//     mainWindow.webContents.openDevTools()
//   }
//   mainWindow.maximize();
//   //electron 应该使用 pc 的 userAgent
//   mainWindow.loadURL(winURL, { userAgent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36' })

//   mainWindow.on('closed', () => {
//     mainWindow = null
//   })
// }
// app.commandLine.appendSwitch("--disable-http-cache")
// app.on('ready', createWindow)

// app.on('window-all-closed', () => {
//   if (process.platform !== 'darwin') {
//     app.quit()
//   }
// })

// app.on('activate', () => {
//   if (mainWindow === null) {
//     createWindow()
//   }
// })

// function updateHandle() {
//   let message = {
//     error: '检查更新出错',
//     checking: '正在检查更新……',
//     updateAva: '检测到新版本，正在下载……',
//     updateNotAva: '现在使用的就是最新版本，不用更新',
//   };
//   const os = require('os');

//   autoUpdater.setFeedURL('http://192.168.0.81/vuever');
//   autoUpdater.on('error', function (error) {
//     sendUpdateMessage(message.error)
//   });
//   autoUpdater.on('checking-for-update', function () {
//     sendUpdateMessage(message.checking)
//   });
//   autoUpdater.on('update-available', function (info) {
//     sendUpdateMessage(message.updateAva)
//   });
//   autoUpdater.on('update-not-available', function (info) {
//     sendUpdateMessage(message.updateNotAva)
//   });

//   // 更新下载进度事件
//   autoUpdater.on('download-progress', function (progressObj) {
//     mainWindow.webContents.send('downloadProgress', progressObj)
//   })
//   autoUpdater.on('update-downloaded', function (event, releaseNotes, releaseName, releaseDate, updateUrl, quitAndUpdate) {

//     ipcMain.on('isUpdateNow', (e, arg) => {
//       console.log(arguments);
//       console.log("开始更新");
//       //some code here to handle event
//       autoUpdater.quitAndInstall();
//     });

//     mainWindow.webContents.send('isUpdateNow')
//   });

//   ipcMain.on("checkForUpdate", () => {
//     //执行自动更新检查
//     autoUpdater.checkForUpdates();
//   })
// }
// // updateHandle()
// // 通过main进程发送事件给renderer进程，提示更新信息
// function sendUpdateMessage(text) {
//   mainWindow.webContents.send('message', text)
// }