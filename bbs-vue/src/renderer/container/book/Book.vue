<template>
    <div  >
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
      <!--<footer class="modal-card-foot">-->
      <!--<a class="button is-success">Save changes</a>-->
      <!--<a class="button close-modal" data-target="modal-ter">Cancel</a>-->
      <!--</footer>-->
    </div>
  </div>


   


  <div class="container" id="index-main">
    <div class="bd-tws-love">



      <article class="bd-tw" style="padding-left: 50px;border: 0px;">
        <div class="is-centered" style="width:310px;height:420px;">

          <div class="bd-tw-content">
            <div class="is-centered" style="width:300px;height:380px">
              <img src="http://file.ituring.com.cn/ScreenShow/0100c4de6d0965b125db">
            </div>
          </div>

        </div>
      </article>

      <article class="bd-tw" style="padding-left: 50px;border: 0px;">
        <div class="is-centered" style="width:310px;height:420px;">

          <div class="bd-tw-content">
            <div class="is-centered" style="width:300px;height:380px">
              <img src="http://file.ituring.com.cn/ScreenShow/0100bf54fd5c299f5e02">
            </div>
          </div>


        </div>
      </article>

      <article class="bd-tw" style="padding-left: 50px;border: 0px;">
        <div class="is-centered" style="width:310px;height:420px;">

          <div class="bd-tw-content">
            <div class="is-centered" style="width:300px;height:380px">
              <img src="http://file.ituring.com.cn/ScreenShow/010067de1e19ddef9c15">
            </div>
          </div>


        </div>
      </article>
      <article class="bd-tw" style="padding-left: 50px;border: 0px;">
        <div class="is-centered" style="width:310px;height:420px;">

          <div class="bd-tw-content">
            <div class="is-centered" style="width:300px;height:380px">
              <img src="http://file.ituring.com.cn/ScreenShow/1708febcfca2b7d1f8ad">
            </div>
          </div>


        </div>
      </article>


    </div>
  </div>

    </div>
</template>

<script>
import BeeHeader from "@/components/common/BeeHeader";
import Section from "@/components/common/Section";
import { goBack } from "@/utils";
export default {
  name: "Book",
  components: { BeeHeader, Section },
  data() {
    return {
      content: ""
    };
  },
  created() {},
  mounted() {},
  destroyed() {},
  methods: {}
};
</script>
 
