<template>
	<div class="text-center">
		<h1>{{ name }}</h1>
		<button class="button-my" v-on:click="changeName">click</button>
		<button v-on:click="addNumber">click</button><input type="text" v-model="data" @blur="alertData" />
		<div v-for="(l, index) in list" :key="index">
			{{ l }}
		</div>
	</div>
</template>

<script>
export default {
	name: 'NotFoundPage',
	data() {
		return {
			name: '',
			data: '',
			list: [1, 2, 3, 3242315, 3]
		};
	},
	methods: {
		addNumber() {
			this.list.push(5);
		},
		changeName() {
			this.name = '윤성재';
		},
		alertData() {
			console.log(this.data);
		}
	}
};
</script>

<style scoped>
.button-my {
	color: red;
}
</style>
