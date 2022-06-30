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
        <!--    <el-main>-->
        <el-container>
          <el-header style="height: 300px">
            <el-container style="height: 100%">
              <el-main style="width: 50%;">
                <TaskCard/>
              </el-main>
              <el-main style="width: 50%;">
                <ShortCut/>
              </el-main>
            </el-container>
          </el-header>
          <el-main>
            <MyBudget/>
          </el-main>
        </el-container>
        <!--    </el-main>-->
      </el-main>
    </el-container>
  </el-container>


</template>

<script>
import TaskCard from "@/components/home/TaskCard";
import ShortCut from "@/components/home/ShortCut";
import MyBudget from "@/components/home/MyBudget";
import GlobalAside from "@/components/page/GlobalAside";
import GlobalHeader from "@/components/page/GlobalHeader";
export default {
  name: "HomeDashboard",
  components: {MyBudget, ShortCut, TaskCard,GlobalAside,GlobalHeader},
  setup(){
    const log=()=>{
      console.log('123')
    }
    return{
      log
    }
  }
}
</script>

<style scoped>

</style>