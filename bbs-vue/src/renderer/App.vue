<template>
    
    <div id="app" >
        <div >
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
 
 <style >
/* .new-bee-loading {
  background-image: url(https://camo.githubusercontent.com/43f8edbdc49e9da9dbdbe483eeb88c7249472400/687474703a2f2f6f70306337657577302e626b742e636c6f7564646e2e636f6d2f6e65772d6265652d6c6f676f2d736d616c6c2e474946);
  background-color: #000000;
} */
</style>
 
 