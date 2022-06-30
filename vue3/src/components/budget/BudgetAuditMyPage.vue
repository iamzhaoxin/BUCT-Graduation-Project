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
        <BudgetAuditMy/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import BudgetAuditMy from "@/components/budget/BudgetAuditMy";
export default {
  name: "BudgetAuditMyPage",
  components: {
    BudgetAuditMy,
    GlobalAside,
    GlobalHeader,
  }
}
</script>

<style scoped>

</style>