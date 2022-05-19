<template>
  <div class="tree-demo">
    <el-divider content-position="left">一个完整的树应用demo</el-divider>
    <el-row style="background: #f0f3f6; padding: 20px;" :gutter="20">
      <el-col :span="10" style="height: 100%;">
        <div>
          <ul class="desc-list">
            <li>样式已初步编写，可直接应用</li>
            <li>el-tree的滚动条出现及样式</li>
            <li>限制节点宽度，超出省略号并添加title</li>
            <li>节点前图标及样式</li>
            <li>支持关键字筛选树</li>
            <li>默认选中根节点</li>
            <li>可进行节点添加、编辑、删除</li>
            <li>支持默认展开N级树</li>
            <li>可根据实际需要增删功能</li>
          </ul>
        </div>
      </el-col>
      <el-col :span="14">
        <div style="background: #fff; padding: 20px;">
          <p class="instructions" v-html="operateText"></p>
          <el-input
              v-model="filterText"
              class="filter-input"
              placeholder="输入关键字过滤"
          />
          <div class="tree-panel">
            <el-tree
                ref="treeDom"
                class="byui-filter-tree"
                node-key="treeNode"
                :data="treeData"
                :default-expanded-keys="defaultExpendedKeys"
                :current-node-key="selectedNodeId"
                :expand-on-click-node="false"
                :highlight-current="true"
                :props="defaultProps"
                :filter-node-method="filterNode"
                @node-click="nodeClick"
                @node-collapse="nodeCollapse"
                @node-expand="nodeExpand"
            >
              <template  #default="{ node, data }">
                <span class="byui-custom-tree-node">
                <span class="byui-tree-item">
                  <i class="el-icon-s-custom byui-tree-icon"></i>
                  <!--<img class="tree-icon" src="@/assets/equipment/police_icon.jpg" />这里可以设置自定义的树图标-->
                  <span
                      class="byui-tree-name byui-text-ellipsis"
                      :title="node.label"
                  >{{ node.label }}</span
                  >
                </span>
                <span class="byui-tree-options">
                  <a
                      class="byui-tree-btn"
                      title="添加"
                      @click.stop="() => append(node, data, 0)"
                  ><i class="el-icon-plus"></i
                  ></a>
                  <a
                      class="byui-tree-btn"
                      title="编辑"
                      @click.stop="() => edit(node, data, 1)"
                  ><i class="el-icon-edit"></i
                  ></a>
                  <a
                      class="byui-tree-btn"
                      title="刪除"
                      @click.stop="() => remove(node, data)"
                  ><i class="el-icon-delete"></i
                  ></a>
                </span>
                </span>
              </template >
            </el-tree>
          </div>
          <p class="tips-txt">
            注意：node-key="treeNode",具体根据自己的树形数据里id字段的名称进行设置
          </p>
          <p class="tips-txt">
            defaultProps的设置也是需要根据实际数据结构灵活设置
          </p>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "UnitManager",
  data() {
    return {
      operateText: "操作说明：",
      filterText: "", // 过滤字段
      treeData: [], // 树的数据
      defaultExpendedKeys: [], // 默认展开的节点
      selectedNodeId: "", // 当前选中的节点id
      defaultProps: {
        children: "children",
        label: "name",
      },
    };
  },
  watch: {
    filterText(val) {
      this.$refs["treeDom"].filter(val);
    },
  },
  mounted() {
    // 获取tree数据
    this.getTreeData(1, 3);
  },
  methods: {
    // 获取tree数据：flag-是否默认展开N级，openLevel-默认展开几级
    getTreeData(flag, openLevel) {
      const that = this;
      const treeData = [
        {
          children: [
            {
              children: [
                {
                  children: [],
                  createTime: 1589861087000,
                  name: "刑侦大队",
                  parentTreeNode: "17689bc5b0854c69b1c55e82d7deab21",
                  treeNode: "80584014bada441dbc75bf16b79739b0",
                  updateTime: 1589861087000,
                },
                {
                  children: [],
                  createTime: 1589861107000,
                  name: "测试",
                  parentTreeNode: "17689bc5b0854c69b1c55e82d7deab21",
                  treeNode: "aa391618b3234f4ab1db377738405327",
                  updateTime: 1589861107000,
                },
                {
                  children: [
                    {
                      children: [],
                      createTime: 1589881022000,
                      name:
                          "名字很长很长名字很长很长名字很长很长名字很长很长名字很长很长名字很长很长",
                      parentTreeNode: "9be70e1bdb2d4d90ba1996759e1f265a",
                      treeNode: "19cf5698812c46219bf218340981bfe2",
                      updateTime: 1589881022000,
                    },
                  ],
                  createTime: 1589870539000,
                  name: "测试222",
                  parentTreeNode: "17689bc5b0854c69b1c55e82d7deab21",
                  treeNode: "9be70e1bdb2d4d90ba1996759e1f265a",
                  updateTime: 1589870539000,
                },
                {
                  children: [],
                  createTime: 1589890533000,
                  name: "导入测试",
                  parentTreeNode: "17689bc5b0854c69b1c55e82d7deab21",
                  treeNode: "406997f3bf774d5c8060fe32086f077b",
                  updateTime: 1589890533000,
                },
                {
                  children: [
                    {
                      children: [],
                      createTime: 1589891776000,
                      name: "对对对",
                      parentTreeNode: "0b4523ce75724dfcbd9e8418b7807ca0",
                      treeNode: "7c717a7c960d4488ad4b82f1c340ba62",
                      updateTime: 1589891776000,
                    },
                  ],
                  createTime: 1589891699000,
                  name: "导入测试2",
                  parentTreeNode: "17689bc5b0854c69b1c55e82d7deab21",
                  treeNode: "0b4523ce75724dfcbd9e8418b7807ca0",
                  updateTime: 1589891699000,
                },
              ],
              createTime: 1589861049000,
              name: "经济技术开发区分局",
              parentTreeNode: "7563a288f1544a89ae8e9faf9c46afa3",
              treeNode: "17689bc5b0854c69b1c55e82d7deab21",
              updateTime: 1589861049000,
            },
            {
              children: [
                {
                  children: [],
                  createTime: 1589871025000,
                  name: "测试",
                  parentTreeNode: "b0a9886895b1493a84c69f0564d72036",
                  treeNode: "9eb4dc33e08b4366a2a7f5ac4c646f17",
                  updateTime: 1589871025000,
                },
                {
                  children: [],
                  createTime: 1589891784000,
                  name: "对对对达到11",
                  parentTreeNode: "b0a9886895b1493a84c69f0564d72036",
                  treeNode: "13007473c99742c886412f0256ec1a15",
                  updateTime: 1589891784000,
                },
                {
                  children: [],
                  createTime: 1589891788000,
                  name: "顶顶顶顶",
                  parentTreeNode: "b0a9886895b1493a84c69f0564d72036",
                  treeNode: "f978c56dcdff45829e5ee7e14db85afe",
                  updateTime: 1589891788000,
                },
              ],
              createTime: 1589861071000,
              name: "高新技术开发区分局",
              parentTreeNode: "7563a288f1544a89ae8e9faf9c46afa3",
              treeNode: "b0a9886895b1493a84c69f0564d72036",
              updateTime: 1589861071000,
            },
            {
              children: [],
              createTime: 1589876333000,
              name: "wzp",
              parentTreeNode: "7563a288f1544a89ae8e9faf9c46afa3",
              treeNode: "197cb3179aca4294ad0f1317b266a7ba",
              updateTime: 1589876333000,
            },
          ],
          createTime: 1575129600000,
          name: "资源中心",
          parentTreeNode: "0",
          treeNode: "7563a288f1544a89ae8e9faf9c46afa3",
          updateTime: 1575129600000,
        },
      ];
      that.treeData = treeData;
      that.selectedNodeId = treeData[0].treeNode; // 默认根节点选中状态
      if (flag) {
        that.openTree(that.treeData, openLevel);
      }
      that.$nextTick(() => {
        that.$refs["treeDom"].setCurrentKey(that.selectedNodeId);
      });
    },
    // 树节点展开n级方法
    openTree(treeData, n) {
      const that = this;
      function each(data, rank) {
        if (rank <= n) {
          data.forEach((e) => {
            that.$set(
                that.defaultExpendedKeys,
                that.defaultExpendedKeys.length,
                e.treeNode
            );
            if (e.children.length > 0) {
              each(e.children, rank + 1);
            }
          });
        }
      }
      each(treeData, 1);
    },
    // 节点过滤操作
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    // 添加节点操作
    // append(node, data, flag) {
    append(node, data) {
      this.operateText =
          "操作说明：在<span>" +
          data.name +
          "(treeNode='" +
          data.treeNode +
          "')</span>节点下添加节点操作";
    },
    // 编辑节点操作
    edit(node, data) {
      this.operateText =
          "操作说明：对<span>" +
          data.name +
          "(treeNode='" +
          data.treeNode +
          "')</span>节点进行编辑操作";
    },
    // 删除节点操作
    remove(node, data) {
      const that = this;
      if (node.parent.data[0]) {
        that.$message({
          message: "树根节点不允许删除操作！",
          type: "warning",
        });
      } else {
        that.operateText =
            "操作说明：对<span>" +
            data.name +
            "(treeNode='" +
            data.treeNode +
            "')</span>节点进行删除操作";
      }
    },
    // 点击叶子节点
    // nodeClick(data, node, el) {
    nodeClick(data) {
      const that = this;
      that.selectedNodeId = data.treeNode;
      that.operateText =
          "操作说明：选中节点<span>" +
          data.name +
          "(treeNode='" +
          data.treeNode +
          "')</span>";
    },
    // 节点展开操作
    nodeExpand(data) {
      this.defaultExpendedKeys.push(data.treeNode);
    },
    // 节点关闭操作
    nodeCollapse(data) {
      this.defaultExpendedKeys.splice(
          this.defaultExpendedKeys.findIndex(
              (item) => item.treeNode === data.treeNode
          ),
          1
      );
    },
  },
};
</script>

