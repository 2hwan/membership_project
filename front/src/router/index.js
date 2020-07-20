import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '@/store/index';

Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	routes: [
		{
			path: '/',
			component: () => import('@/views/MainPage.vue')
		},
		{
			path: '/login',
			component: () => import('@/views/LoginPage.vue')
		},
		{
			path: '/signup',
			component: () => import('@/views/SignupPage.vue')
			// meta: { auth: true }
		}
	]
});

router.beforeEach((to, from, next) => {
	if (to.meta.auth && !store.getters.isLogin) {
		console.log('로그인을 해주세요!');
		next('/login');
		return;
	}
	next();
});

export default router;
