<template>
    <div  >
      <div class="container">
      <div class="notification">
       <el-form :model="numberValidateForm" ref="numberValidateForm" label-width="100px" class="demo-ruleForm">
        <el-form-item
          label="年龄"
          prop="age"
          :rules="[
            { required: true, message: '年龄不能为空'},
            { type: 'number', message: '年龄必须为数字值'}
          ]"
        >
          <el-input type="age" v-model.number="numberValidateForm.age" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('numberValidateForm')">提交</el-button>
          <el-button @click="resetForm('numberValidateForm')">重置</el-button>
        </el-form-item>
      </el-form>
      </div>
    </div>
      

    </div>
</template>
 
<script>
export default {
  name: "LoginDemo",
  components: {},
  data() {
    return {
      numberValidateForm: {
        age: ""
      }
    };
  },
  created() {
    // this.$http.post("/user/insert").then(res => {
    //   console.log(res);
    // });
    this.$http.get("/user/getUserByName/庄文达").then(res => {
      console.log(res);
    });
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>
 
