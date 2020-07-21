import axios from 'axios';
import { setInterceptors } from '@/api/interceptors';

function createInstance() {
	const instance = axios.create({
		baseURL: 'http://localhost:8080/team6'
	});
	return setInterceptors(instance);
}

const instance = createInstance();

export function signupUser(userData) {
	return instance.post('signup', userData);
}

export function loginUser(userData) {
	return instance.post('login', userData);
}
