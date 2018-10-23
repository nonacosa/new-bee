<template>
    <div class="indexContainer">
        <div class="btnsContainer">
        </div>
        <div class="maskContainer" v-if="dilogStatus">
            <div class="contentContainer">
            <div class="closeBtnContainer" @click="closeMaskFn"></div>
                <textarea class="showAreaContainer" v-model="msgShow" readonly></textarea>
            </div>
        </div>
        <el-header height="40px" style="width:100%;padding: 0px;background-color: white;"> 
          <el-input   v-model="title" placeholder="请输入标题" style="width:80%"> </el-input> 
           <a class="button is-warning" style="margin-top:2px" @click="postBlog">发布文章</a>
           <!-- multiple 多选 注掉 -->
          <el-select
          style="width:10%"
          v-model="tagArr"
          filterable
          allow-create
          default-first-option
          placeholder="请选择文章标签">
          <el-option
            v-for="item in tagOption"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        </el-header>
        <div class="editorContainer">
         
            <markdown 
            :mdValuesP="msg.mdValue"  
            :fullPageStatusP="true" 
            :editStatusP="true" 
            :previewStatusP="true" 
            :navStatusP="true"
            :icoStatusP="true"  
            @childevent="childEventHandler"
            ></markdown>
        </div>
    </div>
</template>

<script>
import markdown from "../../components/MdEditor";
import _ from "lodash";
export default {
  name: "index",
  data() {
    return {
      msgShow: "我要显示的内容",
      dilogStatus: false,
      msg: {
        mdValue: ""
      },
      title: "",
      tag: "",
      blogId: this.$route.params.id,
      blog: {},
      tagOption: [
        {
          value: "java",
          label: "java"
        },
        {
          value: "python",
          label: "python"
        },
        {
          value: "go",
          label: "go"
        },
        {
          value: "javascript",
          label: "javascript"
        },
        {
          value: "node",
          label: "node"
        },
        {
          value: "sql",
          label: "sql"
        }
      ],
      tagArr: []
    };
  },
  components: {
    markdown
  },
  created() {
    if (!_.isEmpty(this.blogId)) {
      this.getBlogById(blog => {
        this.msg.mdValue = blog.content;
        this.title = blog.title;
        // console.log(this.msg);
      });
    }
  },
  methods: {
    childEventHandler: function(res) {
      // res会传回一个data,包含属性mdValue和htmlValue，具体含义请自行翻译
      // ;
      this.msg = res;
    },
    getMdValueFn: function() {
      this.msgShow = this.msg.mdValue;
      console.log("xxxxx");
      console.log(this.msg.mdValue);
      this.dilogStatus = true;
    },
    getHtmlValueFn: function() {
      this.msgShow = this.msg.htmlValue;
      this.dilogStatus = true;
    },
    closeMaskFn: function() {
      this.msgShow = "";
      this.dilogStatus = false;
    },
    getBlogById(fn) {
      this.$http.get("/blog/getBlogById/" + this.blogId).then(res => {
        fn(res.data.data);
      });
    },
    postBlog() {
      let blogJson = {
        createTime: new Date(),
        title: this.title,
        content: this.msg.mdValue
      };
      if (this.tagArr.length >= 1) {
        blogJson.tag = this.tagArr;
      }
      this.$http
        .post("/blog/insert", blogJson, {
          headers: {
            Accept: "application/json;charset=UTF-8"
          }
        })
        .then(res => {
          this.$router.push("/");
        });
    }
  }
};
</script>

<style lang="scss" scoped>
.show {
  position: absolute;
  left: 0;
  top: 0;
}
.indexContainer {
  width: 100%;
  height: 100%;
  background: #ddd;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}
.btnsContainer {
  position: absolute;
  z-index: 10;
  left: 65px;
  top: 5px;
  height: 25px;
  min-width: 300px;
  // background: pink;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  .btn {
    display: inline-block;
    border: 1px solid #ccc;
    margin-right: 10px;
    box-sizing: border-box;
    padding: 0 10px;
    background: #fff;
    font-size: 12px;
    height: 25px;
    line-height: 25px;
    cursor: pointer;
    moz-user-select: -moz-none;
    -moz-user-select: none;
    -o-user-select: none;
    -khtml-user-select: none; /* you could also put this in a class */
    -webkit-user-select: none; /* and add the CSS class here instead */
    -ms-user-select: none;
    user-select: none; /**禁止选中文字*/
    &:active {
      opacity: 0.8;
      background: lightblue;
    }
  }
}
.maskContainer {
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
  height: 100vh;
  width: 100vw;
  background: rgba(0, 0, 0, 0.5);
  // z-index: 100;
  display: flex;
  justify-content: center;
  align-items: center;
  .contentContainer {
    width: 60%;
    height: 60%;
    background: #fefefe;
    padding: 20px;
    box-sizing: border-box;
    position: relative;
    .showAreaContainer {
      height: 100%;
      width: 100%;
      outline: none;
      background: #eee;
      display: block;
      resize: none;
      padding: 10px;
      box-sizing: border-box;
    }
    .closeBtnContainer {
      position: absolute;
      height: 30px;
      width: 30px;
      right: -40px;
      top: -40px;
      border: 1px solid #fff;
      border-radius: 50%;
      &::before {
        content: "";
        position: absolute;
        width: 70%;
        height: 2px;
        display: bblock;
        background: #fff;
        left: 15%;
        top: calc(50% - 1px);
        transform: rotate(45deg);
        -webkit-transform: rotate(45deg);
        -moz-transform: rotate(45deg);
      }
      &::after {
        content: "";
        position: absolute;
        width: 70%;
        height: 2px;
        display: bblock;
        background: #fff;
        left: 15%;
        top: calc(50% - 1px);
        transform: rotate(-45deg);
        -webkit-transform: rotate(-45deg);
        -moz-transform: rotate(-45deg);
      }
    }
  }
}

.editorContainer {
  width: 90%;
  height: 90%;
  border: 1px solid #ddd;
}
</style>
