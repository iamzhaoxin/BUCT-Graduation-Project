<template>
  <div>
    <div class="header">
      <el-row>
        <el-col :span="4">
          <el-button type="primary" @click="handleSolve">添加部门</el-button>
        </el-col>
        <el-col :span="4">
          <el-popover
              placement="bottom"
              title="Title"
              :width="200"
              trigger="hover"
              content="请严格按照模板Excel填写导入"
          >
            <template #reference>
              <el-upload
                  accept=".xls,.xlsx"
                  class="upload-demo"
                  action="/api/user/upload"
                  :limit="1"
                  :on-success="uploadSuccessHandler"
                  :on-error="uploadErrorHandler">
                <el-button type="primary">批量导入部门</el-button>
              </el-upload>
            </template>
          </el-popover>
        </el-col>
      </el-row>
    </div>

    <el-divider/>

    <el-table
        :data="tableData"
        style="width: 100%; margin-bottom: 20px"
        row-key="unitId"
        border
        default-expand-all
    >
      <el-table-column prop="unitId" label="部门编号" sortable/>
      <el-table-column prop="unitName" label="部门名称" sortable/>
      <el-table-column prop="unitSupper" label="上级部门" sortable/>
      <el-table-column prop="principalId" label="部门负责人工号" sortable/>
      <el-table-column prop="principalName" label="部门负责人姓名" sortable/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">修改</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
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
          unitName: '测试部门1',
          unitSupper: '北京化工大学',
          principalId: "2018040436",
          principalName: "赵鑫",
        },
        {
          unitId: 2,
          unitName: '测试部门2',
          unitSupper: '北京化工大学',
          principalId: "2018040436",
          principalName: "赵鑫",
        },
        {
          unitId: 3,
          unitName: '测试部门3',
          unitSupper: '北京化工大学',
          principalId: "2018040436",
          principalName: "赵鑫",
          children: [
            {
              unitId: 31,
              unitName: '测试部门31',
              unitSupper: '测试部门3',
              principalId: "2018040436",
              principalName: "赵鑫",
            },
            {
              unitId: 32,
              unitName: '测试部门32',
              unitSupper: '测试部门3',
              principalId: "2018040436",
              principalName: "赵鑫",
            },
            {
              unitId: 33,
              unitName: '测试部门33',
              unitSupper: '测试部门3',
              principalId: "2018040436",
              principalName: "赵鑫",
            },
            {
              unitId: 34,
              unitName: '测试部门34',
              unitSupper: '测试部门3',
              principalId: "2018040436",
              principalName: "赵鑫",
            },
          ],
        },
        {
          unitId: 4,
          unitName: '测试部门4',
          unitSupper: '北京化工大学',
          principalId: "2018040436",
          principalName: "赵鑫",
        },
      ]
    })

    return {
      ...toRefs(state)
    }
  }

}
</script>