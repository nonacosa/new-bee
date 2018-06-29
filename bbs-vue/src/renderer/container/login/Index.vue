<template>
   <div class="login-wrapper columns is-gapless">

    <!-- Form section -->
    <div class="column is-7">
        <div class="hero is-fullheight">
            <div class="hero-heading">
                <!-- Logo -->
                <div class="section has-text-centered">
                    <router-link to="/"><img class="top-logo" src="https://s33.postimg.cc/f0r0oglpr/webbee.png" alt="Brand"></router-link>
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
                            
    <form data-request="onSignin">
    <div id="signin-form" class="login-form animated preFadeInLeft fadeInLeft">
        <!-- Input -->
        <div class="field pb-10">
            <div class="control">
                <input id="userSigninLogin" class="input is-large" type="text" name="login" placeholder="Enter your email" required="">
            </div>
        </div>
        <!-- Input -->
        <div class="field pb-20">
            <div class="control">
                <input id="userSigninPassword" class="input is-large" type="password" name="password" placeholder="Enter your password" required="">
            </div>
        </div>
        <!-- Submit -->
        <p class="control login">
            <button type="submit" class="button button-cta primary-btn btn-align-lg btn-outlined is-bold is-fullwidth rounded raised no-lh  will-load">
                登 录
            </button>
        </p>
    </div>
</form>
                            <!-- /Custom login -->
                            
                            <!-- Custom Reset Form -->
                            <div id="partialUserResetForm">
            <!-- Reset Form -->
<form data-request="ninjaReset::onRestorePassword" data-request-update="'ninjaReset::reset': '#partialUserResetForm'">
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
</form>
<!-- /Reset Form -->    </div>                            <!-- /Custom Reset Form -->
                            
                            <!-- Toggles -->
                            <div id="recover" class="section forgot-password animated preFadeInLeft fadeInLeft">
                                <p class="has-text-centered">
                                    <a href="#">忘记密码 ?</a>
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
        <!-- <div class="hero is-fullheight is-warning is-relative">
            <div class="columns has-text-centered">
                <div class="column">
                    <h2 class="title is-2 light-text">
                        From this moment
                    </h2>
                    <h3 class="subtitle is-5 light-text">
                        成为社区的一员,尽情的分享吧...
                    </h3>
                    
                    <div class="mt-30 has-text-centered">
                        <a   class="button button-cta btn-outlined is-bold light-btn rounded">没有账号,现在注册</a>
                    </div>
                </div>
            </div>
            <img class="login-city" src="https://cssninja.io/themes/cssninja/assets/images/bg/temple.svg" alt="">
        </div>   -->
    </div>
    <!-- /Image section -->
</div>
</template>
 
<script>
export default {
  name: "LoginDemo",
  components: {},
  data() {
    return {
      numberValidateForm: {
        age: ""
      }
    };
  },
  created() {
    // this.$http.post("/user/insert").then(res => {
    //   console.log(res);
    // });
    this.$http.get("/user/getUserByName/庄文达").then(res => {
      console.log(res);
    });
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>
 
