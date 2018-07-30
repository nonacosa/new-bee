<template>
    <div>
       <BeeHeader></BeeHeader>
       <div class="container">
          <div class="columns is-multiline" >
             <div class="column is-3 ">1</div>
             <div class="column is-9 ">
                 <div>
                   <button @click="toggleShow">设置头像</button>
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
                  <img :src="`https://sfault-avatar.b0.upaiyun.com/281/733/2817335118-59809c85c69f3_huge256`">
                 </div>
                 <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="100px" class="demo-dynamic">
                    <el-form-item prop="email" label="邮箱"
                      :rules="[
                        { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                        { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
                      ]"
                    >
                      <el-input class="inputClass" v-model="dynamicValidateForm.email"></el-input>
                      
                    </el-form-item>
                      
                    <el-form-item prop="address" label="地址">
                      <el-input class="inputClass" v-model="dynamicValidateForm.address"></el-input>
                    </el-form-item>
                      
                    <el-form-item prop="nickName" label="昵称" :rules="[{ required: true, message: '请输入昵称', trigger: 'blur' },]">
                      <el-input class="inputClass" v-model="dynamicValidateForm.nickName"></el-input>
                    </el-form-item>
                      
                    <el-form-item prop="school" label="学校">
                      <el-input class="inputClass" v-model="dynamicValidateForm.school"></el-input>
                    </el-form-item>
                      
                    <el-form-item prop="companyName" label="公司">
                      <el-input class="inputClass" v-model="dynamicValidateForm.companyName"></el-input>
                    </el-form-item>
                      
                      <el-form-item prop="link" label="链接">
                      <el-input class="inputClass" v-model="dynamicValidateForm.link"></el-input>
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
import { getToken, removeToken } from "@/utils/auto";
import myUpload from "vue-image-crop-upload";
import BeeHeader from "@/components/common/BeeHeader";
export default {
  name: "Setting",
  components: { myUpload, BeeHeader },
  data() {
    return {
      show: false,
      params: {
        token: "123456798",
        name: "avatar"
      },
      headers: {
        smail: "*_~"
      },
      imgDataUrl: "", // the datebase64 url of created image
      userAvatarPath: "",
      dynamicValidateForm: {
        email: ""
      }
    };
  },
  mounted() {},
  destroyed() {},
  methods: {
    //放在这里只是为了前期方便大家观看API 后续挪到 axios 拦截 或 vuex 全局管理器中，
    getUserInfo() {
      this.$http.get("/user/getUserInfo/").then(res => {
        if (res.data.code === 200) {
          this.userInfo = res.data.data;
        }
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
        this.userAvatarPath = jsonData.data;
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
 
<style scoped>
body {
  background-color: #f7f7f7;
}
.inputClass {
  width: 60%;
}
</style>
