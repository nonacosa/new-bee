'use strict'
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path')

var javaAPi = '127.0.0.1:8003'



const host = 'localhost'
const port = 80

module.exports = {
    dev: {
        // Paths
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        assetsPublicConfig: './src/renderer/utils/configDev.js',
        proxyTable: [{
            // https://www.easy-mock.com/mock/5a6840b43d63972d717dc5b4/webapp/hotel/hotelOrders/reserveCheckIn
            context: ['/user', '/blog', '/upload', '/github'],
            target: "http://" + javaAPi,

            cookieDomainRewrite: {
                "localhost": javaAPi
            },
            secure: false
        }, {
            context: ['/newbee'],
            target: "http://" + host + ':' + port,
            changeOrigin: true,
            secure: false,
            pathRewrite: { "/newbee": "" }
        },
        ],
        // headers: {
        // 'Cookie': '2_3004C2_300382_3005A2_300712_300492_300342_300482_300652_300732_300472_3006A2_300332_300522_300622_300632_300782_300572_300332_300622_300472_300562_300472_3004C2_300552_300382_300792_300642_3006D2_300562_300632_300502_300342_300792_300692_300662_300462_300662_300472_300322_300412_300562_300392_300722_300772_300732_3004D2_3004A2_300622_3002B2_300772_300632_300462_300382_300572_300712_3004E2_300362_300762_300742_300782_300412_300492_3004E2_300502_300532_300562_300512_300672_3006B2_3006A2_3006E2_300702_3004F2_300442_3004B2_300532_3000A2_300372_3006D2_300552_300622_300662_3002B2_3005A2_300492_300502_300772_300752_300672_3004E2_300512_300622_300302_3005A2_3004D2_300542_3002F'
        //},

        // Various Dev Server settings
        host: host, // can be overwritten by process.env.HOST
        port: port, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
        autoOpenBrowser: false,
        errorOverlay: true,
        notifyOnErrors: true,
        poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-


        /**
         * Source Maps
         */

        // https://webpack.js.org/configuration/devtool/#development
        devtool: '#cheap-source-map',

        // If you have problems debugging vue-files in devtools,
        // set this to false - it *may* help
        // https://vue-loader.vuejs.org/en/options.html#cachebusting
        cacheBusting: true,

        cssSourceMap: true
    },

    build: {
        // Template for index.html
        index: path.resolve(__dirname, '../dist/index.html'),

        // Paths
        assetsRoot: path.resolve(__dirname, '../dist'),
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        assetsPublicConfig: './src/renderer/utils/configProd.js',

        /**
         * Source Maps
         */

        productionSourceMap: true,
        // https://webpack.js.org/configuration/devtool/#production
        devtool: '#source-map',

        // Gzip off by default as many popular static hosts such as
        // Surge or Netlify already gzip all static assets for you.
        // Before setting to `true`, make sure to:
        // npm install --save-dev compression-webpack-plugin
        productionGzip: true,
        productionGzipExtensions: ['js', 'css'],

        // Run the build command with an extra argument to
        // View the bundle analyzer report after build finishes:
        // `npm run build --report`
        // Set to `true` or `false` to always turn it on or off
        bundleAnalyzerReport: process.env.npm_config_report
    }
}
