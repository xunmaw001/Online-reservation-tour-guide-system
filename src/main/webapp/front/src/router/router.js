import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import daoyouList from '../pages/daoyou/list'
import daoyouDetail from '../pages/daoyou/detail'
import daoyouAdd from '../pages/daoyou/add'
import lvyouxindeList from '../pages/lvyouxinde/list'
import lvyouxindeDetail from '../pages/lvyouxinde/detail'
import lvyouxindeAdd from '../pages/lvyouxinde/add'
import lvyoujingdianList from '../pages/lvyoujingdian/list'
import lvyoujingdianDetail from '../pages/lvyoujingdian/detail'
import lvyoujingdianAdd from '../pages/lvyoujingdian/add'
import lvyouxianluList from '../pages/lvyouxianlu/list'
import lvyouxianluDetail from '../pages/lvyouxianlu/detail'
import lvyouxianluAdd from '../pages/lvyouxianlu/add'
import yuyuedingdanList from '../pages/yuyuedingdan/list'
import yuyuedingdanDetail from '../pages/yuyuedingdan/detail'
import yuyuedingdanAdd from '../pages/yuyuedingdan/add'
import jingdianfenleiList from '../pages/jingdianfenlei/list'
import jingdianfenleiDetail from '../pages/jingdianfenlei/detail'
import jingdianfenleiAdd from '../pages/jingdianfenlei/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'daoyou',
					component: daoyouList
				},
				{
					path: 'daoyouDetail',
					component: daoyouDetail
				},
				{
					path: 'daoyouAdd',
					component: daoyouAdd
				},
				{
					path: 'lvyouxinde',
					component: lvyouxindeList
				},
				{
					path: 'lvyouxindeDetail',
					component: lvyouxindeDetail
				},
				{
					path: 'lvyouxindeAdd',
					component: lvyouxindeAdd
				},
				{
					path: 'lvyoujingdian',
					component: lvyoujingdianList
				},
				{
					path: 'lvyoujingdianDetail',
					component: lvyoujingdianDetail
				},
				{
					path: 'lvyoujingdianAdd',
					component: lvyoujingdianAdd
				},
				{
					path: 'lvyouxianlu',
					component: lvyouxianluList
				},
				{
					path: 'lvyouxianluDetail',
					component: lvyouxianluDetail
				},
				{
					path: 'lvyouxianluAdd',
					component: lvyouxianluAdd
				},
				{
					path: 'yuyuedingdan',
					component: yuyuedingdanList
				},
				{
					path: 'yuyuedingdanDetail',
					component: yuyuedingdanDetail
				},
				{
					path: 'yuyuedingdanAdd',
					component: yuyuedingdanAdd
				},
				{
					path: 'jingdianfenlei',
					component: jingdianfenleiList
				},
				{
					path: 'jingdianfenleiDetail',
					component: jingdianfenleiDetail
				},
				{
					path: 'jingdianfenleiAdd',
					component: jingdianfenleiAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
