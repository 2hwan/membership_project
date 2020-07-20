import Vue from 'vue';
import Vuex from 'vuex';
import { getToken, getUserId } from '@/utils/cookie';

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		userId: getUserId() || '',
		token: getToken() || ''
	},
	getters: {
		isLogin(state) {
			return state.userId != '';
		}
	},
	mutations: {
		loginUser(state, userData) {
			state.userId = userData.userId;
			state.token = userData.token;
		},
		clearUser(state) {
			state.userId = '';
			state.token = '';
		}
	},
	actions: {},
	modules: {}
});
