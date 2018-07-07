<template>
    <div>
      <!-- <div class="bg-gray" style="margin-top: 12px;">
  <div class="container " >
    <div class="columns is-multiline">
      <div class="column is-1"></div>
      <div class="column is-10">
        <div class="columns is-multiline">

          <div class="column is-2"></div>

          <div class="column is-8">
            <div class="columns is-multiline" style="padding-top: 30px;padding-bottom: 30px;">
              <div class="column is-4 ">
                <img src="https://sfault-avatar.b0.upaiyun.com/281/733/2817335118-59809c85c69f3_huge256"   class=" header-avatar-big img-circle " alt="头像" >
                <div>
                  &nbsp;
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-github"></i>
                    </span>
                  </a>
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-google"></i>
                    </span>
                  </a>
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-weibo"></i>
                    </span>
                  </a>
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-facebook"></i>
                    </span>
                  </a>

                </div>
              </div>
              <div class="column is-8">
                <strong style="font-size:25px">{{userInfo.userName}}</strong>
                <br>

                <div>
                  <span class="tag is-dark">专栏作者 </span>
                  <span class="tag is-success">活跃成员 </span>
                </div>
                <div><i class="fa fa-map-marker"></i><small  > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京</small></div>
                <div><i class="fa fa-graduation-cap" ></i><small>&nbsp;&nbsp;&nbsp;五道口职业技术学院</small></div>
                <div><i class="fa fa-briefcase" ></i><small>&nbsp;&nbsp;&nbsp;&nbsp;{{userInfo.company}}&nbsp;&nbsp;{{userInfo.signature}}</small></div>
                <div><i class="fa fa-link"></i><small>&nbsp;&nbsp;&nbsp;&nbsp;www.gitrue.com</small></div>
              </div>

            </div>
          </div>
          <div class="column is-2"></div>
        </div>
      </div>
      <div class="column is-1"></div>
    </div>
     <div class="bd-article-image is-single is-link">
            <span class="bd-article-overlay"></span>
            <span class="bd-article-icon">
              <i class="fa fa-tag"></i>
            </span>
            <strong class="bd-article-info">
              <span>
                <time class="bd-article-date" datetime="2017-10-09T00:00:00+00:00">
                  <trans data-src="09 Oct 2017" data-dst="2017年09月" style="background: transparent;">09 Oct 2017</trans>
                </time>
                <strong class="bd-article-title">
                    
                  
                </strong>
              </span>
            </strong>
          </div>
  </div>
</div> -->
<section class="hero  "  style=" background-color:#f7f7f7">
    <div class="hero-body" >
      <div class="container">
         <div class="columns is-multiline" >
              <div class="column is-3 "></div>
              <div class="column is-2">
                <img src="https://sfault-avatar.b0.upaiyun.com/281/733/2817335118-59809c85c69f3_huge256"   class=" header-avatar-big img-circle " alt="头像" >
                <div>
                  &nbsp;
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-github"></i>
                    </span>
                  </a>
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-google"></i>
                    </span>
                  </a>
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-weibo"></i>
                    </span>
                  </a>
                  <a href="https://github.com/pkwenda">
                    <span class="icon" style="color: #333;">
                      <i class="fa fa-lg fa-facebook"></i>
                    </span>
                  </a>

                </div>
              </div>
              <div class="column is-4">
                <strong style="font-size:25px">{{userInfo.userName}}</strong>
                <br>

                <div>
                  <span class="tag is-dark">专栏作者 </span>
                  <span class="tag is-success">活跃成员 </span>
                </div>
                <div><i class="fa fa-map-marker"></i><small  > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京</small></div>
                <div><i class="fa fa-graduation-cap" ></i><small>&nbsp;&nbsp;&nbsp;五道口职业技术学院</small></div>
                <div><i class="fa fa-briefcase" ></i><small>&nbsp;&nbsp;&nbsp;&nbsp;{{userInfo.company}}&nbsp;&nbsp;{{userInfo.signature}}</small></div>
                <div><i class="fa fa-link"></i><small>&nbsp;&nbsp;&nbsp;&nbsp;www.gitrue.com</small></div>
              </div>

            </div>
             <div class="column is-3 "></div>
      </div>
    </div>

    <div class="hero-foot">
      <div class="container">
        <div class="columns is-multiline" >
              <div class="column is-3 "></div>
              <div class="column is-6 ">
                <nav class="tabs is-boxed">
          <ul>
            <li  v-for="tag in ['活动', '专栏', '分享', '收藏', '点赞']" v-bind:key="tag" :type="tag">
              <a>{{tag}}</a>
            </li>
            
          </ul>
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
        </nav>
              </div>
              <div class="column is-3 "></div>
        </div>
        
      </div>
    </div>

  </section>
    </div>
</template>

<script>
import { getToken, removeToken } from "@/utils/auto";
import myUpload from "vue-image-crop-upload";
export default {
  name: "User",
  components: { myUpload },
  data() {
    return {
      userInfo: {},
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
  mounted() {
    $("nav.tabs")
      .find("li")
      .click(function() {
        if (!$(this).hasClass("is-active")) {
          $("nav.tabs")
            .find("li")
            .each(function(k, v) {
              $(v).removeClass("is-active");
            });
          $(this).addClass("is-active");
          self.$emit("tagEvent", $(this).attr("type"));
          //todo:应该减少dom移出操作
          $("#index-main").hide();
          newBee("#index-type").animation(500, function() {
            $("#index-main").show();
          });
        }
      });
    this.getUserInfo();
  },
  destroyed() {},
  methods: {
    //放在这里只是为了前期方便大家观看API 后续挪到 axios 拦截 或 vuex 全局管理器中，
    getUserInfo() {
      this.$http.get("/user/getUserInfo/" + this.$route.query.id).then(res => {
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
