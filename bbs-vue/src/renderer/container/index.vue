<template>
    <div  >
        <!--<div class="container">-->
   <BeeHeader></BeeHeader>
   <Section @tagEvent="tagEvent" :tagList="tagList"></Section> 

  <div id="modal-ter" class="modal">
    <div class="modal-background"></div>
    <div class="modal-card">
      <header class="modal-card-head">
        <p class="modal-card-title">Modal title</p>
        <button class="delete close-modal" data-target="modal-ter"></button>
      </header>
      <section class="modal-card-body">
        <div class="content">a\na\n</div>
      </section>

    </div>
  </div>


  <div class="container" id="index-type">
    <div class="bd-snippet-preview ">
      <a class="button is-danger is-focused">热门</a>
      <a class="button is-warning is-focused">最新</a>
      <a class="button is-info is-focused">收藏</a>
      <a class="button is-primary is-focused">评论</a>
    </div>
    <hr>
  </div>


  <div class="container" id="index-main">
    <h4 class="title is-4" v-if="blogs.length == 0">竟然没有文章...</h4>
    <div class="columns is-multiline">

      
      <article class="column is-3"  @click="goBlog(blog)" v-for="blog in blogs" v-bind:key="blog"> 
        <a   v-bind:class="'bd-article-image ' + sampleBackGroundColor()" >
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-tag"></i>
          </span>
          <strong class="bd-star-icon" ><i class="fa fa-star"></i> <span style="font-size: 1rem">&nbsp;{{blog.commendCount}}</span></strong>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2017-10-09T00:00:00+00:00">
                {{blog.tag}}
              </time>
              <strong class="bd-article-title">
                {{blog.title}}
              </strong>
            </span>
          </strong>
        </a>
      </article>

       

    </div>
  </div>

    </div>
</template>

<script>
import BeeHeader from "@/components/common/BeeHeader";
import Section from "@/components/common/Section";
import _ from "lodash";
import { sampleBackGroundColor } from "@/utils";
export default {
  name: "LoginDemo",
  components: { BeeHeader, Section },
  data() {
    return {
      blogs: [], //blogs分页缓存
      tagList: ["java", "python", "node", "go", "javascript", "sql"]
    };
  },

  destroyed() {},
  mounted() {
    this.getBlogs();
  },
  methods: {
    tagEvent(tag) {
      this.getBlogs(tag);
    },
    goBlog(blog) {
      this.$router.push({ path: "/blog", query: { id: blog.id } });
    },
    getBlogs(tag) {
      // let searchBlog = {};
      // if (!tag) tag = "all";
      // this.$http.get("/blog/getBlog/" + tag).then(res => {
      //   this.blogs = res.data.data.content;
      // });

      this.$http
        .post(
          "/blog/getBlogByTag",
          { tag: tag, sort: "commendCount" },
          {
            headers: {
              Accept: "application/json;charset=UTF-8"
            }
          }
        )
        .then(res => {
          this.blogs = res.data.data.content;
        });
    },
    sampleBackGroundColor() {
      return sampleBackGroundColor();
    }
  }
};
</script>

<style scoped>
.bd-star-icon {
  font-size: 1.2rem;
  color: #0a0a0a;
  opacity: 0.25;
  bottom: 10px;
  left: 30px;
  position: absolute;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
}
</style>

 
