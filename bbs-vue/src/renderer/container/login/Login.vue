<template>
    <div  >
        <!--<div class="container">-->
  <div class="is-underline ">
    <div class="container">
      <nav class="navbar ">
        <div class="navbar-brand">
          <a class="navbar-item" href="index.html">
            <img src="https://s33.postimg.cc/f0r0oglpr/webbee.png" alt="Bulma: a modern CSS framework based on Flexbox" width="92" height="28">
          </a>
          <div class="login-before">
            <a class="navbar-item is-hidden-desktop" href="https://github.com/pkwenda/my-bbs" target="_blank">
              <span class="icon" style="color: #333;">
                <i class="fa fa-lg fa-github is-size-2"></i>
              </span>
            </a>
          </div>
          <div class="navbar-item is-hidden-desktop ">
            <div class="control  has-icons-right" style="width: 150px;">
              <input class="input is-link" type="text" placeholder="搜索" value="">

              <span class="icon is-small is-right">
                <i class="fa fa-search"></i>
              </span>
            </div>
          </div>

          <div class="login-after">
            <a class=" is-hidden-desktop" href="user.html" target="_blank">
              <img src="https://sfault-avatar.b0.upaiyun.com/281/733/2817335118-59809c85c69f3_big64" class=" header-avatar img-circle "
                style="margin-top: 10px">
            </a>

          </div>



          <div class="navbar-burger burger" data-target="navMenuDocumentation">
            <span></span>
            <span></span>
            <span></span>
          </div>
        </div>

        <div id="navMenuDocumentation" class="navbar-menu">
          <div class="navbar-start">
            <div class="navbar-item has-dropdown is-hoverable">
              <a class="navbar-link  is-active">
                发现
              </a>
              <div class="navbar-dropdown ">
                <a class="navbar-item " type="收藏集">
                  收藏集
                </a>
                <a class="navbar-item" type="徽章">
                  徽章
                </a>
                <a class="navbar-item " type="排名">
                  排名
                </a>
                <a class="navbar-item " type="开源库">
                  开源库
                </a>
                <a class="navbar-item " href="life.html" type="职场生活">
                  职场生活
                </a>
              </div>
            </div>
            <a class="navbar-item " href="https://bulma.io/expo/">
              <!--<span class="bd-emoji">⭐️</span>-->
              专栏
            </a>
            <a class="navbar-item " href="https://bulma.io/expo/">
              <!--<span class="bd-emoji">⭐️</span>-->
              灵感
              <!-- 很多人不知道干什么。。。 -->
            </a>
            <a class="navbar-item " href="https://bulma.io/expo/">
              <!--<span class="bd-emoji">⭐️</span>-->
              插件
            </a>
            <a class="navbar-item " href="book.html">
              <!--<span class="bd-emoji">❤️</span>-->
              书籍
            </a>
          </div>

          <div class="navbar-end">
            <div class="login-before">
              <!-- pc -->
              <a class="navbar-item is-hidden-desktop-only" href="https://github.com/pkwenda/my-bbs" target="_blank">
                <span class="icon" style="color: #333;">
                  <i class="fa fa-lg fa-github is-size-2"></i>
                </span>
              </a>
            </div>

            <div class="navbar-item is-hidden-mobile ">
              <div class="control  has-icons-right">
                <input class="input is-link" type="text" placeholder="搜索" value="">

                <span class="icon is-small is-right">
                  <i class="fa fa-search"></i>
                </span>
              </div>
            </div>

            <div class="navbar-item is-hidden-mobile ">
              <!--<span class="icon is-medium">-->
              <i class="iconfont icon-tixing"></i>
              <!--</span>-->
            </div>

            <div class="navbar-item has-dropdown is-hoverable">
              <div class="login-after">
                <a class="is-hidden-mobile" href="user.html" target="_blank">
                  <img src="https://sfault-avatar.b0.upaiyun.com/281/733/2817335118-59809c85c69f3_big64" class=" header-avatar img-circle "
                    style="margin-top: 10px">
                </a>

              </div>
              <div class="navbar-dropdown ">

                <a class="navbar-item " type="">
                  我的博客
                </a>
                <a class="navbar-item " type="">
                  写文章
                </a>
                <a class="navbar-item " type="">
                  分享文章
                </a>
                <hr class="navbar-divider">
                <a class="navbar-item " type="">
                  我的主页
                </a>
                <a class="navbar-item " type="">
                  我的收藏
                </a>
                <hr class="navbar-divider">
                <a class="navbar-item " type="">
                  我的收入
                </a>
                <a class="navbar-item " type="">
                  我的打赏
                </a>
              </div>
            </div>


            <div class="login-before">
              <div class="navbar-item">
                <div class="field is-grouped">
                  <p class="control is-centered is-link " style="margin-top:5px">
                    <a class="has-text-link  is-primary modal-action" data-target="modal-ter">登录</a>

                  </p>
                  <p class="control">
                    <a class="bd-tw-button button is-link" data-social-network="Twitter" data-social-action="tweet" data-social-target="https://bulma.io"
                      target="_blank" href="https://twitter.com/intent/tweet?text=Bulma: a modern CSS framework based on Flexbox&amp;hashtags=bulmaio&amp;url=https://bulma.io&amp;via=jgthms">
                      <!--<span class="icon">-->
                      <!--<i class="fa fa-twitter"></i>-->
                      <!--</span>-->
                      <span>
                        免费注册
                      </span>
                    </a>

                  </p>

                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
    </div>
  </div>
  <section class="hero   bd-rainbow  ">
    <div class="hero-body">
      <div class="container">
        <div class="columns is-vcentered">
          <div class="column">
            <p class="title">
              开发者成长的开源社区
            </p>

            <br>
            <small class="subtitle  content h6">
              - 世界因你我而
              <strong>New Bee</strong>
            </small>
          </div>
          <div class="column is-narrow">
            <!-- 广告位 -->
            <!-- <div id="carboncontainer" >  
              <div id="carbon" class="box">


                <div id="carbonads">
                  <span>
                    <span class="carbon-wrap">
                      <a href="//srv.carbonads.net/ads/click/x/GTND42QEF6YI6KQ7F6Y4YKQMCTAIT237CVBDVZ3JCWYDE5QUCTBDTK7KC6BIT5QJCVYDTK3EHJNCLSIZ?segment=placement:bulmaio;"
                        class="carbon-img" target="_blank" rel="noopener">
                        <img src="//assets.servedby-buysellads.com/p/manage/asset/id/58581" alt="" border="0" height="100" width="130" style="max-width: 130px;">
                      </a>
                      <a href="//srv.carbonads.net/ads/click/x/GTND42QEF6YI6KQ7F6Y4YKQMCTAIT237CVBDVZ3JCWYDE5QUCTBDTK7KC6BIT5QJCVYDTK3EHJNCLSIZ?segment=placement:bulmaio;"
                        class="carbon-text" target="_blank" rel="noopener">Linux Cloud Hosting - 1GB of RAM for $5/mo. Get a server running in seconds.</a>
                    </span>
                    <a href="http://carbonads.net/?utm_source=bulmaio&amp;utm_medium=ad_via_link&amp;utm_campaign=in_unit&amp;utm_term=carbon"
                      class="carbon-poweredby" target="_blank">ads via Carbon</a>
                  </span>
                </div>
              </div>
            </div> -->

          </div>
        </div>
      </div>
    </div>

    <div class="hero-foot">
      <div class="container">
        <nav class="tabs is-boxed">
          <ul>
            <li class="is-active" type="java">
              <a>java</a>
            </li>
            <li type="python">
              <a>python</a>
            </li>
            <li type="node">
              <a>node</a>
            </li>
            <li type="go">
              <a>go</a>
            </li>
            <li type="javascript">
              <a>javascript</a>
            </li>
            <li type="sql">
              <a>sql</a>
            </li>

          </ul>
        </nav>
      </div>
    </div>

  </section>

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

      <article class="column is-4">
        <a class="bd-article-image bd-rainbow" href="blog.html">
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
/**
 * Created by Venda-GM on 2017/10/28.
 */

import { mapMutations } from "vuex";

$(document).ready(function() {
  //自己实现tabs

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
        //todo:xhr请求...
        console.log($(this).attr("type"));
        //todo:应该减少dom移出操作
        $("#index-main").hide();
        newBee("#index-type").animation(2000, function() {
          $("#index-main").show();
        });
      }
    });

  function getAll(selector) {
    return Array.prototype.slice.call(document.querySelectorAll(selector), 0);
  }

  var $burgers = getAll(".burger");

  if ($burgers.length > 0) {
    $burgers.forEach(function($el) {
      $el.addEventListener("click", function() {
        var target = $el.dataset.target;
        var $target = document.getElementById(target);
        $el.classList.toggle("is-active");
        $target.classList.toggle("is-active");
      });
    });
  }
});

export default {
  name: "LoginDemo",
  components: {},
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
    ...mapMutations({
      setMode: "SET_MODE"
    })
  }
};
</script>
 
