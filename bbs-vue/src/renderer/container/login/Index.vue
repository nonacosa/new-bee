<template>
   <div class="login-wrapper columns is-gapless">

    <!-- Form section -->
    <div class="column is-7">
        <div class="hero is-fullheight">
            <div class="hero-heading">
                <!-- Logo -->
                <div class="section has-text-centered">
                    <router-link to="/"><img class="top-logo" src="https://i.loli.net/2018/11/23/5bf8016eb0ea0.png" alt="Brand"></router-link>
                </div>
                <!-- Don't have an account yet -->
                <div class="no-account-link has-text-centered">
                    <!-- <a href="https://cssninja.io/register">Don't have an account ? </a> -->
                </div>
            </div>
            <div class="hero-body">
                <div class="container">
                    <div class="columns">
                        <div class="column"></div>
                        <div class="column is-5">
                            <!-- Custom login -->
                            
    <div id="signin-form" class="login-form animated preFadeInLeft fadeInLeft">
        <!-- Input -->
        <div class="field pb-10">
            <div class="control">
                <input v-model="email" id="userSigninLogin" class="input is-large" type="text" name="login" placeholder="Enter your email" required="">
            </div>
        </div>
        <!-- Input -->
        <div class="field pb-20">
            <div class="control">
                <input v-model="password" id="userSigninPassword" class="input is-large" type="password" name="password" placeholder="Enter your password" required="">
            </div>
        </div>
        <!-- Submit -->
        <p class="control login">
            <button @click="login" type="submit" class="button button-cta primary-btn btn-align-lg btn-outlined is-bold is-fullwidth rounded raised no-lh  will-load">
                登 录
            </button>
            
        </p>
    </div>
                            <!-- /Custom login -->
                            
                            <!-- Custom Reset Form -->
                            <div id="partialUserResetForm">
            <!-- Reset Form -->
    <div id="recover-form" class="login-form animated preFadeInLeft fadeInLeft is-hidden">
        <h2 class="title is-4 has-text-centered">Lost your Password ?</h2>
        <!-- Input -->
        <div class="field pb-20">
            <div class="control">
                <input id="userRestoreEmail" class="input is-large" type="email" name="email" placeholder="Enter your email" required="">
            </div>
        </div>
        <!-- Submit -->
        <p class="control login">
            <button type="submit" class="button button-cta secondary-btn btn-align-lg btn-outlined is-bold is-fullwidth rounded raised no-lh will-load">
                Restore password
            </button>
        </p>
    </div>
<!-- /Reset Form -->    </div>                            <!-- /Custom Reset Form -->
                            
                            <!-- Toggles -->
                            <div id="recover" class="section forgot-password animated preFadeInLeft fadeInLeft">
                                <p class="has-text-centered">
                                    <a href="#">忘记密码 ?</a>
                                    
                                </p>
                                <br>
                                <p>
                                    <el-tooltip class="item" effect="light" content="使用github登录" placement="bottom">
                                        <a href="https://github.com/login/oauth/authorize?client_id=b371e2de74a7b1a56ca4&scope=user:email">
                                            <span class="icon" style="color: #333;">
                                                <i class="fa fa-lg fa-github is-size-2"></i> 
                                            </span>
                                        </a>
                                    </el-tooltip>
                                     
                                </p>
                                
                            </div>

                            <div id="back-to-login" class="section forgot-password animated preFadeInLeft fadeInLeft is-hidden">
                                <p class="has-text-centered">
                                    <a href="#">Back to Sign in</a>
                                </p>
                            </div>
                            <!-- /Toggles -->
                        </div>
                        <div class="column"></div>
                    </div>
                </div>
            </div>
        </div>  
    </div>
    <!-- /Form section -->
    
    
    <!-- Image section (hidden on mobile) -->
    <div class="column login-column is-5 is-hidden-mobile hero-banner">
      <router-view/>
         
    </div>
    <!-- /Image section -->
</div>
</template>
 
<script>
import userApi from "@/api/user";
import { setToken, setInfo } from "@/utils/auto";
import { EP } from "@/utils";
export default {
  name: "LoginIndex",
  components: {},
  data() {
    return {
      user: {
        email: "",
        password: ""
      }
    };
  },
  created() {},
  methods: {
    login() {
      let token = {
        token: EP({
          email: this.email,
          userName: this.email,
          password: this.password
        })
      };
      userApi.login(token, response => {
        setToken(
          EP({
            email: this.email,
            userName: this.email,
            password: this.password,
            id: response.data.id
          })
        );
        setInfo(JSON.stringify({ userName: response.data.userName }));

        this.$router.push("/");
      });
    }
  }
};
</script>
 
