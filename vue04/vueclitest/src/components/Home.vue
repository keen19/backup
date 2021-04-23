<template>
  <div>
    <h2>我是首页内容</h2>
    <router-link to="/home/news" replace>新闻</router-link>
    <router-link to="/home/message" replace>消息</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "Home",
  data(){
    return {
      message: '你好啊',
      path:'/home/news',
    }
  },
  created() {
    console.log('created')
  },
  destroyed() {
    console.log('destroyed')
  },
  meta:{
    keepAlive:true
  },
/*  activated() {
  },
  deactivated() {
  },
  beforeRouteLeave(to,from,next){
    this.path = this.$route.path;
    next();
  }*/
}
</script>

<style scoped>

</style>
