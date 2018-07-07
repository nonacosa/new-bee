<template>
    <div>
      
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

  <div  id="index-main" class="container"style="margin-top:20px" ><!----> <div  class="columns is-multiline"> 
    <article  class="column is-2"> </article>
    <article  class="column is-8">
      <!-- <div  class="bd-article-image is-danger" style="height: 180px;">
            <strong  class="bd-article-info" style="border: 1px  black;">
                <span > 
                  <strong  class="bd-article-title" style="color: gray;">
                  30 seconds of java8
                  </strong>
                </span>
            </strong>
      </div> -->
      <ul   st:block="entryList" class="column-entry-list entry-list"><!----><li  class="item"><div   st:block="entry"  class="column-entry with-thumb"><div  class="row user-info-row"><div data-v-311d2efa=""  st:block="userPopover"   class="user-popover-box"><!----><a  href="/user/5823d1a3a22b9d0067fde1f7" target="_blank" rel="" st:name="user" st:state="5823d1a3a22b9d0067fde1f7" class="user-info" data-v-311d2efa=""><span  class="username"><!-- 放人名  头像 --></span></a></div><span  class="date">5月前</span></div><div  class="row thumb-row"><a   href="/post/5a579d63f265da3e4d72a028" target="_blank" rel="" st:name="thumb" class="title"><div  style="thisisbackground"></div></a></div><div  class="row abstract-row"><a  style="font-size: 24px;" href="/post/5a579d63f265da3e4d72a028" target="_blank" rel="" st:name="title" class="title">教你用python撸走《百万英雄》《冲顶大会》奖金。</a><br><a style="font-size: 15px;"  href="/post/5a579d63f265da3e4d72a028" target="_blank" rel="" st:name="abstract" class="abstract with-thumb">最近这类答题app比较火，我的同事wangtonghe为开源社区贡献了他的python代码。以下文章为他的思路，我只做了部分整理发布于掘金社区，分享给大家。 看了《程序员如何玩转《冲顶大会》？》大受启发，不过弱点很多，需要使用付费的OCR接口、再open到百度搜索答案，我们等待加载并且寻找答案的时...</a></div><div  class="row action-row"><ul  class="action-list"><li  st:name="likeBtn" class="action like clickable"><div  class="icon icon-likes iconfont icon-xlcollection"></div><span  class="count">190</span></li><a  href="/post/5a579d63f265da3e4d72a028#comment" target="_blank" rel="" st:name="commentBtn" class="title"><li data-v-1d12082e="" st:name="likeBtn" class="action like clickable"><div data-v-1d12082e="" class="icon icon-likes iconfont icon-xlcollection"></div><span data-v-1d12082e="" style="font-size:15px;color: #babdc2" class="count">190</span></li></a></ul><div  class="entry-action-box"><div  class="read-action view-count">阅读 9229</div><!----><div  st:name="moreBtn" class="read-action more-action"><div  class="icon ion-ios-more"></div><!----></div><!----></div></div></div></li><!----></ul>
      </article>
            <article  class="column is-2"></article>
            </div></div>

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
.item {
  padding: 2.5rem;
  border-bottom: 1px solid hsla(0, 0%, 59%, 0.1);
}
.user-info-row {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
}

.thumb-row {
  position: relative;
  padding-top: 23.4%;
  margin-bottom: 2rem;
}

.abstract-row .abstract {
  width: 100%;
  max-height: 7.800000000000001rem;
  line-height: 1.5;
  letter-spacing: 0.02rem;
  color: #8b8b8b;
  cursor: pointer;
  overflow: hidden;
  font-size: 1.3rem;
}
.action-row {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  margin-top: 1.5rem;
  color: rgba(24, 37, 50, 0.3);
}
.action,
.entry-action-box {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
}

.abstract-row .title:visited {
  color: #909090;
}

.abstract-row .title {
  width: 100%;
  margin-bottom: 0.8rem;
  font-size: 2rem;
  color: #000;
  line-height: 1.3;
  font-weight: 600;
  letter-spacing: 0.04rem;
}

.action-row .action-list .action,
.action-row .action-list {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  position: relative;
}
ul {
  padding: 0;
  margin: 0;
}

user agent stylesheet ul ul,
ol ul {
  list-style-type: circle;
}
.action-row .action-list .action,
.action-row .action-list {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  position: relative;
}

ul {
  padding: 0;
  margin: 0;
}
.action-row .action-list .action.active {
  color: #fff;
  border-color: #83c73a;
  background-color: #83c73a;
}
.action-row .action-list .action {
  cursor: pointer;
  padding: 0 1rem;
  height: 25px;
  line-height: 25px;
  white-space: nowrap;
  border: 1px solid #f1f1f1;
  border-radius: 1px;
  background-color: #fff;
  transition: color, border-color, background-color 0.3s;
}
.action-row .action-list .action,
.action-row .action-list {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  position: relative;
}
li {
  list-style: none;
}
user agent stylesheet li {
  display: list-item;
  text-align: -webkit-match-parent;
}
</style>
