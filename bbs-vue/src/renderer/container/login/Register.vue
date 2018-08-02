<template>
    <div class="hero is-fullheight is-info" >
            <!-- Header -->
            <div class="hero-heading">
                <div class="section intro-section has-text-centered">
                    <a href="https://cssninja.io"><img class="top-logo" src="https://cssninja.io/themes/cssninja/assets/images/logo/cssninja-grayscale.svg" alt="Brand"></a>
                    <div id="signup-intro" class="intro-text has-text-centered animated preFadeInLeft fadeInLeft">
                        <div class="intro-sub">If you purchased one of our producst, fill the form below to create your account, and wait for approval.</div>
                    </div>
                </div>
            </div>

            <!-- Body -->
            <div class="hero-body">
                <div class="container">
                    <div class="columns">
                        <div class="column is-8 is-offset-2">

                            
     
    <div id="signup-form" class="login-form animated preFadeInLeft fadeInLeft">
    
        <div id="loginTaken" class="info-text pb-10" style="display: none"> // 提示处
            <i class="sl sl-icon-lock pr-5"></i> Sorry, that email address already exists.
        </div>
    
        <div class="field pb-10">
            <div class="control">
                <input v-model="user.userName" id="registerName" class="input is-large" type="text" name="name" placeholder="Enter your full name">
            </div>
        </div>
        <div class="field pb-10">
            <div class="control">
                <input v-model="user.email" id="registerEmail" class="input is-large" type="email" name="email" placeholder="Enter your email" data-request="onCheckEmail" data-request-success="$('#loginTaken').toggle(!!data.isTaken)" data-track-input="" required="">
            </div>
        </div>
        <div class="field pb-30">
            <div class="control">
                <input v-model="user.password" id="registerPassword" class="input is-large" type="password" name="password" placeholder="Choose a password">
            </div>
        </div>
        <p class="control">
            <button @click="Register" class="button button-cta primary-btn btn-align-lg btn-outlined is-bold is-fullwidth rounded raised no-lh will-load">注 册</button>
        </p>
    </div>
 



                        </div>
                    </div>
                </div>
            </div>
        </div>
</template>
 
<script>
import userApi from "@/api/user";
export default {
  name: "Register",
  components: {},
  data() {
    return {
      user: {
        userName: "",
        email: "",
        password: ""
      }
    };
  },
  created() {},
  methods: {
    Register() {
      userApi.register(this.user, response => {
        this.$router.push("index");
      });
    }
  }
};
</script>
 
