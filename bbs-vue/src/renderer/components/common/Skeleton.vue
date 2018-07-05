<template>
     <article v-show="!blogLoading" class="column is-6"     > 
        <div class="skeleton">
            <div class="skeleton-head"></div>
            <div class="skeleton-body">
                <div class="skeleton-title"></div>
                <div class="skeleton-content"></div>
            </div>
        </div>
      </article>
</template>


<script>
import _ from "lodash";
export default {
  name: "BeeFooter",
  props: {
    blogLoading: {
      type: Boolean,
      default: false
    }
  },
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
<style scoped>
.skeleton {
  padding: 10px;
}

.skeleton .skeleton-head,
.skeleton .skeleton-title,
.skeleton .skeleton-content {
  background: rgb(194, 207, 214);
}

.skeleton-head {
  width: 100px;
  height: 100px;
  float: left;
}

.skeleton-body {
  margin-left: 110px;
}

.skeleton-title {
  width: 500px;
  height: 60px;
  transform-origin: left;
  animation: skeleton-stretch 0.5s linear infinite alternate;
}

.skeleton-content {
  width: 260px;
  height: 30px;
  margin-top: 10px;
  transform-origin: left;
  animation: skeleton-stretch 0.5s -0.3s linear infinite alternate;
}

@keyframes skeleton-stretch {
  from {
    transform: scalex(1);
  }
  to {
    transform: scalex(0.3);
  }
}
</style>
