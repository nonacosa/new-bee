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
