<template>
    <div id="bee-header">
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
    </div>
</template>


<script>
export default {
  name: "BeeHeader",
  data() {
    return {};
  },
  created() {
    debugger;
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
  },
  destroyed() {},
  methods: {}
};
</script>
