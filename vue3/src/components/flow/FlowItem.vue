<template>
  <el-form :model="flowDetail" ref="flowChoose" label-position="left" label-width="100px"
           size="default" @submit.prevent>
    <div class="card-container">
      <el-card style="{width: 100% !important}" shadow="always">

        <template #header>
          <div class="clear-fix">
            <span>{{ flowDetail.name }}</span>
          </div>
        </template>
        <el-row>

          <el-col :span="12" class="grid-cell">
            流程示意图:
            <br><br><br><br><br><br><br><br><br><br>
            <div>
              <el-image :src="flowDetail.png"/>
            </div>
          </el-col>

          <el-col :span="12" class="grid-cell">
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="流程Id" class="label-right-align">
                  <el-input v-model="flowDetail.id" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="流程名称" class="label-right-align">
                  <el-input v-model="flowDetail.name" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="Key" class="label-right-align">
                  <el-input v-model="flowDetail.key" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="版本号" class="label-right-align">
                  <el-input v-model="flowDetail.reversion" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>

          <!-- 启用流程（已启用）、删除流程、设置流程-->
          <el-col :span="24" class="grid-cell">
            <el-button style="float: right;margin-right: 20px" type="success" @click="useFlow" plain>{{useProcessView}}</el-button>
            <el-button style="float: right;margin-right: 50px" type="primary" @click="setFlow" plain>设置流程</el-button>
            <el-button style="float: right;margin-right: 50px" type="danger" @click="deleteFlow" plain>删除流程</el-button>
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

export default {
  name: "FlowItem",
  props: {
    flowItem: {
      id: String,
      name: String,
      key: String,
      reversion: String,
      png: File,
      bpmn: File,
    },
    usingProcessId:String,
  },
  setup(props) {
    const state = reactive({
      flowDetail: toRef(props, "flowItem"),
      usingProcessId:toRef(props, "usingProcessId"),
      useProcessView:"启用流程",
    })
    if(state.flowDetail.id===state.usingProcessId){
      state.useProcessView="已启用"
    }

    function useFlow() {
      axios.get('/api/flow/use?id=' + state.flowDetail.id)
          .then(() => {
            ElMessage.success("启用成功")
            location.reload();
          })
          .catch((error) => {
            ElMessage.error(error.toString())
            console.log(error)
          })
    }


    function setFlow() {
      // 输入各个负责人的工号，发送给后端进行匹配
      //todo 后续可以升级为，输入工号或角色，拥有此角色的所有用户都可以审批
    }

    function deleteFlow() {
      axios.get('/api/flow/delete?id=' + state.flowDetail.id)
          .then(() => {
            ElMessage.success("删除成功")
            location.reload();
          })
          .catch((error) => {
            ElMessage.error(error.toString())
            console.log(error)
          })
    }

    return {
      ...toRefs(state),
      useFlow,
      deleteFlow,
      setFlow
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