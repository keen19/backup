<template>
  <div id="app">
<!--    //<img src="./assets/logo.png">-->
    <router-link to="/home" tag="button" replace active-class="active">首页</router-link>
    <router-link to="/about" tag="button" replace active-class="active">关于</router-link>
    <router-link :to="{path:'/profile',query:{name:'kobe'}}" tag="button" replace active-class="active">文档</router-link>
    <router-link :to="'/user/'+userId" tag="button" replace active-class="active">用户</router-link>

    <button @click="homeClick">首页</button>
    <button @click="aboutClick">关于</button>
    <keep-alive >
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return {
      userId: 'lisi'
    }
  },
  methods:{
    homeClick(){
      //this.$router.push('/home')
      this.$router.replace('/home')
    },
    aboutClick(){
      //this.$router.push('/about')
      this.$router.replace('/about')

    }
  }
}
</script>

<style>
  .active{
    color: red;
  }

</style>
