<template>
  <div v-if="show">
    <router-view></router-view>
  </div>
</template>

<script>
import {localGet, localRemove} from "@/utils";
import {provide, ref,nextTick} from "vue";

export default {
  name: 'App',
  setup() {
    let show=ref('true')

    // 取消勾选自动登录时，删除用户信息
    window.onbeforeunload = function () {
      if (localGet('autoLogin') === null) {
        localRemove('token')
      }
    }

    function refreshView(){
      show=false
      console.log("refreshView!")
      nextTick(()=>{
        show=true
      })
    }
    // 传给子组件refreshView函数
    provide('refreshView',refreshView)

    return{
      show,
      refreshView
    }
  }
}
</script>

<style scoped>

</style>

<style>
.GlobalHeader {
  height: 5%;
  padding-left: 0;
  padding-right: 0;
  /*background-image: url('../../assets/img.png');*/
  background-color: lightskyblue;
}
</style>
