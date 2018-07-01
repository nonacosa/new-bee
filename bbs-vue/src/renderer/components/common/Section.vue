<template>
    <div id="section">
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
            <li  v-for="tag in tagList" v-bind:key="tag" :type="tag">
              <a>{{tag}}</a>
            </li>
             

          </ul>
        </nav>
      </div>
    </div>

  </section>
    </div>
</template>


<script>
export default {
  name: "Section",
  props: { tagList: Array },
  data() {
    return {};
  },
  mounted() {
    let self = this;
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
  },
  destroyed() {},
  methods: {}
};
</script>
