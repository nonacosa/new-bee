<template>
    <div class="hero is-fullheight is-warning is-relative">
            <div class="columns has-text-centered">
                <div class="column">
                    <h2 class="title is-2 light-text">
                        From this moment
                    </h2>
                    <h3 class="subtitle is-5 light-text">
                        成为社区的一员,尽情的分享吧...
                    </h3>
                    
                    <div class="mt-30 has-text-centered">
                        <a @click="goRegister"   class="button button-cta btn-outlined is-bold light-btn rounded" >没有账号,现在注册</a>
                    </div>
                </div>
            </div>
            <img class="login-city" src="https://cssninja.io/themes/cssninja/assets/images/bg/temple.svg" alt="">
        </div>  
</template>
 
<script>
export default {
  name: "Login",
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
    // this.$http.get("/user/getUserByName/庄文达").then(res => {
    //   console.log(res);
    // });
  },
  methods: {
    goRegister() {
      this.$router.push("register");
    }
  }
};
</script>
 
