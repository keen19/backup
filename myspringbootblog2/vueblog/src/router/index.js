import Vue from "vue";
import Router from 'vue-router'
import Login from "../components/Login";


Vue.use(Router)

const routes = [
    {
        path: '/',
        name:'登录',
        hidden:true,
        component: Login
    },
    {

    }
]

const router = new Router({
    routes,
    mode:'history'
})

export default router