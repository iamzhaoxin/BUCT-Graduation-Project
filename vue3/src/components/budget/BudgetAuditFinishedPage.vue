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
        <BudgetAuditFinished/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import BudgetAuditFinished from "@/components/budget/BudgetAuditFinished";
export default {
  name: "BudgetAuditFinishedPage",
  components: {
    BudgetAuditFinished,
    GlobalAside,
    GlobalHeader,
  }
}
</script>

<style scoped>

</style>