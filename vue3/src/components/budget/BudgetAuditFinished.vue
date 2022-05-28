

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
        <!--        <template>-->
        <el-form :model="formData" ref="vForm" :rules="rules" label-position="left" label-width="80px"
                 size="default" @submit.prevent>
          <div class="card-container">
            <el-card style="{width: 100% !important}" shadow="never">
              <template #header>
                <div class="clear-fix">
                  <span>xxx申请名称</span>
                  <i class="float-right el-icon-arrow-down"></i>
                </div>
              </template>
              <el-row>
                <el-col :span="5" class="grid-cell">
                  <el-form-item label="申请时间" prop="date76380" class="label-right-align">
                    <el-date-picker v-model="formData.date76380" type="date" class="full-width-input"
                                    format="YYYY-MM-DD" value-format="YYYY-MM-DD" clearable></el-date-picker>
                  </el-form-item>
                </el-col>
                <el-col :span="3" class="grid-cell">
                  <el-form-item label="经费类别" prop="input45949" class="label-right-align">
                    <el-input v-model="formData.input45949"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="3" class="grid-cell">
                  <el-form-item label="申请金额" prop="input33006" class="label-right-align">
                    <el-input v-model="formData.input33006"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="3" class="grid-cell">
                  <el-form-item label="申请人" prop="input112528" class="label-right-align">
                    <el-input v-model="formData.input112528" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="4" class="grid-cell">
                  <el-form-item label="部门" prop="input64599" class="label-right-align">
                    <el-input v-model="formData.input64599" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" class="grid-cell">
                  <el-button style="display:block;margin:0 auto" type="success">审批通过</el-button>
                </el-col>
<!--                <el-col :span="3" class="grid-cell">-->
<!--                  <div class="static-content-item">-->
<!--                    <el-button style="display:block;margin:0 auto" type="primary">修改申请</el-button>-->
<!--                  </div>-->
<!--                </el-col>-->
<!--                <el-col :span="3" class="grid-cell">-->
<!--                  <div class="static-content-item">-->
<!--                    <el-button type="danger">撤销申请</el-button>-->
<!--                  </div>-->
<!--                </el-col>-->
              </el-row>
              <div class="static-content-item">
                <el-divider direction="horizontal"></el-divider>
              </div>
              <el-row>
                <el-col :span="7" class="grid-cell">
                  <el-form-item label="资产" prop="input33198" class="label-right-align">
                    <el-input v-model="formData.input33198"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" class="grid-cell">
                  <el-form-item label="型号" prop="input62136" class="label-right-align">
                    <el-input v-model="formData.input62136" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" class="grid-cell">
                  <el-form-item label="数量" prop="input83311" class="label-right-align">
                    <el-input v-model="formData.input83311" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" class="grid-cell">
                  <el-form-item label="单价" prop="input93979" class="label-right-align">
                    <el-input v-model="formData.input93979" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" class="grid-cell">
                  <el-form-item label="资产" prop="input40198" class="label-right-align">
                    <el-input v-model="formData.input40198"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" class="grid-cell">
                  <el-form-item label="型号" prop="input53544" class="label-right-align">
                    <el-input v-model="formData.input53544"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" class="grid-cell">
                  <el-form-item label="数量" prop="input22054" class="label-right-align">
                    <el-input v-model="formData.input22054"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" class="grid-cell">
                  <el-form-item label="单价" prop="input104872" class="label-right-align">
                    <el-input v-model="formData.input104872"  type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-card>
          </div>
        </el-form>
        <!--        </template>-->
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import {
  defineComponent,
  toRefs,
  reactive,
  getCurrentInstance
}
  from 'vue'
export default defineComponent({
  name: "BudgetAuditFinished",
  components: {
    GlobalAside,
    GlobalHeader
  },
  props: {},
  setup() {
    const state = reactive({
      formData: {
        date76380: "2022-04-16",
        input45949: "科研",
        input33006: "20150元",
        input112528: "赵鑫",
        input64599: "教务处",
        input33198: "笔记本电脑",
        input62136: "联想小新pro",
        input83311: "5",
        input93979: "4000元",
        input40198: "插排",
        input53544: "公牛5003",
        input22054: "5",
        input104872: "30",
      },
      rules: {},
    })
    const instance = getCurrentInstance()
    // const submitForm = () => {
    //   instance.ctx.$refs['vForm'].validate(valid => {
    //     if (!valid) return
    //     //TODO: 提交表单
    //   })
    // }
    const resetForm = () => {
      instance.ctx.$refs['vForm'].resetFields()
    }
    return {
      ...toRefs(state),
      resetForm
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