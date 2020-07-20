<template>
	<div class="container mt-5" style="height: 50%">
		<mdb-carousel :interval="8000" slide :items="items" controlls style="height: 50%"></mdb-carousel>
	</div>
</template>

<script>
import { mdbCarousel } from 'mdbvue';
export default {
	name: 'MainPage',
	components: {
		mdbCarousel
	},
	data() {
		return {
			items: [
				{
					img: true,
					src: 'https://zone.membership.kt.com/event/DoubleDiscount/img/2007/visual.jpg'
				}
			]
		};
	}
};
</script>
