

<template>
  <div v-for="(budgetItem,index) of budgetList" :key="index">
    <BudgetAuditWaitItem :budgetItem="budgetItem"/>
  </div>
</template>

<script>

import BudgetAuditWaitItem from "@/components/budget/BudgetAuditWaitItem";
import {
  defineComponent, reactive, toRefs,
}
  from 'vue'
import axios from "@/utils/axios";
import {localGet} from "@/utils";
import {ElMessage} from "element-plus";
export default defineComponent({
  name: "BudgetAuditWait",
  components: {
    BudgetAuditWaitItem,
  },
  created() {
    // 查询当前用户需要审批的申请
    axios.get('/api/flow/task?userId='+localGet('token').userId)
        .then(response=>{
          this.budgetList=response.data
          if(this.budgetList.length===0){
            ElMessage.success("暂无需要您审批的审评")
          }
          console.log("show budgetList:")
          console.log(this.budgetList)
        })
        .catch((error)=>{
          ElMessage.error(error.toString())
          console.log(error)
        })
  },
  setup() {
    const state=reactive({
      budgetList:[]
    })

    return{
      ...toRefs(state),
    }
  }
})

</script>

<style lang="scss">
.el-input-number.full-width-input,
.el-cascader.full-width-input {
  width: 100% !important;
}

.el-form-item--medium {
  .el-radio {
    line-height: 36px !important;
  }

  .el-rate {
    margin-top: 8px;
  }
}

.el-form-item--small {
  .el-radio {
    line-height: 32px !important;
  }

  .el-rate {
    margin-top: 6px;
  }
}

.el-form-item--mini {
  .el-radio {
    line-height: 28px !important;
  }

  .el-rate {
    margin-top: 4px;
  }
}

.clear-fix:before,
.clear-fix:after {
  display: table;
  content: "";
}

.clear-fix:after {
  clear: both;
}

.float-right {
  float: right;
}

</style>

<style lang="scss" scoped>
div.table-container {
  table.table-layout {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;

    td.table-cell {
      display: table-cell;
      height: 36px;
      border: 1px solid #e1e2e3;
    }
  }
}

div.tab-container {}

.label-left-align :deep(.el-form-item__label) {
  text-align: left;
}

.label-center-align :deep(.el-form-item__label) {
  text-align: center;
}

.label-right-align :deep(.el-form-item__label) {
  text-align: right;
}

.custom-label {}

.static-content-item {
  min-height: 20px;
  display: flex;
  align-items: center;

  :deep(.el-divider--horizontal) {
    margin: 0;
  }
}

</style>