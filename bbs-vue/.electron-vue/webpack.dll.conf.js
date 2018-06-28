const path = require('path');
const webpack = require('webpack');
const config = require('../config')

const AssetsPlugin = require('assets-webpack-plugin');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
module.exports = {
  entry: {
    vendordll: [
    'vue/dist/vue.esm.js', 'vue-router', 'vuex', 'axios', 'lodash', 'mavon-editor', 
    'jquery', 'better-scroll', 'element-ui', 'element-ui/lib/theme-chalk/index.css',
    'clipboard', 'css-color-function', 'date-fns', 'fastclick', 'js-cookie', 'xss'
  ]
  },
  output: {
    path: path.resolve(__dirname, '../static/dll'),
    filename: '[name].[chunkhash].js',
    library: '[name]_library'
  },
  mode: 'production',
  module: {
    rules: [
      {
        test: /\.js$/,
        loader: 'babel-loader?cacheDirectory',
        exclude: /node_modules/
      },
      {
        test: /\.css$/,
        use: [MiniCssExtractPlugin.loader, 'css-loader']
      },
      {
        test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
        loader: 'url-loader',
        query: {
          limit: 10000,
          name: 'img/[name].[hash:7].[ext]'
        }
      },
      {
        test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
        loader: 'url-loader',
        query: {
          limit: 10000,
          name: 'fonts/[name].[hash:7].[ext]'
        }
      }
    ]
  },
  plugins: [
    new webpack.DllPlugin({
      path: path.resolve(__dirname, '../static/dll/[name]-mainfest.json'),
      name: '[name]_library',
      context: __dirname // 执行的上下文环境，对之后DllReferencePlugin有用
    }),
    new MiniCssExtractPlugin({
      // Options similar to the same options in webpackOptions.output
      // both options are optional
      filename: '[name].css'
    }),
    new AssetsPlugin({
      filename: 'bundle-config.json',
      path: path.resolve(__dirname, '../static/dll'),
    }),
  ]
}