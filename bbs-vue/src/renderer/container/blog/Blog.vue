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
                  <trans data-src="Roses are red" data-dst="玫瑰是红色的">优雅的使用</trans>
                  <br>
                  <trans data-src="Links are blue" data-dst="链接是蓝色的">函数式编程</trans>
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
            <trans data-src="Roses are red – Links are blue" data-dst="玫瑰是红色的–链接是蓝色的" style="background: transparent;">Roses are red – Links are blue</trans>
          </h1>
          <hr>

          <div class="content is-medium">


            <div class="javascript" id="markdown-content">



            </div>






          </div>
        </div>
      </div>
    </div>
  </section>


    </div>
</template>

<script>
import qs from "qs";
export default {
  name: "Blog",
  components: {},
  data() {
    return {
      content: ""
    };
  },
  created() {
    // this.$http
    //   .post(
    //     "/blog/insert",
    //     {
    //       publishTime: new Date(),
    //       content: this.content,
    //       userId: 1
    //     },
    //     {
    //       headers: {
    //         // "Content-Type": "application/x-www-form-urlencoded",
    //         Accept: "application/json;charset=UTF-8"
    //       }
    //     }
    //   )
    //   .then(res => {
    //     console.log(res);
    //   });

    this.$http.get("/blog/getBlogById/1").then(res => {
      this.content = res.data.data.content;
      this.doMarkDown();
    });
  },
  mounted() {
    // document.getElementById("markdown-content").innerHTML = marked(
    //   this.content
    // );
    // $("pre code").each(function(i, block) {
    //   hljs.highlightBlock(block);
    // });
  },
  destroyed() {},
  methods: {
    doMarkDown() {
      document.getElementById("markdown-content").innerHTML = marked(
        this.content
      );

      $("pre code").each(function(i, block) {
        hljs.highlightBlock(block);
      });
    }
  }
};
</script>
 
