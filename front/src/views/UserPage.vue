<template>
	<div>마이페이지</div>
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
