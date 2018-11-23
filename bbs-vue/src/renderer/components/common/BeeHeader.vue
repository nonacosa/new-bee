<template>

    <div id="bee-header"   element-loading-text="正在努力请求github..." element-loading-background="rgba(0, 0, 0, 0.8)">
        <!-- 遮罩 -->
        <div  :class="  loading ? `modal is-active` : `modal` " style="background-color: #ffffff36">
                <img src="https://i.loli.net/2018/11/23/5bf801c26d02d.gif" style="width: 300px" alt="">
        </div>

        <div class="is-underline ">
    <div class="container">
      <nav class="navbar ">
        <div class="navbar-brand">
          <a class="navbar-item" @click="handleMenuCommand('/')">
            <img src="https://i.loli.net/2018/11/23/5bf8016eb0ea0.png" alt="Bulma: a modern CSS framework based on Flexbox" width="92" height="28">
          </a>
          <div class="login-before is-hidden-mobile" style="padding-top: 5px;">
            <a class="navbar-item is-hidden-desktop" href="https://github.com/pkwenda/my-bbs" target="_blank">
              <span class="icon" style="color: #333;">
                <i class="fa fa-lg fa-github is-size-2"></i>
              </span>
            </a>
          </div>
          <div class="navbar-item is-hidden-desktop ">
             <div class="field has-addons"  ><div class="control" ><input   type="input" class="input" name="email" placeholder="搜索一下" required="required" style="height: 36.4px;width:130px"><input   type="hidden" name="redirect" id="name" value="/fr/#thanks"></div><div class="control"  ><input  type="submit" class="button is-warning" value="GO"></div></div>
          </div>
          <div v-transfer-dom>
            <popup v-model="popupShow" position="right" style="background-color: #fff;">
              <div style="width:200px;">
                <p class="menu-label">
                  <div class="tags has-addons" style="margin-left:30px;"><span class="tag is-warning"><img src="https://img.actd.tw/images/2018/11/17/bee.png" alt="new-bee 社区" width="50" style="float:left" ></span><span class="tag is-danger">测试版</span></div>
                </p>
                <ul class="menu-list"  >
                  <li style="padding: 2px 5px 2px 5px;"><a class="button is-warning" >登录</a></li>
                  <li style="padding: 2px 5px 2px 5px;"><a class="button is-success" >我的主页</a></li>
                  <li style="padding: 2px 5px 2px 5px;"><a class="button is-info" >账户设置</a></li>
                  <li style="padding: 2px 5px 2px 5px;"><a class="button is-danger" >退出</a></li>
                </ul>
              </div>
            </popup>
          </div>
          <div class="navbar-burger burger" data-target="navMenuDocumentation" @click="openPopup">
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
            <div class="qq">开源社区：147255248</div>
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
                              
                                <img :src="userInfo.avatarPath" class=" header-avatar img-circle "
                                  style="margin-top: 10px">
                              </a>

                            </div>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="/editor/post/new">写文章</el-dropdown-item>
                  <el-dropdown-item>分享文章</el-dropdown-item>
                  <el-dropdown-item command="/user" divided>我的主页</el-dropdown-item>
                  <el-dropdown-item v-if="isLogin" command="/setting">账户设置</el-dropdown-item>
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
import { TransferDom, Popup } from "vux";
import oAutoApi from "@/api/oAuth";
import userApi from "@/api/user";
import { getQueryString, github2newBee, EP } from "@/utils";
import {
  getToken,
  removeToken,
  getUserName,
  setToken,
  setInfo
} from "@/utils/auto";
import _ from "lodash";
import { debug } from "util";
export default {
  name: "BeeHeader",
  components: {
    Popup
  },
  data() {
    return {
      popupShow: false,
      isLogin: false,
      user: {},
      loading: false,
      userInfo: {}
    };
  },
  created() {},
  destroyed() {},
  mounted() {
    // oautoApi.getUser("ac07d320e8ca4f30eb92", response => {
    //   debugger;
    // });
    this.auth();
    this.auto();
  },
  methods: {
    auth() {
      let code = getQueryString("code");
      //github返回code码
      if (!_.isEmpty(code)) {
        console.log("test production");
        this.loading = true;
        oAutoApi.getUser(code, response => {
          let user = github2newBee(response);
          userApi.saveUser(user, response => {
            let loginJson = {
              userName: response.data.userName,
              githubNodeId: response.data.githubNodeId
            };
            this.login(loginJson);
          });
        });
      }
    },
    getUserInfo(userName) {
      userApi.getUserInfoByUserName(userName, response => {
        this.userInfo = this.$store.state.user.userInfo = response.data;
      });
    },
    goLogin() {
      this.$router.push("/login");
    },
    goUserPage() {
      this.$router.push(`/user/${getUserName()}`);
    },
    auto() {
      if (!_.isEmpty(getToken())) {
        this.isLogin = true; //应该放到vuex中
        this.user.email = getToken();
        this.userInfo = this.$store.state.user.userInfo;
        if (this.$store.state.user.userInfo == null)
          this.getUserInfo(getUserName());
        return;
      }
      this.isLogin = false;
    },
    login(loginJson) {
      let loginJsonCopy = { ...loginJson };
      let token = {
        token: EP(loginJson)
      };
      userApi.login(token, response => {
        loginJsonCopy.id = response.data.id;
        setToken(EP(loginJsonCopy));
        setInfo(JSON.stringify({ userName: response.data.userName }));
        window.location.href = "/";
        // this.$router.push("/");
      });
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
      if (router === "/user" || router === "/setting")
        router += `/${getUserName()}`;
      this.$router.push(router);
    },
    openPopup() {
      this.popupShow = true;
    }
  }
};
</script>
 