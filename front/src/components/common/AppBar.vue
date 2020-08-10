<template>
	<mdb-navbar color="aqua-gradient" dark container class="z-depth-0">
		<mdb-navbar-brand>
			<router-link to="/team6" style="color: white"><img src="@/assets/ktmark.png" width="40px" alt=""/></router-link>
		</mdb-navbar-brand>
		<mdb-navbar-toggler>
			<mdb-navbar-nav right>
				<mdb-dropdown tag="li" class="nav-item">
					<mdb-dropdown-toggle tag="a" navLink color="aqua-gradient" slot="toggle" waves-fixed>
						<span class="mx-1" href="#" style="font-size: 20px;font-weight: bold">멤버십</span>
					</mdb-dropdown-toggle>
					<mdb-dropdown-menu class="text-center">
						<mdb-dropdown-item><router-link to="/team6/membership/info">멤버십 안내</router-link></mdb-dropdown-item>
						<mdb-dropdown-item><router-link to="/team6/membership/signup">멤버십 가입</router-link></mdb-dropdown-item>
						<mdb-dropdown-item><router-link to="/team6/membership/discount">멤버십 할인</router-link></mdb-dropdown-item>
						<mdb-dropdown-item><router-link to="/team6/membership/faq">FAQ</router-link></mdb-dropdown-item>
					</mdb-dropdown-menu>
				</mdb-dropdown>
				<template v-if="!isUserLogin">
					<mdb-nav-item class="mx-3" href="#" style="font-size: 20px;font-weight: bold"><router-link to="/team6/login" style="color: white">로그인</router-link></mdb-nav-item>
					<mdb-nav-item class="mx-3" href="#" style="font-size: 20px;font-weight: bold"><router-link to="/team6/signup" style="color: white">회원가입</router-link></mdb-nav-item>
				</template>
				<template v-else>
					<mdb-nav-item class="mx-3" href="#" style="font-size: 20px;font-weight: bold" @click="logoutUser">로그아웃</mdb-nav-item>
					<mdb-nav-item class="mx-3" href="#" style="font-size: 20px;font-weight: bold"><router-link to="/team6/users" style="color: white">마이페이지</router-link></mdb-nav-item>
				</template>
			</mdb-navbar-nav>
		</mdb-navbar-toggler>
	</mdb-navbar>
</template>

<script>
import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbDropdown, mdbDropdownMenu, mdbDropdownToggle, mdbDropdownItem } from 'mdbvue';
import { deleteCookie } from '@/utils/cookie';
export default {
	name: 'NavbarPage',
	components: {
		mdbNavbar,
		mdbNavbarBrand,
		mdbNavbarToggler,
		mdbNavbarNav,
		mdbNavItem,
		mdbDropdown,
		mdbDropdownMenu,
		mdbDropdownToggle,
		mdbDropdownItem
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
			this.$router.push('/team6/login');
		}
	}
};
</script>

<style scoped></style>
