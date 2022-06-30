import {createRouter, createWebHashHistory} from 'vue-router'
import {localGet} from "@/utils";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            redirect: 'login'
        },
        // 登陆
        {
            path: '/login',
            name: 'login',
            component: () => import('../components/login/UserLogin')
        },
        // 首页
        {
            path: '/home',
            name: 'home',
            component: () => import('../components/home/HomeDashboard')
        },
        // 申请管理-新增申请
        {
            path: '/budget/increase',
            name: 'increaseBudget',
            component: () => import('../components/budget/BudgetPage')
        },
        // 申请管理-在途申请
        {
            path: '/budget/manager',
            name: 'managerBudget',
            component: () => import('../components/budget/BudgetManagerPage')
        },
        // 申请审核-待审
        {
            path: '/budget/budgetAudit/wait',
            name: 'BudgetAuditWait',
            component: () => import('../components/budget/BudgetAuditWaitPage')
        },
        // 申请审核-审结
        {
            path: '/budget/budgetAudit/finished',
            name: 'BudgetAuditFinished',
            component: () => import('../components/budget/BudgetAuditFinishedPage')
        },
        // 申请查询-个人
        {
            path: '/budget/budgetAudit/myaudit',
            name: 'BudgetAuditMy',
            component: () => import('../components/budget/BudgetAuditMyPage')
        },
        // 部门管理-职能
        {
            path: '/unit/manager',
            name: 'unitManager',
            component: () => import('../components/unit/UnitManager')
        },
        {
            path: '/user/manager',
            name: 'userManager',
            component: () => import('../components/user/UserPage')
        },
        {
            path: '/flow/design',
            name: 'flowDesign',
            component: () => import('../components/flow/FlowManager')
        },
        {
          path: '/file',
            name:'fileDownload',
            component:()=>import('../components/other/FileManager')
        },
    ],
})

// 未登录则跳转到登录页
router.beforeEach((to, from, next) => {
    // console.log(from.path)
    // console.log(to.path)
    let token = localGet(`token`)
    if (token === null || token.userId === null) {
        if (to.path === '/login') {
            next();
        } else {
            next({path: '/login'})
        }
    }
    if (token && token.userId) {
        // 如果已登录，跳过登陆页
        if (to.path === '/login') {
            next({path: '/home'})
        }
        next();
    }
})



export default router