import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '@/store/index';

Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	routes: [
		{
			path: '/team6',
			component: () => import('@/views/MainPage.vue')
		},
		{
			path: '/team6/login',
			component: () => import('@/views/LoginPage.vue')
		},
		{
			path: '/team6/signup',
			component: () => import('@/views/SignupPage.vue')
			// meta: { auth: true }
		},
		{
			path: '/team6/users',
			component: () => import('@/views/UserPage.vue'),
			meta: { auth: true }
		},
		{
			path: '/team6/membership/info',
			component: () => import('@/views/MembershipInfoPage.vue')
		},
		{
			path: '/team6/membership/signup',
			component: () => import('@/views/MembershipSignupPage.vue')
		},
		{
			path: '/team6/membership/discount',
			component: () => import('@/views/MembershipDiscountPage.vue')
		},
		{
			path: '/team6/membership/movie',
			component: () => import('@/views/MembershipMoviePage.vue'),
			meta: { auth: true }
		},
		{
			path: '/team6/membership/faq',
			component: () => import('@/views/MembershipFagPage.vue')
		},
		{
			path: '*',
			component: () => import('@/views/NotFoundPage.vue')
		}
	]
});

router.beforeEach((to, from, next) => {
	if (to.meta.auth && !store.getters.isLogin) {
		console.log('로그인을 해주세요!');
		next('/team6/login');
		return;
	}
	next();
});

export default router;
