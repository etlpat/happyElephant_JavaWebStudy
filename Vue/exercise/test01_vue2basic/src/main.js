// 该文件为项目的入口文件！

import Vue from 'vue'// 引入vue
import App from './App.vue'// 引入App组件（所有组件的父组件）

// 关闭vue的生产提示
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')// 配置el:'#app'
