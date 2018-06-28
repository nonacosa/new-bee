<template>
    
    <div id="app" >
        <div >
            <BeeHeader></BeeHeader> 
            <router-view/>
        </div>
         
    </div>
</template>

<script>
import BeeHeader from "@/components/common/BeeHeader";
export default {
  name: "App",
  components: { BeeHeader },
  data() {
    return {};
  },
  computed: {},
  watch: {},
  mounted() {},
  methods: {}
};
</script>
 