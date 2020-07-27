<template>
	<div class="modal fade" style="color: black" id="addCardModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header justify-content-center">
					<h5 class="modal-title" id="exampleModalLabel"><span class="text-center">멤버십 가입</span></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="defaultUnchecked" v-model="check" />
						<label class="custom-control-label" for="defaultUnchecked">멤버십 이용 약관에 동의합니다.</label>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
					<button v-if="check" type="button" class="btn btn-primary" data-dismiss="modal" @click="signUpMembership">가입</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { signUpMembership } from '@/api';

export default {
	name: 'AddCardModal',
	data() {
		return {
			check: false
		};
	},
	methods: {
		checkFlag() {
			this.check = !this.check;
		},
		async signUpMembership() {
			try {
				const response = await signUpMembership(this.$store.state.userId);
				if (response.data.status != 200) {
					alert(response.data.message);
				} else {
					alert('가입되었습니다!');
				}
				this.$router.push('/team6/membership/info');
			} catch (e) {
				console.log(e);
			}
		}
	}
};
</script>

<style scoped></style>
