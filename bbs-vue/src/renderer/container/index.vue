<template>
    <div  >
        <!--<div class="container">-->
   <BeeHeader></BeeHeader>
   <Section @tagEvent="tagEvent" :tagList="tagList" @buttonEvent="buttonEvent"></Section> 

  


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
import { debug } from "util";
export default {
  name: "LoginDemo",
  components: { BeeHeader, Section },
  data() {
    return {
      tag: "",
      type: "",
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
      this.tag = tag;
    },
    buttonEvent(type) {
      this.type = type;
    },
    goBlog(blog) {
      this.$router.push({ path: "/blog", query: { id: blog.id } });
    },
    getBlogs() {
      let searchBlog = {};
      _.isEmpty(this.tag)
        ? (searchBlog.tag = "all")
        : (searchBlog.tag = this.tag);

      !_.isEmpty(this.type) ? (searchBlog.sort = this.type) : searchBlog;

      this.$http
        .post("/blog/getBlogByTag", searchBlog, {
          headers: {
            Accept: "application/json;charset=UTF-8"
          }
        })
        .then(res => {
          this.blogs = res.data.data.content;
        });
    },
    sampleBackGroundColor() {
      return sampleBackGroundColor();
    }
  },
  watch: {
    tag(tag) {
      this.getBlogs();
    },
    type(type) {
      this.getBlogs();
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

 
