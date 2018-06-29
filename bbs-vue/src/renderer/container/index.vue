<template>
    <div  >
        <!--<div class="container">-->
   <BeeHeader></BeeHeader>
   <Section></Section> 

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
    <div class="columns is-multiline">

      <article class="column is-4" @click="goBlog()">
        <a class="bd-article-image bd-rainbow" >
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-tag"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2017-10-09T00:00:00+00:00">
                09 Oct 2017
              </time>
              <strong class="bd-article-title">
                优雅的使用
                <br>函数式编程
              </strong>
            </span>
          </strong>
        </a>
      </article>

      <article class="column is-4">
        <a class="bd-article-image is-orange" href="/2017/08/03/list-of-tags/">
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-tag"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2017-08-03T00:00:00+00:00">
                03 Aug 2017
              </time>
              <strong class="bd-article-title">
                带你入门JAVA8
              </strong>
            </span>
          </strong>
        </a>
      </article>

      <article class="column is-4">
        <a class="bd-article-image is-bootstrap" href="/2017/08/01/bulma-bootstrap-comparison/">
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-heart"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2017-08-01T00:00:00+00:00">
                01 Aug 2017
              </time>
              <strong class="bd-article-title">
                JAVA神器的姿势
              </strong>
            </span>
          </strong>
        </a>
      </article>

      <article class="column is-4">
        <a class="bd-article-image is-primary" href="/2017/07/24/access-previous-bulma-versions/">
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-undo"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2017-07-24T00:00:00+00:00">
                24 Jul 2017
              </time>
              <strong class="bd-article-title">
                JAVA实现IM
              </strong>
            </span>
          </strong>
        </a>
      </article>

      <article class="column is-4">
        <a class="bd-article-image is-success" href="/2017/03/10/new-field-element/">
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-square-o"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2017-03-10T00:00:00+00:00">
                10 Mar 2017
              </time>
              <strong class="bd-article-title">
                JAVA AI框架 踩坑
              </strong>
            </span>
          </strong>
        </a>
      </article>

      <article class="column is-4">
        <a class="bd-article-image is-info" href="/2016/04/11/metro-ui-css-grid-with-bulma-tiles/">
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-th-large"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2016-04-11T00:00:00+00:00">
                11 Apr 2016
              </time>
              <strong class="bd-article-title">
                Metro UI
              </strong>
            </span>
          </strong>
        </a>
      </article>

      <article class="column is-4">
        <a class="bd-article-image is-danger" href="/2016/02/09/blog-launched-new-responsive-columns-new-helpers/">
          <span class="bd-article-overlay"></span>
          <span class="bd-article-icon">
            <i class="fa fa-rocket"></i>
          </span>
          <strong class="bd-article-info">
            <span>
              <time class="bd-article-date" datetime="2016-02-09T00:00:00+00:00">
                09 Feb 2016
              </time>
              <strong class="bd-article-title"> 
                Launch!
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
export default {
  name: "LoginDemo",
  components: { BeeHeader, Section },
  data() {
    return {
      showTab: 0,
      qrImgUrl: "",
      qrImgLoading: false,
      username: "",
      password: ""
    };
  },

  destroyed() {},
  methods: {
    goBlog() {
      this.$router.push("blog");
    }
  }
};
</script>
 
