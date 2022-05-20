<template>
  <el-form :model="budgetData" ref="BudgetInsert" :rules="rules" label-position="left" label-width="100px"
           size="default" @submit.prevent>
    <div class="card-container">
      <el-card style="{width: 100% !important}" shadow="always">
        <template #header>
          <div class="clear-fix">
            <span>{{ budgetData['declaration'].declarationName }}</span>
          </div>
        </template>
        <el-row>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="申请时间" prop="applyDate" class="label-right-align">
              <el-date-picker v-model="budgetData['declaration'].declarationDate" type="date" class="full-width-input"
                              format="YYYY-MM-DD" value-format="YYYY-MM-DD" clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="经费申请名称" prop="applyName" class="label-right-align">
              <el-input v-model="budgetData['declaration'].declarationName" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="经费类别" prop="applyType" class="label-right-align">
              <el-select v-model="budgetData['declaration'].declarationType" class="full-width-input" clearable>
                <el-option v-for="(item, index) in applyTypeAlternative" :key="index" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="申请类别" prop="applyCategory" class="label-right-align">
              <el-select v-model="budgetData['declaration'].declarationCategory" class="full-width-input" clearable>
                <el-option v-for="(item, index) in applyCategoryAlternative" :key="index" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="经费来源" prop="amountFrom" class="label-right-align">
              <el-input v-model="budgetData['declaration'].budgetSource" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="预算年度" prop="amountYear" class="label-right-align">
              <el-input v-model="budgetData['declaration'].budgetYear" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="申请金额" prop="applyAmount" class="label-right-align">
              <el-input v-model="budgetData['declaration'].declarationAmount" type="text" placeholder="人民币（元）"
                        clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="申请人工号" prop="applyUserId" class="label-right-align">
              <el-input v-model="budgetData['declaration'].userIdApply" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="负责人工号" prop="programPrincipalId" class="label-right-align">
              <el-input v-model="budgetData['declaration'].unitPrincipalIdApply" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="所属部门" prop="applyUnit" class="label-right-align">
              <el-input v-model="budgetData['declaration'].unitName" class="full-width-input" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="是否进口" prop="ifImport" class="label-right-align">
              <el-select v-model="budgetData['declaration'].declarationIsImport" class="full-width-input" clearable>
                <el-option v-for="(item, index) in importAlternative" :key="index" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24" class="grid-cell">
            <el-form-item label="申请理由" prop="applySeason" class="label-right-align">
              <el-input type="textarea" v-model="budgetData['declaration'].declarationReason"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" class="grid-cell">
            <el-form-item label="备注" prop="applySeason" class="label-right-align">
              <el-input type="textarea" v-model="budgetData['declaration'].declarationRemark" rows="1"></el-input>
            </el-form-item>
          </el-col>

          <el-divider/>

          <el-col :span="4" class="grid-cell">
            <el-form-item label="资产名称" prop="detailAssetName" class="label-right-align">
              <el-input v-model="budgetData['asset'].detailAssetName" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="存放地点" prop="storage" class="label-right-align">
              <el-input v-model="budgetData['asset'].storageName" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="资产型号" prop="detailAssetModel" class="label-right-align">
              <el-input v-model="budgetData['asset'].detailAssetModel" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="资产规格" prop="detailAssetSpec" class="label-right-align">
              <el-input v-model="budgetData['asset'].detailAssetSpec" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="数量" prop="detailAssetCount" class="label-right-align">
              <el-input-number v-model="budgetData['asset'].detailAssetCount" class="full-width-input"
                               controls-position="right" :min="0" :max="100000000000" :precision="0" :step="1">
              </el-input-number>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="计量单位" prop="detailAssetUnit" class="label-right-align">
              <el-input v-model="budgetData['asset'].detailAssetUnit" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="单价" prop="detailAssetPrice" class="label-right-align">
              <el-input v-model="budgetData['asset'].detailAssetPrice" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" class="grid-cell">
            <el-form-item label="备注" prop="detailRemark" class="label-right-align">
              <el-input type="textarea" v-model="budgetData['asset'].detailMark"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="24" class="grid-cell">
            <el-button style="float: right;margin-right: 50px" type="success" @click="allowDialogFormVisible = true" plain>
              通过申请
            </el-button>
            <el-dialog v-model="allowDialogFormVisible" title="审批意见">
              <el-form :model="suggest.value">
                <el-form-item>
                  <el-input type="textarea" v-model="suggest.value" rows="5"></el-input>
                </el-form-item>
              </el-form>
              <template #footer>
                <span class="dialog-footer">
                  <el-button @click="allowDialogFormVisible = false">取消</el-button>
                  <el-button type="success" @click="allowBudget">通过</el-button>
                </span>
              </template>
            </el-dialog>

            <el-button style="float: right;margin-right: 100px" type="danger" @click="refuseDialogFormVisible = true" plain>
              拒绝申请
            </el-button>
            <el-dialog v-model="refuseDialogFormVisible" title="审批意见">
              <el-form :model="suggest.value">
                <el-form-item>
                  <el-input type="textarea" v-model="suggest.value" rows="5"></el-input>
                </el-form-item>
              </el-form>
              <template #footer>
                <span class="dialog-footer">
                  <el-button @click="refuseDialogFormVisible = false">取消</el-button>
                  <el-button type="danger" @click="refuseBudget">拒绝</el-button>
                </span>
              </template>
            </el-dialog>
          </el-col>

        </el-row>
      </el-card>
      <br>
      <br>
    </div>
  </el-form>

