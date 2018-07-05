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
<footer class="footer footer-light-medium">
    <div class="container">
        <div class="columns">
            <!-- Column -->
            <div class="column is-4">
                <div class="mb-20">
                    <img class="small-footer-logo" src="https://cssninja.io/themes/cssninja/assets/images/logo/cssninja-grayscale.svg" alt="">
                    <div class="footer-description pt-10">
                        Css Ninja is a web design studio. We build handcrafted and polished templates that will give some hype to your brand. Let's start designing !
                    </div>
                </div>
                <div>
                    <span class="moto">Shipped with loads of <i class="fa fa-heart color-red"></i> .</span>
                    <div class="social-links mt-20">
                        <a href="https://fb.me/cssninjaStudio" target="_blank">
                            <span class="icon"><i class="fa fa-facebook"></i></span>
                        </a>
                        <a href="https://twitter.com/cssninjaStudio" target="_blank">
                            <span class="icon"><i class="fa fa-twitter"></i></span>
                        </a>
                        <!--a href="#">
                            <span class="icon"><i class="fa fa-dribbble"></i></span>
                        </a-->
                        <a href="https://github.com/cssninjaStudio" target="_blank">
                            <span class="icon"><i class="fa fa-github"></i></span>
                        </a>
                    </div>
                </div>
            </div>
            <!-- Column -->
            <div class="column is-6 is-offset-2">
                <div class="columns">
                    <!-- Column -->
                    <div class="column">
                        <ul class="footer-column">
                            <li class="column-header">
                                Links
                            </li>
                            <li class="column-item"><a href="https://cssninja.io">Home</a></li>
                            <li class="column-item"><a href="https://cssninja.io/themes">Templates</a></li>
                            <li class="column-item"><a href="https://cssninja.io/help/ressources/faq">FAQ</a></li>
                        </ul>
                    </div>
                    <!-- Column -->
                    <div class="column">
                        <ul class="footer-column">
                            <li class="column-header">
                                Ressources
                            </li>
                            <li class="column-item"><a href="https://cssninja.io/help">Help center</a></li>
                            <li class="column-item"><a href="https://cssninja.io/blog">Blog</a></li>
                            <li class="column-item"><a href="https://cssninja.io/help/rules">Rules</a></li>
                        </ul>
                    </div>
                    <!-- Column -->
                    <div class="column">
                        <ul class="footer-column">
                            <li class="column-header">
                                Terms
                            </li>
                            <li class="column-item"><a href="https://cssninja.io/help/terms/licenses/personal">Personal</a></li>
                            <li class="column-item"><a href="https://cssninja.io/help/terms/licenses/developer">Developer</a></li>
                            <li class="column-item"><a href="https://cssninja.io/help/terms/service">Terms of Service</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
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

 
