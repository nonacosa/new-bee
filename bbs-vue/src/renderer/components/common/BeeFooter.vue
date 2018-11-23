<template>
    <footer class="footer footer-light-medium " style="padding-bottom: 20px;padding-top: 20px;">
    <div class="container">
        <div class="columns">
            <!-- Column -->
            <div class="column is-4">
                <div class="mb-20">
                    <img class="small-footer-logo" src="https://i.loli.net/2018/11/23/5bf8016eb0ea0.png" alt="">
                    <div class="footer-description pt-10">
                        new bee 是一个为开发者提供的专注于技术分享的开源社区,所有源码均可在 github 上找到,希望对广大开发者有所帮助。
                    </div>
                </div>
                <div>
                    <span class="moto">喜欢项目可以点赞支持  <a href="https://github.com/pkwenda/new-bee" target="_blank">
                            <span class="icon"><i class="fa fa-github"></i></span>
                        </a>.</span>
                    <div class="social-links mt-20">
                        <!-- <a href="https://fb.me/cssninjaStudio" target="_blank">
                            <span class="icon"><i class="fa fa-facebook"></i></span>
                        </a>
                        <a href="https://twitter.com/cssninjaStudio" target="_blank">
                            <span class="icon"><i class="fa fa-twitter"></i></span>
                        </a> -->
                        <!--a href="#">
                            <span class="icon"><i class="fa fa-dribbble"></i></span>
                        </a-->
                        
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
                            <li class="column-item"><a href="https://github.com/pkwenda/new-bee">Home</a></li>
                            <li class="column-item"><a href="https://cssninja.io/themes">Blog</a></li>
                            <li class="column-item"><a href="https://github.com/pkwenda/new-bee/wiki">Wiki</a></li>
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
</template>


<script>
import _ from "lodash";
export default {
  name: "BeeFooter",
  data() {
    return {};
  },
  created() {},
  destroyed() {},
  mounted() {
    this.auto();
  },
  methods: {}
};
</script>
