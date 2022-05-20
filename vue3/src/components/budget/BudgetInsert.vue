<template>
  <el-form :model="budgetData" ref="BudgetInsert" :rules="rules" label-position="left" label-width="100px"
           size="default" @submit.prevent>
    <div class="card-container">
      <el-card style="{width: 100% !important}" shadow="always">
        <template #header>
          <div class="clear-fix">
            <span>经费申请</span>
          </div>
        </template>
        <el-row>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="申请时间" prop="applyDate" class="label-right-align">
              <el-date-picker v-model="budgetData.applyDate" type="date" class="full-width-input"
                              format="YYYY-MM-DD" value-format="YYYY-MM-DD" clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="经费申请名称" prop="applyName" class="label-right-align">
              <el-input v-model="budgetData.applyName" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="经费类别" prop="applyType" class="label-right-align">
              <el-select v-model="budgetData.applyType" class="full-width-input" clearable>
                <el-option v-for="(item, index) in applyTypeAlternative" :key="index" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="申请类别" prop="applyCategory" class="label-right-align">
              <el-select v-model="budgetData.applyCategory" class="full-width-input" clearable>
                <el-option v-for="(item, index) in applyCategoryAlternative" :key="index" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="经费来源" prop="amountFrom" class="label-right-align">
              <el-input v-model="budgetData.amountFrom" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="预算年度" prop="amountYear" class="label-right-align">
              <el-input v-model="budgetData.amountYear" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="申请金额" prop="applyAmount" class="label-right-align">
              <el-input v-model="budgetData.applyAmount" type="text" placeholder="人民币（元）" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="申请人工号" prop="applyUserId" class="label-right-align">
              <el-input v-model="budgetData.applyUserId" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="负责人工号" prop="programPrincipalId" class="label-right-align">
              <el-input v-model="budgetData.programPrincipalId" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5" class="grid-cell">
            <el-form-item label="所属部门" prop="applyUnit" class="label-right-align">
              <el-input v-model="budgetData.applyUnit" class="full-width-input" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="是否进口" prop="ifImport" class="label-right-align">
              <el-select v-model="budgetData.ifImport" class="full-width-input" clearable>
                <el-option v-for="(item, index) in importAlternative" :key="index" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24" class="grid-cell">
            <el-form-item label="申请理由" prop="applySeason" class="label-right-align">
              <el-input type="textarea" v-model="budgetData.applySeason" rows="4"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" class="grid-cell">
            <el-form-item label="备注" prop="applySeason" class="label-right-align">
              <el-input type="textarea" v-model="budgetData.applyRemark" rows="1"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-card>
    </div>

    <br>

    <div class="card-container">
      <el-card style="{width: 100% !important}" shadow="never">
        <template #header>
          <div class="clear-fix">
            <span>申请资产明细</span>
            <i class="float-right el-icon-arrow-down"></i>
          </div>
        </template>
        <el-row>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="资产名称" prop="detailAssetName" class="label-right-align">
              <el-input v-model="budgetData.detailAssetName" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="存放地点" prop="storage" class="label-right-align">
              <el-input v-model="budgetData.storage" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="资产型号" prop="detailAssetModel" class="label-right-align">
              <el-input v-model="budgetData.detailAssetModel" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4" class="grid-cell">
            <el-form-item label="资产规格" prop="detailAssetSpec" class="label-right-align">
              <el-input v-model="budgetData.detailAssetSpec" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="数量" prop="detailAssetCount" class="label-right-align">
              <el-input-number v-model="budgetData.detailAssetCount" class="full-width-input"
                               controls-position="right" :min="0" :max="100000000000" :precision="0" :step="1">
              </el-input-number>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="计量单位" prop="detailAssetUnit" class="label-right-align">
              <el-input v-model="budgetData.detailAssetUnit" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="3" class="grid-cell">
            <el-form-item label="单价" prop="detailAssetPrice" class="label-right-align">
              <el-input v-model="budgetData.detailAssetPrice" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" class="grid-cell">
            <el-form-item label="备注" prop="detailRemark" class="label-right-align">
              <el-input type="textarea" v-model="budgetData.detailRemark" rows="2"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-card>
    </div>
    <br>
    <div class="static-content-item" style="float: right">
<!--      todo 增加资产明细卡片-->
<!--      <el-button type="warning" plain>增加资产明细卡片</el-button>-->
      <el-button type="info" plain>保存申请</el-button>
      <el-button type="success" @click="submitForm" plain>提交申请</el-button>
      <el-button type="danger" @click="refresh" plain>清空表单</el-button>
    </div>
  </el-form>

</template>

<script>
import {defineComponent, getCurrentInstance, reactive, toRefs} from 'vue'
import {localGet} from "@/utils";
import {ElMessage} from "element-plus";
import axios from "@/utils/axios";

export default defineComponent({
  components: {},
  props: {},
  setup() {
    const state = reactive({
      budgetData: {
        // 经费申请
        applyDate: getCurrDate(),
        applyName: "",
        applyType: "科研",
        applyCategory: "常规类",
        amountFrom:"",
        amountYear:new Date().getFullYear(),
        applyAmount: "",
        applyUserId: localGet(`token`).userId,
        programPrincipalId:"",
        // todo 设置为根据工号动态查询所属部门
        applyUnit: localGet(`token`).unitName,
        ifImport:"",
        applySeason: "",
        applyRemark:"",

        // 资产明细
        detailAssetName: "",
        // fixme 验证storage是否存在，或者改成下拉选择
        storage:"",
        detailAssetModel:"",
        detailAssetSpec: "",
        detailAssetCount: 0,
        detailAssetUnit: "",
        detailAssetPrice: "",
        detailRemark:"",
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
    const { proxy } = getCurrentInstance();
    const submitForm = () => {
      proxy.$refs['BudgetInsert'].validate(valid => {
        if (!valid){
          ElMessage.error("填写错误")
          return
        }
        axios
            .post('/api/budget/insert',state.budgetData)
            .then(()=>{
              ElMessage.success("提交成功")
              proxy.$refs['BudgetInsert'].resetFields()
            })
            .catch((error)=>{
              ElMessage.error(error.toString())
              console.log(error)
            })
      })
    }
    /**
     * 获得当前日期（年-月-日）
     */
    function getCurrDate() {
      var date = new Date();
      var sep = "-";
      var year = date.getFullYear(); //获取完整的年份(4位)
      var month = date.getMonth() + 1; //获取当前月份(0-11,0代表1月)
      var day = date.getDate(); //获取当前日
      if (month <= 9) {
        month = "0" + month;
      }
      if (day <= 9) {
        day = "0" + day;
      }
      return year + sep + month + sep + day;
    }
    // 重置表单
    function refresh(){
      proxy.$refs['BudgetInsert'].resetFields()
    }
    return {
      ...toRefs(state),
      submitForm,
      refresh
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