<style scoped lang="scss">
.tree-demo {
  padding: 20px;

  .desc-list {
    padding-left: 20px;
    line-height: 30px;
    font-size: 14px;
    color: #304455;
    list-style-type: disc;
  }

  .instructions {
    font-size: 14px;
    padding: 15px 0;
    color: #606266;
  }

  .tips-txt {
    margin-top: 20px;
    font-size: 12px;
    color: #c0ccda;
  }

  .filter-input {
    width: 250px;
    margin-bottom: 10px;
  }
  .tree-panel {
    width: 250px;
    height: 300px;
    border: 1px solid #efefef;
    overflow: auto;

    /* 树形组件开始 */
    .byui-filter-tree {
      min-width: 100%;
      display: inline-block;
      margin-top: 0;
      margin-bottom: 20px;
    }

    .byui-custom-tree-node {
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: space-between;
      //font-size: $base-font-size-default;
      padding-left: 5px;
      padding-right: 8px;
      .byui-tree-icon {
        margin-right: 4px;
        vertical-align: middle;
      }
    }

    .byui-tree-name {
      display: inline-block;
      max-width: 150px;
      vertical-align: middle;
    }

    .byui-tree-options {
      visibility: hidden;

      .byui-tree-btn {
        color: #666;
        margin-right: 5px;

        &:hover {
          //color: $base-color-default;
        }
      }
    }

    .el-tree-node {
      &__content:hover {
        .byui-tree-options {
          visibility: inherit;
        }

        .byui-tree-item {
          //color: $base-color-default;
          margin-right: 8px;
        }
      }
    }

    .is-current {
      > .el-tree-node {
        &__content {
          .byui-tree-item {
            //color: $base-color-default;
          }
        }
      }
    }

    /* 树形组件结束 */
  }
}
</style>
<style lang="scss">
.tree-demo {
  .instructions {
    span {
      color: #1890ff;
    }
  }
}
* {
  margin: 0;
  padding: 0;
}

.byui-text-ellipsis {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

/* 滚动条样式 */
::-webkit-scrollbar {
  width: 5px;
  height: 5px;
  background: transparent;
}

::-webkit-scrollbar-thumb {
  background: rgba(144, 147, 153, 0.3);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
  background: rgba(144, 147, 153, 0.5);
}

/*IE滚动条颜色*/
html {
  scrollbar-face-color: #999; /*滚动条颜色*/
  scrollbar-highlight-color: #000;
  scrollbar-3dlight-color: #000;
  scrollbar-darkshadow-color: #000;
  scrollbar-shadow-color: #999; /*滑块边色*/
  scrollbar-arrow-color: rgba(0, 0, 0, 0.4); /*箭头颜色*/
  scrollbar-track-color: #eeeeee; /*背景颜色*/
}
</style>