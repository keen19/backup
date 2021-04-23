//配置路由相关的信息
import VueRouter from 'vue-router'
import Vue from 'vue'

//1. 通过Vue.use(插件),安装插件
Vue.use(VueRouter);

/*const routes=[
  //传入路由映射配置
  {
    path:'/',
    //重定向
    redirect:'/home'
  },
  {
    path: '/home',
    component: Home
  },
  {
    path: '/about',
    component: About
  }
];*/

const Home = () =>import("../components/Home");
const About = () => import("../components/About");
const User = () =>import ("../components/User");
const HomeNews =() => import("../components/HomeNews");
const HomeMessage =() => import("../components/HomeMessage");
const Profile =() => import("../components/Profile");

//2. 创建路由实例
const router = new VueRouter({
  //配置路由和组件之间的应用关系
  // routes,
  routes:[
    //传入路由映射配置
    {
      path:'/',
      //重定向
      redirect:'/home'
    },
    {
      path: '/home',
      component:Home,
      meta:{
        title:'首页',
        keepAlive:true
      },
      children:[
        {
          path: '',
          redirect:'news',
        },
        {
          path:'news',
          component:HomeNews
        },
        {
          path:'message',
          component:HomeMessage
        }
      ],

    },
    {
      path: '/about',
      component: About,
      meta:{
        title:'关于'
      },
    },
    {
      path:'/user/:userId',
      component: User,
      meta:{
        title:'用户'
      },
    },
    {
      path: '/profile',
      component:Profile,
    meta:{
  title:'文档'
},
    }
  ],
  mode:'history',
  linkActiveClass:'active'
});

//前置钩子,必须有next
router.beforeEach((to,from,next)=>{
  //从from跳转到to
  document.title=to.matched[0].meta.title;
  console.log(to);
  console.log('前置钩子');
  next();
});

//后置钩子
router.afterEach((to,from)=>{
  console.log('--后置钩子'
  )
});


// 3.将router对象传入到Vue实例
export default router
