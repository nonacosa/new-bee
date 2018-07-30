<template>
    <div id="bee-header">
        <div class="is-underline ">
    <div class="container">
      <nav class="navbar ">
        <div class="navbar-brand">
          <a class="navbar-item" @click="handleMenuCommand('/')">
            <img src="http://op0c7euw0.bkt.clouddn.com/newbee_header.png" alt="Bulma: a modern CSS framework based on Flexbox" width="92" height="28">
          </a>
          <div class="login-before" style="padding-top: 5px;">
            <a class="navbar-item is-hidden-desktop" href="https://github.com/pkwenda/my-bbs" target="_blank">
              <span class="icon" style="color: #333;">
                <i class="fa fa-lg fa-github is-size-2"></i>
              </span>
            </a>
          </div>
          <div class="navbar-item is-hidden-desktop ">
             <div class="field has-addons"  ><div class="control" ><input   type="input" class="input" name="email" placeholder="搜索一下" required="required" style="height: 36.4px;"><input   type="hidden" name="redirect" id="name" value="/fr/#thanks"></div><div class="control"  ><input  type="submit" class="button is-warning" value="GO"></div></div>
          </div>

          <div class="navbar-burger burger" data-target="navMenuDocumentation">
            <span></span>
            <span></span>
            <span></span>
          </div>
        </div>

        <div id="navMenuDocumentation" class="navbar-menu">
          <div class="navbar-start">
            <div class="navbar-item has-dropdown is-hoverable">
              <a class="navbar-link  is-active">
                发现
              </a>
              <div class="navbar-dropdown ">
                <a class="navbar-item " type="收藏集">
                  收藏集
                </a>
                <a class="navbar-item" type="徽章">
                  徽章
                </a>
                <a class="navbar-item " type="排名">
                  排名
                </a>
                <a class="navbar-item " @click="handleMenuCommand('life')" type="职场生活">
                  职场生活
                </a>
              </div>
            </div>
            <a class="navbar-item " href="https://bulma.io/expo/">
              <!--<span class="bd-emoji">⭐️</span>-->
              专栏
            </a>
            <a class="navbar-item " href="https://bulma.io/expo/">
              <!--<span class="bd-emoji">⭐️</span>-->
              聊天
              <!-- 很多人不知道干什么。。。 -->
            </a>
            <a class="navbar-item " href="https://bulma.io/expo/">
              <!--<span class="bd-emoji">⭐️</span>-->
              面经
            </a>
            <router-link class="navbar-item " to="/book">
              <!--<span class="bd-emoji">❤️</span>-->
              书籍
            </router-link>
          </div>

          <div class="navbar-end">
            <div class="login-before" style="padding-top: 5px;">
              <!-- pc -->
              <a class="navbar-item is-hidden-desktop-only" href="https://github.com/pkwenda/my-bbs" target="_blank">
                <span class="icon" style="color: #333;">
                  <i class="fa fa-lg fa-github is-size-2"></i>
                </span>
              </a>
            </div>

            <div class="navbar-item is-hidden-mobile ">
               <div class="field has-addons"  ><div class="control" ><input   type="input" class="input" name="email" placeholder="搜索一下" required="required" style="height: 36.4px;"><input   type="hidden" name="redirect" id="name" value="/fr/#thanks"></div><div class="control"  ><input  type="submit" class="button is-warning" value="GO"></div></div>
            </div>

            <div class="navbar-item is-hidden-mobile ">
              <!--<span class="icon is-medium">-->
              <i class="iconfont icon-tixing"></i>
              <!--</span>-->
            </div>

              <el-dropdown  v-show="isLogin"   @command="handleMenuCommand">
                <span class="el-dropdown-link">
                  <div class="login-after">
                              <a class="is-hidden-mobile" @click="goUserPage" target="_blank">
                                <img src="https://sfault-avatar.b0.upaiyun.com/281/733/2817335118-59809c85c69f3_big64" class=" header-avatar img-circle "
                                  style="margin-top: 10px">
                              </a>

                            </div>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="/blog/edit">写文章</el-dropdown-item>
                  <el-dropdown-item>分享文章</el-dropdown-item>
                  <el-dropdown-item command="/user" divided>我的主页</el-dropdown-item>
                  <el-dropdown-item v-if="isLogin" command="/setting" >账户设置</el-dropdown-item>
                  <el-dropdown-item >我的收藏</el-dropdown-item>
                  <!-- <el-dropdown-item divided>我的收入</el-dropdown-item>
                  <el-dropdown-item >我的打赏</el-dropdown-item> -->
                  <el-dropdown-item command="exit" divided>退出</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
           
            <div class="login-before">
              <div class="navbar-item">
                <div class="field is-grouped">
                 
                  <p class="control">
                    <a class="button is-warning" @click="goLogin" v-show="!isLogin"  >
                      <strong>登录</strong>
                    </a>

                  </p>

                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
    </div>
  </div>
    </div>
</template>


<script>
import { getToken, removeToken } from "@/utils/auto";
import _ from "lodash";
import { debug } from "util";
export default {
  name: "BeeHeader",
  data() {
    return {
      isLogin: false,
      user: {}
    };
  },
  created() {},
  destroyed() {},
  mounted() {
    this.auto();
  },
  methods: {
    goLogin() {
      this.$router.push("login");
    },
    goUserPage() {
      this.$router.push("user");
    },
    auto() {
      if (!_.isEmpty(getToken())) {
        this.isLogin = true; //应该放到vuex中
        this.user.email = getToken();
        return;
      }
      this.isLogin = false;
    },
    exit() {
      removeToken();
    },
    handleMenuCommand(router) {
      if (router === "exit") {
        this.exit();
        this.auto();
        return;
      }
      this.$router.push(router);
    }
  }
};
</script>
