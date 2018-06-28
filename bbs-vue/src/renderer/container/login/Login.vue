<template>
    <div class="login">
        <div class="login-box">
             
        </div>
    </div>
</template>

<script>
import { mapMutations } from "vuex";
// import { setToken } from 'utils/auth'
import { Tab, TabItem, XButton } from "vux";
// import { MH_UserAuth, Z_IsEmpty20 } from '../../utils/fn'
// import Qs from 'qs'
// import ChatInfo from '../../utils/chatInfo'
// import docCookie from '../../utils/cookies'

let interval;
let ciToken;

export default {
  name: "LoginDemo",
  components: {
    Tab,
    TabItem,
    XButton
  },
  data() {
    return {
      showTab: 0,
      qrImgUrl: "",
      qrImgLoading: false,
      username: "",
      password: ""
    };
  },

  destroyed() {},
  methods: {
    ...mapMutations({
      setMode: "SET_MODE"
    }),
    changeTab(index) {
      this.showTab = index;
    },
    qrRefresh() {
      //                console.log('qrRefresh start')

      this.qrImgLoading = true;

      let url = "/zingbiz/auth/user/loginQR";
      let params = { wid: window.Config.wid };

      this.$http
        .post(url, params, { silent: true })
        .then(res => {
          // 简单校验一下数据 另外切换路由时要关连接
          if (
            !res.data.success ||
            Z_IsEmpty20(res.data.data.servIp) ||
            Z_IsEmpty20(res.data.data.uid)
          ) {
            console.error("loginQR servIp or uid null", res);
            this.qrImgLoading = false;
            return;
          }

          // 设置ci cookie
          //                    document.cookie = 'ci=' + res.data.data.ci + ';max-age=600000000;path=/'
          let r1 = docCookie.removeItem("ci", "/");
          console.log("remove ci cookie - r: ", r1);
          let r2 = docCookie.setItem("ci", res.data.data.ci, 600000000, "/");
          console.log("add ci cookie - r: ", r2, res.data.data.ci);
          ciToken = res.data.data.ci;

          if (PSMU)
            PSMU.serverLog(
              PSMU.logLevelType.DEBUG,
              "add ci cookie",
              ciToken,
              res.data
            );

          let chatInfo = new ChatInfo.ChatInfo();
          chatInfo.talkInfo = {
            servIp: res.data.data.servIp,
            uid: res.data.data.uid
          };
          chatInfo.setDid(res.data.data.sscName);

          // 先断开连接，再重建立
          if (PSMU) PSMU.clean();
          // 服务器端 genLoginQR  把服务器ip发给本地 rMap.put("ipEnd", String.valueOf(ConfInfo.myIPEndNess));  rMap.put("servIp", String.valueOf(ConfInfo.myIP));
          PSMU.initPSM(chatInfo, PSMU.parseLoginMsg);

          this.qrImgUrl = res.data.data.imgPath;
          this.qrImgLoading = false;

          //                    console.log('qrRefresh end')
        })
        .catch(err => {
          //                    console.error(err)
          this.qrImgLoading = false;

          //                    if (PSMU) PSMU.serverLog(PSMU.logLevelType.ERROR, err.message, err)
          if (PSMU) PSMU.error(err.message, err);
        });
    },
    doLogin() {
      console.log("点击登录");
      setToken("token");
      if (Z_IsEmpty20(this.username) || Z_IsEmpty20(this.password)) {
        this.$vux.toast.text("用户名或密码为空", "bottom");
        return;
      }

      let isPhone;
      if (this.username.trim().match(/^1[0-9]{10}$/)) {
        isPhone = true;
      } else {
        isPhone = false;
      }

      MH_UserAuth(
        isPhone ? this.username : "",
        isPhone ? "" : this.username,
        this.password
      )
        .then(() => {
          this.$vux.toast.text("登录成功", "bottom");
          this.$router.push("/");
        })
        .catch(err => {
          this.$vux.toast.text("登录失败，请检查用户名和密码", "bottom");
          if (PSMU) PSMU.error("登录失败: " + err.message, err);
        });
    }
  }
};
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
.login {
  width: 100%;
  height: 100%;
  flex-center(column, center, flex-start);
  text-align: center;

  .login-box {
    width: 450px;
    height: 550px;
    margin: 0 auto;
    padding: 5px;
    background-color: #394557;

    .login-box-inner {
      width: 100%;
      height: 100%;
      background-color: #f2f2f2;

      .ercode-panel, .login-panel {
        width: 100%;
        height: calc(100% - 144px);
      }
    }
  }
}

.ercode-panel {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  flex-center(column, center, flex-start);

  .ercode-inner {
    position: relative;
    width: 233px;
    height: 233px;
    margin: 0 auto 10px auto;
    background-color: #fff;

    img {
      border: 0;
    }

    .ercode-mask {
      position: absolute;
      top: 0;
      right: 0;
      bottom: 0;
      left: 0;
      background-color: rgba(255, 255, 255, 0.8);
    }
  }

  .ercode-info {
    position: absolute;
    bottom: 30px;
    left: 0;
    right: 0;
  }
}

.login-panel {
  .form-item {
    height: 60px;
    padding: 20px 10px;
    line-height: 60px;
    font-size: 0;
    margin-top: 20px;
    margin-bottom: 20px;

    label, input {
      display: inline-block;
      height: 40px;
      line-height: 40px;
    }

    label {
      width: 80px;
      font-size: 22px;
    }

    input {
      width: 340px;
      font-size: 20px;
      padding: 0 5px;
      color: #888888;
      border: #bbbbbb;
      outline: 0;
    }
  }

  .login-btn {
    margin-top: 90px;
    width: 80%;
  }
}

.login-link {
  width: 250px;
  margin: 0 auto;
  flex-center(row, space-between, flex-start);
}
</style>

