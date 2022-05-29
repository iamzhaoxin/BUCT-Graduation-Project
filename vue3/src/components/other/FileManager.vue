<template>

  <div style="font-size: 30px">附件下载</div>

  <el-divider/>

  <el-table
      :data="tableData"
      style="width: 100%; margin-bottom: 20px"
      row-key="unitId"
      border
      default-expand-all
  >
    <el-table-column prop="name" label="文件名称" />
    <el-table-column prop="description" label="说明" />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)">下载</el-button>
      </template>
    </el-table-column>
  </el-table>

</template>
<script>
import {reactive, toRefs} from "vue";

export default {
  name: "UnitManager",
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