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


        <el-upload
            accept=".zip"
            class="upload-demo"
            action="/api/flow/upload"
            :limit="1"
            :on-success="uploadSuccessHandler"
            :on-error="uploadErrorHandler">
          <el-button type="success" size="large">点击上传自定义流程(zip压缩包文件名即为流程名称)</el-button>
        </el-upload>


        <div v-for="(flowItem,index) of flowList" :key="index">
          <FlowItem :flowItem="flowItem" :usingProcessId="usingProcessId"/>
        </div>

      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
import FlowItem from "@/components/flow/FlowItem";
import axios from "@/utils/axios";
import {ElMessage} from "element-plus";
import {reactive, toRefs} from "vue";

export default {
  name: "FlowManager",
  components: {
    GlobalAside,
    GlobalHeader,
    FlowItem,
  },
  created() {
    // 获得所有流程的 id, name, key, reversion, png, bpmn
    axios.get('/api/flow/getAll')
        .then(response => {
          this.flowList = response.data
          console.log("show flowList:")
          console.log(this.flowList)
        })
        .catch((error) => {
          ElMessage.error(error.toString())
          console.log(error)
        })
    // 查询使用中的流程
    axios.get('/api/flow/using')
        .then(response => {
          this.usingProcessId = response.data
          console.log("using usingProcessId:")
          console.log(this.usingProcessId)
        })
        .catch((error) => {
          ElMessage.error(error.toString())
          console.log(error)
        })
  },

  setup() {
    const state = reactive({
      flowList: [],
      usingProcessId:"",
    })

    const uploadSuccessHandler = () => {
      ElMessage.success("文件上传成功")
      location.reload();
    }
    const uploadErrorHandler = () => {
      ElMessage.error("上传文件失败")
    }

    return {
      ...toRefs(state),
      uploadSuccessHandler,
      uploadErrorHandler
    }
  }
}
</script>

<style scoped>

</style>