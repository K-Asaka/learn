import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'

Vue.config.productionTip = false

// $httpプロパティを追加
Vue.prototype.$http = (url, opts) => fetch(url, opts)

// アプリを起動
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
