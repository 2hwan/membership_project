<template>
	<div class="container">
		<div class="row mt-5">
			<div class="col-3"></div>
			<div class="col-6 z-depth-3">
				<form class="px-5">
					<p class="h4 text-center my-5">Login</p>
					<div class="grey-text container">
						<mdb-input label="Your Id" icon="user" type="text" v-model="userId" class="mb-4" />
						<mdb-input label="Your password" icon="lock" type="password" v-model="password" class="mb-4" />
					</div>
					<div class="text-center mb-4">
						<mdb-btn outline="default" darkWaves @click="submitLogin">Login</mdb-btn>
					</div>
				</form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</template>

<script>
import { mdbInput, mdbBtn } from 'mdbvue';
import { loginUser } from '@/api';
import { saveToken, saveUserId } from '@/utils/cookie';
export default {
	name: 'LoginPage',
	components: {
		mdbInput,
		mdbBtn
	},
	data() {
		return {
			userId: '',
			password: ''
		};
	},
	methods: {
		//todo
		validateInput() {},
		async submitLogin() {
			const user = {
				userId: this.userId,
				password: this.password
			};
			try {
				const response = await loginUser(user);
				if (response.data.status != 200) {
					alert(response.data.message);
					return;
				}
				this.setStoreAndCookie(response);
			} catch (e) {
				alert('서버 에러');
			}
		},
		setStoreAndCookie(response) {
			const userId = response.data.data.user.userId;
			const token = response.data.data.token;
			const userData = {
				userId: userId,
				token: token
			};

			this.$store.commit('loginUser', userData);
			saveUserId(userId);
			saveToken(token);
			this.$router.push('/team6');
		}
	}
};
</script>

<style scoped></style>
