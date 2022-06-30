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
        <BudgetAuditWait/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import BudgetAuditWait from "@/components/budget/BudgetAuditWait";
export default {
  name: "BudgetAuditWaitPage",
  components: {
    BudgetAuditWait,
    GlobalAside,
    GlobalHeader,
  }
}
</script>

<style scoped>

</style>