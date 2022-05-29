<template>
  <el-form :model="formData" ref="vForm" :rules="rules" label-position="left" label-width="80px"
           style="height: 100%" @submit.prevent>
    <div class="tab-container" style="height: 100%">
      <el-tabs style="height: 100%" type="border-card">

        <el-tab-pane label="概览">

          <el-table
              :data="tableData"
              tooltip-effect="dark"
              style="width: 100%">
            <el-table-column
                prop="statu"
                label="状态"
            >
            </el-table-column>
            <el-table-column
                prop="declaration.declarationName"
                label="项目名称"
            >
            </el-table-column>
            <el-table-column
                prop="['declaration'].declarationDate"
                label="申报日期"
            >
            </el-table-column>
          </el-table>


        </el-tab-pane>

        <el-tab-pane name="tab1" label="待处理">


          <el-row>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>状态</div>
              </div>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <div class="static-content-item">
                <div>项目名称</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>申报日期</div>
              </div>
            </el-col>
          </el-row>

          <div class="static-content-item">
            <el-divider direction="horizontal"></el-divider>
          </div>

          <el-row>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>待提交</div>
              </div>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <div class="static-content-item">
                <div>科研设备采购</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>2022-04-13</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>待确认</div>
              </div>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <div class="static-content-item">
                <div>货物类采购申请</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>2022-04-09</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>待审批</div>
              </div>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <div class="static-content-item">
                <div>常规设备采购</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>2022-04-05</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>待审批</div>
              </div>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <div class="static-content-item">
                <div>常规设备采购</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>2022-03-25</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>待审批</div>
              </div>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <div class="static-content-item">
                <div>常规设备采购</div>
              </div>
            </el-col>
            <el-col :span="6" class="grid-cell">
              <div class="static-content-item">
                <div>2022-03-19</div>
              </div>
            </el-col>
          </el-row>


        </el-tab-pane>
      </el-tabs>
    </div>
  </el-form>

</template>

<script>
import {
  defineComponent,
  toRefs,
  reactive,
}
  from 'vue'
import axios from "@/utils/axios";
import {localGet} from "@/utils";
import {ElMessage} from "element-plus";
export default defineComponent({
  components: {},
  props: {},
  created() {
    // 获得当前用户的所有申请
    // todo：添加当前审批状态
    axios.get('/api/budget/ones?userId='+localGet('token').userId)
        .then(response=>{
          this.tableData=response.data


          this.tableData.forEach((budgetItem)=>{
            budgetItem.declaration.declarationDate=budgetItem.declaration.declarationDate.slice(0, 10)
            let declarationId=budgetItem.declaration.declarationId
            axios.get('/api/flow/status?declarationId=' + declarationId)
                .then((response) => {
                  budgetItem['statu']=response.data
                })
                .catch((error) => {
                  ElMessage.error(error.toString())
                  console.log(error)
                })
          })

          this.tableData=this.tableData.filter(item=>{
            if(item.statu==="未审"||item['statu']==="审批中"){
              return null;
            }else{
              return item
            }
          })

        })
        .catch((error)=>{
          ElMessage.error(error.toString())
          console.log(error)
        })

  },
  setup() {
    const state = reactive({
      tableData:[],
      loading: false,
    })
    return {
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