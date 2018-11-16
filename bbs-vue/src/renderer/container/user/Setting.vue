<template>
    <div>
       <BeeHeader></BeeHeader>
       <div class="container">
          <div class="columns is-multiline" >
             <div class="column is-3 "></div>
             <div class="column is-9 ">
                 <div class="center avatar" > 
                   
                    <my-upload field="file"
                        @crop-success="cropSuccess"
                        @crop-upload-success="cropUploadSuccess"
                        @crop-upload-fail="cropUploadFail"
                        v-model="show"
                    :width="100"
                    :height="100"
                    url="/upload/qiniu"
                    :params="params"
                    :headers="headers"
                    img-format="png"
                    :withCredentials="true"></my-upload>
                  <a><img :src="userInfo.avatarPath" @click="toggleShow" style="width:100px;height:100px"></a>
                 </div>
                 <el-form :model="userInfo" ref="dynamicValidateForm" label-width="100px" class="demo-dynamic">
                    <el-form-item prop="email" label="邮箱"
                      :rules="[
                        { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                        { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
                      ]"
                    >
                      <el-input class="inputClass" v-model="userInfo.email"></el-input>
                      
                    </el-form-item>
                      
                    <el-form-item prop="address" label="地址">
                      <el-input class="inputClass" v-model="userInfo.address"></el-input>
                    </el-form-item>
                      
                    <el-form-item prop="nickName" label="昵称" :rules="[{ required: true, message: '请输入昵称', trigger: 'blur' },]">
                      <el-input class="inputClass" v-model="userInfo.nickName"></el-input>
                    </el-form-item>
                      
                    <el-form-item prop="school" label="学校">
                      <el-input class="inputClass" v-model="userInfo.school"></el-input>
                    </el-form-item>
                      
                    <el-form-item prop="companyName" label="公司">
                      <el-input class="inputClass" v-model="userInfo.company"></el-input>
                    </el-form-item>
                      
                      <el-form-item prop="link" label="链接">
                      <el-input class="inputClass" v-model="userInfo.link"></el-input>
                    </el-form-item>
                      <el-form-item prop="link" label="github地址">
                      <el-input class="inputClass" v-model="userInfo.github"></el-input>
                    </el-form-item>
                      <el-form-item prop="link" label="微博地址">
                      <el-input class="inputClass" v-model="userInfo.weibo"></el-input>
                    </el-form-item>

                      
                    <el-form-item>
                      <el-button type="primary" @click="submitForm('dynamicValidateForm')">提交</el-button>
                      <el-button @click="resetForm('dynamicValidateForm')">重置</el-button>
                    </el-form-item>
                  </el-form>
             </div>
          </div>   
      </div>
         
         

   
    </div>


</template>

<script>
import userApi from "@/api/user";
import { getToken, removeToken } from "@/utils/auto";
import myUpload from "vue-image-crop-upload";
import BeeHeader from "@/components/common/BeeHeader";
export default {
  name: "Setting",
  components: { myUpload, BeeHeader },
  data() {
    return {
      userName: this.$route.params.userName,
      userInfo: {},
      show: false,
      params: {
        token: "123456798",
        name: "avatar"
      },
      headers: {
        smail: "*_~"
      },
      imgDataUrl: "" // the datebase64 url of created image
    };
  },
  mounted() {},
  destroyed() {},
  methods: {
    //放在这里只是为了前期方便大家观看API 后续挪到 axios 拦截 或 vuex 全局管理器中，

    getUserInfo() {
      userApi.getUserInfoByUserName(this.userName, response => {
        this.userInfo = response.data;
      });
    },
    saveUser() {
      userApi.saveUser(this.userInfo, response => {
        this.userInfo = response.data;
      });
    },
    toggleShow() {
      this.show = !this.show;
    },
    /**
     * crop success
     *
     * [param] imgDataUrl
     * [param] field
     */
    cropSuccess(imgDataUrl, field) {
      console.log("-------- crop success --------");
      this.imgDataUrl = imgDataUrl;
    },
    /**
     * upload success
     *
     * [param] jsonData   服务器返回数据，已进行json转码
     * [param] field
     */
    cropUploadSuccess(jsonData, field) {
      console.log("-------- upload success --------");
      if (jsonData.code === 200) {
        console.log("file path : " + jsonData.data);
        this.userInfo.avatarPath =
          `http://op0c7euw0.bkt.clouddn.com/` + jsonData.data;
        this.cropSuccess(jsonData.data);
      } else {
        this.cropUploadFail(status, field);
      }
    },
    /**
     * upload fail
     *
     * [param] status    server api return error status, like 500
     * [param] field
     */
    cropUploadFail(status, field) {
      console.log("-------- upload fail --------");
      // console.log(status);
      // console.log("field: " + field);
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.saveUser();
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
 
<style scoped>
body {
  background-color: #f7f7f7;
}
.inputClass {
  width: 60%;
}
.avatar {
  margin-top: 30px;
  margin-left: 200px;
}
</style>
