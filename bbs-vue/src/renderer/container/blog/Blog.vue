<template>
    <div  >
   
  <section class="section">
    <div class="container" id="blog-main">
      <div class="columns">
        <div class="column is-offset-2 is-8">
          <div class="bd-article-image is-single is-link">
            <span class="bd-article-overlay"></span>
            <span class="bd-article-icon">
              <i class="fa fa-tag"></i>
            </span>
            <strong class="bd-article-info">
              <span>
                <time class="bd-article-date" datetime="2017-10-09T00:00:00+00:00">
                  <trans data-src="09 Oct 2017" data-dst="2017年09月" style="background: transparent;">09 Oct 2017</trans>
                </time>
                <strong class="bd-article-title">
                  <trans data-src="Roses are red" data-dst="玫瑰是红色的">优雅的使用</trans>
                  <br>
                  <trans data-src="Links are blue" data-dst="链接是蓝色的">函数式编程</trans>
                </strong>
              </span>
            </strong>
          </div>
          <p class="subtitle is-6">
            <a class="bd-article-back" href="index.html">
              <trans data-src="Back" data-dst="后退">Back</trans>
            </a>
          </p>
          <h1 class="title is-2">
            <trans data-src="Roses are red – Links are blue" data-dst="玫瑰是红色的–链接是蓝色的" style="background: transparent;">Roses are red – Links are blue</trans>
          </h1>
          <hr>

          <div class="content is-medium">


            <div class="javascript" id="markdown-content">



            </div>






          </div>
        </div>
      </div>
    </div>
  </section>


    </div>
</template>

