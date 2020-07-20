<template>
	<mdb-navbar color="default" dark container class="mb-4">
		<mdb-navbar-brand>
			<span style="font-size:30px"><router-link to="/" style="color: white">K T</router-link></span>
		</mdb-navbar-brand>
		<mdb-navbar-toggler>
			<mdb-navbar-nav right>
				<template v-if="!isUserLogin">
					<mdb-nav-item class="mx-2" href="#" style="font-size: 20px;font-weight: bold"> <router-link to="/membership" style="color: white">멤버쉽</router-link></mdb-nav-item>
					<mdb-nav-item class="mx-2" href="#" style="font-size: 20px;font-weight: bold"><router-link to="/login" style="color: white">로그인</router-link></mdb-nav-item>
					<mdb-nav-item class="mx-2" href="#" style="font-size: 20px;font-weight: bold"><router-link to="/signup" style="color: white">회원가입</router-link></mdb-nav-item>
				</template>
				<template v-else>
					<mdb-nav-item class="mx-2" href="#" style="font-size: 20px;font-weight: bold" @click="logoutUser">로그아웃</mdb-nav-item>
				</template>
			</mdb-navbar-nav>
		</mdb-navbar-toggler>
	</mdb-navbar>
</template>

<script>
import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem } from 'mdbvue';
import { deleteCookie } from '@/utils/cookie';
export default {
	name: 'NavbarPage',
	components: {
		mdbNavbar,
		mdbNavbarBrand,
		mdbNavbarToggler,
		mdbNavbarNav,
		mdbNavItem
	},
	computed: {
		isUserLogin() {
			return this.$store.getters.isLogin;
		}
	},
	methods: {
		logoutUser() {
			this.$store.commit('clearUser');
			deleteCookie('userId');
			deleteCookie('token');
			this.$router.push('/login');
		}
	}
};
</script>

<style scoped></style>
