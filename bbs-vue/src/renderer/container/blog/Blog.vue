<template>
    <div  >
   
  <section class="section">
    <div class="container" id="blog-main">
      <div class="columns">
        <div class="column is-offset-2 is-8">
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
                   {{blog.title}}
                  
                </strong>
              </span>
            </strong>
          </div>
          <p class="subtitle is-6">
            <a class="bd-article-back" href="index.html">
              <trans data-src="Back" data-dst="后退">Back</trans>
            </a>
          </p>
          <h1 class="title is-2">
            <!-- <trans data-src="Roses are red – Links are blue" data-dst="玫瑰是红色的–链接是蓝色的" style="background: transparent;">{{blog.title}}</trans> -->
          </h1>
          <hr>

          <div class="content is-medium">
            <div class="javascript" id="markdown-content">

            </div>

          </div>
          <div id="gitalk-container"></div>
        </div>
      </div>
    </div>
  </section>


    </div>
</template>

<script>
import Gitalk from "gitalk";
import marked from "marked";
import "gitalk/dist/gitalk.css";
import { goBack } from "@/utils";

export default {
  name: "Blog",
  components: {},
  data() {
    return {
      blog: {}
    };
  },
  created() {
    this.getBlogById();
  },
  mounted() {},
  destroyed() {},
  methods: {
    doMarkDown() {
      document.getElementById("markdown-content").innerHTML = marked(
        this.blog.content
      );

      $("pre code").each(function(i, block) {
        hljs.highlightBlock(block);
      });

      var gitalk = new Gitalk({
        clientID: "b371e2de74a7b1a56ca4",
        clientSecret: "be2bbf103764e6b5a436f6830bf2a8630784fcf3",
        repo: "pkwenda.github.io",
        owner: "pkwenda",
        admin: ["pkwenda"],
        id: this.$route.query.id + "", // Ensure uniqueness and length less than 50
        distractionFreeMode: false // Facebook-like distraction free mode
      });

      gitalk.render("gitalk-container");
    },
    getBlogById() {
      this.$http.get("/blog/getBlogById/" + this.$route.query.id).then(res => {
        this.blog = res.data.data;
        this.doMarkDown();
      });
    }
  }
};
</script>
 