<script>
import qs from "qs";
import { goBack } from "@/utils";
export default {
  name: "Blog",
  components: {},
  data() {
    return {
      content: ""
    };
  },
  created() {
    debugger;
    console.log(goBack);
    // this.$http
    //   .post(
    //     "/blog/insert",
    //     {
    //       publishTime: new Date(),
    //       content:
    //         "### 函数是`一等公民`\n\n所谓`一等公民①`顾名思义身份高，`JS`任何只要是值能到达的地方，函数都可以去。\n\n字符串是一等公民，那么函数也可以拥有字符串一样的特质\n\n```\n\n var str=function(){return'123'}var array=['123',function(){return'456'}]\n var concatStr='123'+function(){return'456'}()\n function concatFun(str,fn){\n return str+fn();\n}\n concatFun(123,function(){return'456'})\n return function(){return'123'}\n```\n正向我们上一文使用[call、apply举例](https:\n-可以以`函数`作为参数\n\n- 可以返回`函数`\n\n这正是`underscore`被广泛应用的原因\n\n### 操场报数游戏\n\n体育老师上课打太极前找同学集合点到：\n\n学生总数`10`人，报数顺序自行定义：\n\n于是我们写出了如下代码：\n\n```\n(function(){\n var numberBill=[]for(var number=0;number<10;number++){\n numberBill.push('同学 '+number+' 报数');\n if(number==10)console.log('没有学生了');\n if(number<10)console.log('还剩:'+(10-number-1)+'名学生没有报数');\n}\n})()\n\n```\n\n- 结果：\n\n```\n VM85068:6还剩:9名学生没有报数\n VM85068:6还剩:8名学生没有报数\n VM85068:6还剩:7名学生没有报数\n VM85068:6还剩:6名学生没有报数\n VM85068:6还剩:5名学生没有报数\n VM85068:6还剩:4名学生没有报数\n VM85068:6还剩:3名学生没有报数\n VM85068:6还剩:2名学生没有报数\n VM85068:6还剩:1名学生没有报数\n VM85068:6还剩:0名学生没有报数\n```\n\n这种编程方式很常见，谁都会写，我们一般叫这种编程方式称之为`命令编程`②，这个逻辑完全在你掌握之中，你只要规定计算机在你想要的时候执行一些不同的动作就可以了。\n\n下文中出现的注解`underscore`方法会在文章最后注解讲解,复杂的单独抽离几张讲解。\n\n```\n function signInPositive(number){var count=1;\n return _.chain([]).push('同学 '+count+' 正常报数')\n.tap(function(numberBill){_.each(_.range(number),function(v,k){\n if(count<number)numberBill.push('同学 '+(count++)+' 正常报数')\n console.log('还有'+(number-count)+'名同学没报数');\n})\n}).value()}\n signInPositive(10)\n\n```\n\n虽然我们勉强用函数编程实现了，但是有啥好处呢？没啥好处，最起码这个实现方法没有凸显出函数编程的价值，还不如命令编程容易理解。\n\n---\n\n我记得去年摩托罗拉出了一个模块化手机，他的摄像头，电池，外壳貌似都能拆卸换配件的，函数式编程也是这样，我们把可以`抽象`的`抽象`出来，再进行组合，进行`模块化`。\n\n---\n\n上面的例子循环是从`(0--传入的数字)`正序循环，若是我不想从`0`开始呢？若是我`倒序循环`、`随机循环`呢？\n\n改一下先把`_.tap`内部的`_each`循环去掉\n\n```\n\n function signIn(number){return _.chain([])\n.tap(function(numberBill){numberBill.push('同学 '+(number+1)+' 正常报数')\n console.log(('同学 '+(number+1)+' 正常报数'))\n}).value()}\n\n```\n\n另外说明：\n```\n上文中\n _.chain([])/*.push('同学 '+number+' 正常报数')\n```\n这个`链式操作`加上`push`是为了让大家理解`_.chain`函数的作用，因为我在`underscore`文档说过这样句话：\n ![](http://chuantu.biz/t6/104/1508427343x1875177637.png)\n \n说的很明白了，我们可以使用`_.chain`链式调用的同时，也支持`JS`原生`Array`的`prototype`中的`push`操作，并且知道你调用`value()`这些后面讲，不要耽误大家的思路。\n\n那么这个方法改成这样负责什么职能呢？\n\n---\n就是负责存储报数的同学生成点名单，并不在乎你怎么循环，我只负责保存，所以因为我们为了`灵活性`和`模块化`吧内部的`each`操作剔除了，所以我们必然要在其他地方实现遍历，而且最好能支持`自定义循环`...还要能保存上面方法返回的数据...\n\n--- \n\n于是乎我想到了`java`中的`模板引擎`，比如`jsp`，`freemaker`等，有这种设置`start`和`end`以及`步长`的操作，通过`步长`:`1`，`2`，`-1`，`-2`循环，按照这个思路造个`支持函数`的轮子，不是刚好可以解决这个问题嘛?\n\n但是我们别着急，若果你了解`underscore`你会知道,这种东西你找它就好了!\n\n- 运气不错\n\n哦？运气真好，不小心找到两个函数\n\n ![](http://chuantu.biz/t6/104/1508429384x1822611269.png) \n ![](http://chuantu.biz/t6/104/1508428257x2890149697.png)\n 我们可以用`_.range`和`_.reduce`搭配使用，用`_.range`假冒一个数组，搭配`reduce`迭代，模拟出了一个类似模板引擎步长迭代器之类的东西。\n是不是激起了你写JS模板引擎的欲望呢？\n-- 别傻了，js不需要，即便需要类似`grunt`中的`JST`插件或者`Underscore _.Templates`也完全够用了，现在是个公司都搞`前后分离`模板引擎只适合博客小项目，或者大公司静态化了...\n\n先写个`DEMO`测试一下：\n\n```\n var sum=_.reduce(_.range(1,10,1),function(memo,num){return memo+num},0\n这样我们就写出了1-10的累加，连循环都没写\n\n ps：（我以前看到个文章：30天不使用for循环）\n\n```\n- 欧耶\n\n没让您失望吧，其实对于`underscore`和`lodash`中的几个重要函数什么`防抖`、`节流阀`...我想深入开几张讲解的，正好我也深入研究一下，毕竟`好姿势`希望大家都能用上。\n\n```\n\n function startPositive(start,end,signInFn){\n return _.reduce(\n _.range(start,end,1),\n function(acc,n){\n return acc.concat(signInFn(n));\n},[])\n}\n\n var peapleArr=startPositive(0,10,signIn)\n```\n完成了\n\n做了什么事？\n\n我们成功把耦合函数内部的循环抽离了，分为了两个函数，\n主函数写名单数组，复函数提供`喊到`方法并且拿到数组\n\n- 好处？\n显而易见，你的喊道方式再也不用修改主函数了，你只要多写几个如：`startInvrse`、`startRandom`复函数提供方法即可\n\n若你需求更加复杂或者更加优雅，你可以把`startPositive`也进行抽离，改变步长达到`正序`、`逆序`、`随机`的效果。\n\n---\n\n①几乎`JS`的书籍都提到这个术语，现在java8都积极响应函数编程，但是有些人依然认为函数思想不如OO思想，[评论区撕逼](https:\n②命令编程，机器语言`if else``case`控制，流程都是你每行代码进行控制.而函编程更加自由、优雅。\n\n---\n\n### 文中出现的underscore函数\n\n- _.chain\n\n```\n chain_.chain(obj)\n返回一个封装的对象.在封装的对象上调用方法会返回封装的对象本身,\n直道value方法调用为止.\n```\n这个函数就是为了优雅的使用链式调用准备的，value很简单拿到最终值，毕竟链式调用的原理是返回对象本身，[设计模式第一部分](https://github.com/pkwenda/blog/issues/1)我就讲了\n ![](http://chuantu.biz/t6/104/1508431655x2890149697.png)\n ![](http://chuantu.biz/t6/104/1508431718x2890149697.png)\n 粗略通过源码我们知道`underscore`提供一个`value`返回真正的数据，并且`return``_wrapped`返回原始数据结束\n\n- _.tap\n\n```\n tap_.tap(object,interceptor)\n用object作为参数来调用函数interceptor，然后返回object。这种方法的主要意图是作为函数链式调用的一环,为了对此对象执行操作并返回对象本身。\n```\n可能有些人疑惑？为啥你的\n```\n.tap(function(numberBill){\n```\n\n```numberBill```哪来的?\n\n![](http:通过源码我们就知道其实是他利用回调将我们传入的`[]`返回的。\n\n- _.reduce\n\n刚才已经讲了使用方法，涉及到函数编程，我会后期单独出几章，并且仿造轮子\n\n本文 [github源码](https://github.com/pkwenda/blog/blob/master/code/FunctionaProgrammingExample2.html)![](http://chuantu.biz/t6/104/1508433100x2728309669.png)\n\n - 看情况百度\n其实不懂得东西没那么可怕，我们只有不断学习才能进步，不懂的东西不要百度，尽量看看官网API，看一手资源。\n",
    //       user: { id: 1 }
    //     },
    //     {
    //       headers: {
    //         // "Content-Type": "application/x-www-form-urlencoded",
    //         Accept: "application/json;charset=UTF-8"
    //       }
    //     }
    //   )
    //   .then(res => {
    //     console.log(res);
    //   });

    this.$http.get("/blog/getBlogById/1").then(res => {
      this.content = res.data.data.content;
      this.doMarkDown();
    });
  },
  mounted() {
    // document.getElementById("markdown-content").innerHTML = marked(
    //   this.content
    // );
    // $("pre code").each(function(i, block) {
    //   hljs.highlightBlock(block);
    // });
  },
  destroyed() {},
  methods: {
    doMarkDown() {
      document.getElementById("markdown-content").innerHTML = marked(
        this.content
      );

      $("pre code").each(function(i, block) {
        hljs.highlightBlock(block);
      });
    }
  }
};
</script>
 
