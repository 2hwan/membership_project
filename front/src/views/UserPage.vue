<template>
	<mdb-card class="card-image">
		<div class="jumbotron">
			<div class="text-white text-center">
				<div>
					<h1 class="card-title h1-responsive pt-3 mb-5 font-bold"><strong>멤버십 가입</strong></h1>
					<p class="mx-5 mb-5">
						KT 멤버십 혜택을 위한 멤버십 가입 안내
					</p>
					<mdb-btn outline="white" size="md" icon="clone">가입하기</mdb-btn>
				</div>
			</div>
		</div>
		<div class="container">
			zz
		</div>
	</mdb-card>
</template>

<script>
import { mdbCard, mdbBtn } from 'mdbvue';
export default {
	name: 'JumbotronPage',
	components: {
		mdbCard,
		mdbBtn
	}
};
</script>

<style scoped>
.jumbotron {
	background-image: url('../assets/membershipsignup.jpg');
	background-size: 100%;
}
</style>
