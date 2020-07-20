<template>
	<div id="app">
		<AppBar></AppBar>
		<router-view />
	</div>
</template>

<style>
@import url('https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap');
</style>
<script>
import AppBar from '@/components/common/AppBar';
export default {
	components: { AppBar }
};
</script>
