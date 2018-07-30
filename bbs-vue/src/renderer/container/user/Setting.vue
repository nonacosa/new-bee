<template>
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
        <img :src="`http://op0c7euw0.bkt.clouddn.com/${imgDataUrl}`">
         

   
    </div>


</template>

<script>
import { getToken, removeToken } from "@/utils/auto";
import myUpload from "vue-image-crop-upload";
export default {
  name: "Setting",
  components: { myUpload },
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
      userAvatarPath: ""
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
    }
  }
};
</script>
 
<style scoped>
body {
  background-color: #f7f7f7;
}
</style>
