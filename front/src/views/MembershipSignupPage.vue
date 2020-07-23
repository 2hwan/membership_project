<template>
	<mdb-card class="card-image">
		<div class="jumbotron">
			<div class="text-white text-center">
				<div>
					<h1 class="card-title h1-responsive pt-3 mb-5 font-bold"><strong>멤버십 가입</strong></h1>
					<p class="mx-5 mb-5">
						KT 멤버십 혜택을 위한 멤버십 가입 안내
					</p>
					<AddCardModal></AddCardModal>
					<mdb-btn outline="white" size="md" icon="clone" data-toggle="modal" data-target="#addCardModal">가입하기</mdb-btn>
				</div>
			</div>
		</div>
		<div class="container">
			<h2 class="text-center mt-5 mb-3" style="font-weight: bold">가입 프로세스 안내</h2>
			<img src="../assets/signupstep.gif" alt="" />
		</div>
	</mdb-card>
</template>

<script>
import { mdbCard, mdbBtn } from 'mdbvue';
import AddCardModal from '@/components/modal/AddCardModal';
export default {
	name: 'MembershipSignupPage',
	components: {
		AddCardModal,
		mdbCard,
		mdbBtn
	}
};
</script>

<style scoped>
.jumbotron {
	background-image: url('../assets/membershipsignup.jpg');
	background-size: 100%;
	box-shadow: none;
}
</style>
