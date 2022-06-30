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
        <div style="font-size: 30px">附件下载</div>

        <el-divider/>

        <el-table
            :data="tableData"
            style="width: 100%; margin-bottom: 20px"
            row-key="unitId"
            border
            default-expand-all
        >
          <el-table-column prop="name" label="文件名称"/>
          <el-table-column prop="description" label="说明"/>
          <el-table-column label="操作">
            <a href="/导入用户模板.xlsx" download>下载</a>
<!--            <template #default="scope">-->
<!--              <el-button href="/导入用户模板.xlsx" download size="small" @click="handleEdit(scope.$index, scope.row)">下载</el-button>-->
<!--            </template>-->
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </el-container>


</template>
<script>
import {reactive, toRefs} from "vue";
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";

export default {
  name: "UnitManager",
  components:{
    GlobalAside,
    GlobalHeader,
  },
  setup() {
    const state = reactive({
      tableData: [
        {
          unitId: 1,
          name: '批量导入部门信息',
          description: '填写Excel表，批量导入部门信息',
        },
        {
          unitId: 2,
          name: '批量导入用户信息',
          description: '填写Excel表，批量导入用户信息',
        },
      ]
    })

    return {
      ...toRefs(state)
    }
  }

}
</script>