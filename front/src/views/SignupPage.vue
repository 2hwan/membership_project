<template>
	<div class="container mt-5">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<mdb-card class="z-depth-3">
					<mdb-card-body>
						<form class="container px-5 ">
							<p class="h4 text-center py-4">Sign up</p>
							<div class="grey-text">
								<mdb-input label="Your Id" icon="user" group type="text" validate error="wrong" success="right" v-model="userId" />
								<mdb-input label="Your email" icon="envelope" group type="email" validate error="wrong" success="right" v-model="email" />
								<mdb-input label="Your name" icon="user" group type="text" validate error="wrong" success="right" v-model="name" />
								<mdb-input label="Your phone number" icon="mobile" group type="text" validate v-model="phoneNumber" />
								<mdb-input label="Your password" icon="lock" group type="password" validate v-model="password" />
								<select class="browser-default custom-select" v-model="callProd">
									<option selected>요금제</option>
									<option value="요금제1">요금제1</option>
									<option value="요금제2">요금제2</option>
									<option value="요금제3">요금제3</option>
								</select>
							</div>
							<div class="text-center py-4 mt-3">
								<mdb-btn color="cyan" @click="signupUser">Register</mdb-btn>
							</div>
						</form>
					</mdb-card-body>
				</mdb-card>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</template>

<script>
import { mdbInput, mdbBtn, mdbCard, mdbCardBody } from 'mdbvue';
import { signupUser } from '@/api';
export default {
	name: 'Basic',
	components: {
		mdbInput,
		mdbBtn,
		mdbCard,
		mdbCardBody
	},
	data() {
		return {
			userId: '',
			email: '',
			name: '',
			phoneNumber: '',
			password: '',
			callProd: ''
		};
	},
	methods: {
		//todo
		validInput() {},
		async signupUser() {
			const userData = {
				userId: this.userId,
				email: this.email,
				name: this.name,
				phoneNumber: this.phoneNumber,
				password: this.password,
				callProd: this.callProd
			};
			try {
				const response = await signupUser(userData);
				if (response.data.status != 200) {
					alert(response.data.message);
					return;
				}
				this.$router.push('/');
				alert('환영합니다.');
			} catch (e) {
				alert(e);
			}
		}
	}
};
</script>

<style scoped></style>
