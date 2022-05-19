

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
        <div v-for="(budgetItem,index) of budgetList" :key="index">
          <BudgetManagerItem :budgetItem="budgetItem"/>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import BudgetManagerItem from "@/components/budget/BudgetManagerItem";
import {
  defineComponent, reactive, toRefs,
}
  from 'vue'
import axios from "@/utils/axios";
import {localGet} from "@/utils";
import {ElMessage} from "element-plus";
export default defineComponent({
  name: "BudgetManager",
  components: {
    BudgetManagerItem,
    GlobalAside,
    GlobalHeader
  },
  created() {
    axios.get('/api/budget/ones?userId='+localGet('token').userId)
        .then(response=>{
          this.budgetList=response.data
          console.log("show budgetList:")
          console.log(this.budgetList)
        })
        .catch((error)=>{
          ElMessage.error(error.toString())
          console.log(error)
        })
  },
  setup() {
    // todo: 从后端接收当前用户的申请数组
    const state=reactive({
      budgetList:[]
    })
    // let budgetList=reactive([
    //   {
    //     // 经费申请
    //     applyId:1,
    //     applyDate: "2022-05-18",
    //     applyName: "经费申请名称",
    //     applyType: "科研",
    //     applyCategory: "常规类",
    //     amountFrom:"1",
    //     amountYear:"11",
    //     applyAmount: "1",
    //     applyUserId: "12",
    //     programPrincipalId:"",
    //     applyUnit: "11",
    //     ifImport:"1",
    //     applySeason: "1",
    //     applyRemark:"1",
    //
    //     // 资产明细
    //     detailAssetId:111,
    //     detailAssetName: "",
    //     storage:"",
    //     detailAssetModel:"",
    //     detailAssetSpec: "",
    //     detailAssetCount: 11,
    //     detailAssetUnit: "",
    //     detailAssetPrice: "",
    //     detailRemark:"",
    //   },
    // ])

    return{
      ...toRefs(state),
      // budgetList,
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