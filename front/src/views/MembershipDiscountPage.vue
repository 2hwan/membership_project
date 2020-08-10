<template>
	<mdb-card class="card-image">
		<div class="jumbotron">
			<div class="text-white text-center">
				<div>
					<h1 class="card-title h1-responsive pt-3 mb-5 font-bold"><strong>멤버십 할인</strong></h1>
					<p class="mx-5 mb-5">
						언제 어디서나 누리는 다양한 할인 혜택
					</p>
				</div>
			</div>
		</div>

		<!--		<mdb-container class="mycontainer">-->
		<mdb-row class="justify-content-center">
			<mdb-btn class="mybtn" outline="primary" @click="filtering('all')"><mdb-icon icon="align-left" /> 전체</mdb-btn>
			<mdb-btn class="mybtn" outline="primary" @click="filtering('영화/공연')"><mdb-icon icon="video" /> 영화/공연</mdb-btn>
			<mdb-btn class="mybtn" outline="primary" @click="filtering('외식')"><mdb-icon icon="utensils" /> 외식</mdb-btn>
			<mdb-btn class="mybtn" outline="primary" @click="filtering('카페')"><mdb-icon icon="coffee" /> 카페</mdb-btn>
			<mdb-btn class="mybtn" outline="primary" @click="filtering('여행/교통')"><mdb-icon icon="plane-departure" /> 여행/교통</mdb-btn>
		</mdb-row>

		<div class="row">
			<div v-for="item in show_items" class="col-3 mt-3" :key="item.name">
				<mdb-card>
					<mdb-card-image class="ml-auto mr-auto" v-bind:src="item.img_path"></mdb-card-image>
					<!--							<img v-bind:src="item.img_path" alt="" />-->
					<mdb-card-body>
						<mdb-card-title class="text-center">{{ item.name }}</mdb-card-title>
						<mdb-card-text class="ml-3">
							<div class="class-benefit">
								<div class="color-vvip" v-if="item.vvip_contents">VVIP</div>
								<h6 v-if="item.vvip_contents">{{ item.vvip_contents }} <br /></h6>
								<div class="color-vip" v-if="item.vip_contents">VIP</div>
								<h6 v-if="item.vip_contents">{{ item.vip_contents }}<br /></h6>
								<div class="color-normal" v-if="item.normal_contents">일반</div>
								<h6 v-if="item.normal_contents">{{ item.normal_contents }}</h6>
							</div>
						</mdb-card-text>
						<mdb-btn class="float-right mr-3" color="primary" @click="usePoint(item)">포인트 사용</mdb-btn>
					</mdb-card-body>
				</mdb-card>
			</div>
		</div>

		<!--		</mdb-container>-->
	</mdb-card>
</template>

<script>
import AddCardModal from '@/components/modal/AddCardModal';
import { mdbContainer, mdbRow, mdbCard, mdbCardImage, mdbCardBody, mdbCardTitle, mdbCardText, mdbBtn, mdbIcon } from 'mdbvue';
import { getItemsInfoList } from '@/api';

export default {
	name: 'MembershipDiscountPage',
	components: {
		// mdbContainer,
		mdbRow,
		mdbCard,
		mdbCardImage,
		mdbCardBody,
		mdbCardTitle,
		mdbCardText,
		mdbBtn,
		mdbIcon
	},
	data() {
		return {
			items: [],
			show_items: [],
			user_class: '일반'
		};
	},
	async mounted() {
		await this.created();
		this.show_items = this.items;
	},
	methods: {
		async created() {
			try {
				const response = await getItemsInfoList();
				if (response.data.status != 200) {
					console.log(response.data.data);
					return;
				}
				this.items = response.data.data.items;
			} catch (e) {
				alert(e);
			}
		},

		filtering(type) {
			console.log(type);
			if (type == 'all') this.show_items = this.items;
			else this.show_items = this.items.filter(item => item.category == type);
		},

		usePoint(item) {
			var message = '[ ' + item.name + ' 할인 내역 ]\n';
			message += ' - 멤버십 등급: ' + this.user_class.toUpperCase() + '\n';
			message += ' - 내용: ';

			if (this.user_class.toUpperCase() == 'VVIP') {
				var benefit = item.vvip_contents != '' ? item.vvip_contents : item.vip_contents != '' ? item.vip_contents : item.normal_contents;
				if (benefit == null) message += '해당 등급 사용 불가';
				else {
					message += benefit;
					message += '\n - 포인트 차감: ' + item.vvip_point + ' P\n';
				}
			} else if (this.user_class.toUpperCase() == 'VIP') {
				var benefit = item.vip_contents != '' ? item.vip_contents : item.normal_contents;
				if (benefit == null) message += '해당 등급 사용 불가';
				else {
					message += benefit;
					message += '\n - 포인트 차감: ' + item.vip_point + ' P\n';
				}
			} else {
				if (item.normal_contents == null) message += '해당 등급 사용 불가';
				else {
					message += item.normal_contents;
					message += '\n - 포인트 차감: ' + item.normal_point + ' P\n';
				}
			}
			alert(message);
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
.pills-rounded .nav-item .nav-link {
	border-radius: 10em;
}
.pills-aqua-gradient .nav-item .nav-link.active {
	background: linear-gradient(40deg, #2096ff, #05ffa3);
}
h6 {
	display: inline;
	margin-left: 10px;
	margin-bottom: 5px;
}
.color-vvip {
	display: inline-block;
	width: 40px;
	height: 23px;
	color: white;
	background: crimson;
	font-weight: bold;
	vertical-align: middle;
	text-align: center;
	margin-bottom: 5px;
}
.color-vip {
	display: inline-block;
	width: 40px;
	height: 23px;
	color: white;
	background: black;
	font-weight: bold;
	vertical-align: middle;
	text-align: center;
	margin-bottom: 5px;
}
.color-normal {
	display: inline-block;
	width: 40px;
	height: 23px;
	color: white;
	background: gray;
	font-weight: bold;
	vertical-align: middle;
	text-align: center;
	margin-bottom: 10px;
}
.class-benefit {
	height: 100px;
	padding-top: 10px;
}
.mybtn {
	width: 15%;
	height: 50px;
	font-size: 12pt;
}
</style>
