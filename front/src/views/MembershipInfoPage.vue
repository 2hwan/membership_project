<template>
	<div>
		<div class="jumbotron">
			<div class="text-white text-center">
				<div>
					<h1><strong>멤버십 안내</strong></h1>
					<p>
						KT 멤버십 등급별 혜택 안내
					</p>
				</div>
			</div>
		</div>
		<div class="outertab">
			<div class="innertab">
				<ul id="tab">
					<li v-on:click="active1st" :class="{ menuactive: onClicked1st }"><a>멤버십 등급</a></li>
					<li v-on:click="active2nd" :class="{ menuactive: onClicked2nd }"><a>멤버십 약관</a></li>
				</ul>
			</div>
		</div>
		<div class="contents">{{ contents }}</div>
	</div>
</template>

<script>
export default {
	name: 'MembershipInfoPage',
	data() {
		return {
			onClicked1st: true,
			onClicked2nd: false,
			contents: '멤버십 등급에 관한 설명',
			contents1: '멤버십 등급에 관한 설명',
			contents2: '멤버십 약관에 대한 설명'
		};
	},
	methods: {
		active1st() {
			this.onClicked1st = true;
			this.onClicked2nd = false;
			this.contents = this.contents1;
		},
		active2nd() {
			this.onClicked2nd = true;
			this.onClicked1st = false;
			this.contents = this.contents2;
		}
	}
};
</script>

<style scoped>
.jumbotron {
	background-image: url('../assets/membershipsignup.jpg');
	background-size: 100%;
	box-shadow: none;
}
.outertab {
	width: 100%;
	text-align: center;
	height: 80px;
}
.innertab {
	display: inline-block;
}
ul li {
	list-style: none;
	float: left;
	display: block;
	border-left: 1px solid #6f7180;
	width: 300px;
	height: 60px;
	color: white;
	font-size: 19px;
	text-align: center;
	line-height: 60px;
	background-color: #7a7c8d;
	box-sizing: border-box;
}

.menuactive {
	border: 4px solid #0d6f9d;
	color: #0d6f9d;
	background-color: white;
}
</style>
