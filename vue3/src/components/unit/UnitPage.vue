<template>
  <el-container style="height: 100%">
    <el-aside>
      <GlobalAside/>
    </el-aside>
    <el-container>
      <el-header class="GlobalHeader">
        <GlobalHeader/>
      </el-header>
      <el-main>
        <UnitManager/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import UnitManager from "@/components/unit/UnitManager";

export default {
  name: "UnitPage",
  components: {
    GlobalAside,
    GlobalHeader,
    UnitManager,
  }
}
</script>

<style scoped>

</style>