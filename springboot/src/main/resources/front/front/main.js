import Vue from 'vue'
import App from './App'
import utils from './utils/utils.js'
import api from './api/index.js'
import base from './api/base.js'
import * as validate from 'utils/validate.js'
// 工具类
import { isAuth } from '@/utils/system'
import { isAuthFront } from '@/utils/system'
// 弹出层
import uniPopup from "./components/uni-popup/uni-popup.vue"
// 上拉,下拉组件
import MescrollUni from "./components/mescroll-uni/mescroll-uni.vue";
// 上拉,下拉组件
import uniLoadMore from "./components/uni-load-more/uni-load-more.vue"
import {VueJsonp} from './components/vue-jsonp'
//轮播
import zSwiperItem from "./components/zebra-swiper/components/z-swiper-item/z-swiper-item.vue";
import zSwiper from "./components/zebra-swiper/components/z-swiper/z-swiper.vue";

import musicPlay from "./components/musicPlay/musicPlay";

Vue.use(VueJsonp)
Vue.prototype.$utils = utils
Vue.prototype.$base = base
Vue.prototype.$api = api
Vue.prototype.$validate = validate
// 判断权限方法
Vue.prototype.isAuth = isAuth
Vue.prototype.isAuthFront = isAuthFront


Vue.component('uniLoadMore', MescrollUni)
Vue.component('mescroll-uni', MescrollUni)
Vue.component('uni-popup',uniPopup)
//轮播
Vue.component('z-swiper-item',zSwiperItem)
Vue.component('z-swiper',zSwiper)

Vue.component('musicPlay', musicPlay)

Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
	...App
})
app.$mount()
