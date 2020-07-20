export function saveUserId(value) {
	document.cookie = `userId=${value}`;
}

export function getUserId() {
	return document.cookie.replace(/(?:(?:^|.*;\s*)userId\s*=\s*([^;]*).*$)|^.*$/, '$1');
}

export function saveToken(value) {
	document.cookie = `token=${value}`;
}

export function getToken() {
	return document.cookie.replace(/(?:(?:^|.*;\s*)token\s*=\s*([^;]*).*$)|^.*$/, '$1');
}

export function deleteCookie(value) {
	document.cookie = `${value}=; expires=Thu, 01 Jan 1970 00:00:01 GMT;`;
}
