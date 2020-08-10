import axios from 'axios';
import { setInterceptors } from '@/api/interceptors';

function createInstance() {
	const instance = axios.create({
		baseURL: 'http://localhost:8080/team6'
	});
	return setInterceptors(instance);
}

const instance = createInstance();

export function signUpUser(userData) {
	return instance.post('signup', userData);
}

export function loginUser(userData) {
	return instance.post('login', userData);
}

export function signUpMembership(userId) {
	return instance.get('membership/signup/' + userId);
}

export function getItemsInfoList() {
	return instance.get('items/info');
}
