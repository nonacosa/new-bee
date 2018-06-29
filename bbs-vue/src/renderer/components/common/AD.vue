<template>
    <div id="AD">
            <!-- 广告位 -->
            <div id="carboncontainer" >  
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
            </div>
    </div>
</template>


<script>
export default {
  name: "Section",
  data() {
    return {};
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
