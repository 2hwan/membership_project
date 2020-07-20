import store from '@/store/index';

export function setInterceptors(instance) {
	instance.interceptors.request.use(
		function(config) {
			config.headers.Authorization = store.state.token;
			return config;
		},
		function(error) {
			return error;
		}
	);
	return instance;
}