</template>

<script>


import {reactive, toRef, toRefs} from "vue";
import axios from "@/utils/axios";
import {ElMessage} from "element-plus";
import {localGet} from "@/utils";

export default {
  name: "BudgetAuditWaitItem",
  props: {
    budgetItem: {
      asset: {
        detailAssetId: Number,
        declarationId: Number,
        declarationName: String,
        detailAssetName: String,
        unitId: String,
        unitName: String,
        detailAssetModel: String,
        detailAssetSpec: String,
        storageName: String,
        detailAssetCount: String,
        detailAssetUnit: String,
        detailAssetPrice: String,
        detailMark: String,
      },
      declaration: Object,
      processInstanceId:String,
    }
  },
  setup(props) {
    const state = reactive({
      budgetData: toRef(props, "budgetItem"),
      allowDialogFormVisible: false,
      refuseDialogFormVisible: false,
      suggest: {
        userId:localGet('token').userId,
        processInstanceId:"",
        status:"",
        value:"",
      },
      rules: {
        applyAmount: [{
          pattern: /^\d+(\.\d+)?$/,
          trigger: ['blur', 'change'],
          message: ''
        }],
        applyUserId: [{
          pattern: /^\d+(\.\d+)?$/,
          trigger: ['blur', 'change'],
          message: ''
        }],
      },
      applyTypeAlternative: [{
        "label": "科研",
        "value": "科研"
      }, {
        "label": "教学",
        "value": "教学"
      }, {
        "label": "其他",
        "value": "其他"
      }],
      applyCategoryAlternative: [{
        "label": "常规类",
        "value": "常规类"
      }, {
        "label": "大型仪器",
        "value": "大型仪器"
      }, {
        "label": "科研零散",
        "value": "科研零散"
      }],
      importAlternative: [{
        "label": "是",
        "value": "是"
      }, {
        "label": "否",
        "value": "否"
      }],
    })

    state.suggest.processInstanceId=state.budgetData['processInstanceId']
    console.log("processInstanceId: "+state.suggest.processInstanceId)
    state.budgetData['declaration'].declarationDate.slice(0, 10)
    console.log("Item.Vue show:")
    console.log(state.budgetData.declaration.declarationDate)

    function allowBudget() {
      state.suggest.status="true"
      axios.post('/api/flow/complete',state.suggest)
          .then(() => {
            ElMessage.success("审批成功")
            location.reload();
          })
          .catch((error) => {
            ElMessage.error(error.toString())
            console.log(error)
          })
    }

    function refuseBudget() {
      state.suggest.status="false"
      axios.post('/api/flow/complete',state.suggest)
          .then(() => {
            ElMessage.success("审批成功")
            location.reload();
          })
          .catch((error) => {
            ElMessage.error(error.toString())
            console.log(error)
          })
    }

    return {
      ...toRefs(state),
      allowBudget,
      refuseBudget
    }
  }
}
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

div.tab-container {
}

.label-left-align :deep(.el-form-item__label) {
  text-align: left;
}

.label-center-align :deep(.el-form-item__label) {
  text-align: center;
}

.label-right-align :deep(.el-form-item__label) {
  text-align: right;
}

.custom-label {
}

.static-content-item {
  min-height: 20px;
  display: flex;
  align-items: center;

  :deep(.el-divider--horizontal) {
    margin: 0;
  }
}

</style>