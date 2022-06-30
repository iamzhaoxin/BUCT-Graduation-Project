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
        <BudgetManager/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import BudgetManager from "@/components/budget/BudgetManager";
export default {
  name: "BudgetManagerPage",
  components: {
    BudgetManager,
    GlobalAside,
    GlobalHeader,
  }
}
</script>

<style scoped>

</style>