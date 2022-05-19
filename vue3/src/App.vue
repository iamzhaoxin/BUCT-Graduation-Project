<template>
  <router-view></router-view>
</template>

<script>
import {localGet, localRemove} from "@/utils";
import {ref} from "vue";

export default {
  name: 'App',
  setup() {
    let show = ref('true')

    // 取消勾选自动登录时，删除用户信息
    window.onbeforeunload = function () {
      if (localGet('autoLogin') === null) {
        localRemove('token')
      }
    }

    return {
      show,
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
