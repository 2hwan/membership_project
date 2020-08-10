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

		<mdb-container>
			<mdb-tabs
				:active="0"
				justify
				:links="[
					{ text: '전체', icon: 'ellipsis-h', slot: 'total' },
					{ text: '영화/공연', icon: 'video' },
					{ text: '외식', icon: 'utensils' },
					{ text: '카페', icon: 'coffee' },
					{ text: '여행/교통', icon: 'plane' }
				]"
				:transition-duration="0.5"
				transition-style="linear"
			>
				<template :slot="'total'">
					<div class="row">
						<div v-for="item in items" class="col-3 mt-3" :key="item.name">
							<mdb-card>
								<mdb-card-image class="ml-auto mr-auto" v-bind:src="item.img_path"></mdb-card-image>
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
				</template>
			</mdb-tabs>
		</mdb-container>
	</mdb-card>
</template>

<script>
import AddCardModal from '@/components/modal/AddCardModal';
import { mdbCard, mdbCardImage, mdbCardBody, mdbCardTitle, mdbCardText, mdbBtn, mdbTabs } from 'mdbvue';
import { getItemsInfoList } from '@/api';

export default {
	name: 'MembershipDiscountPage',
	components: {
		mdbCard,
		mdbCardImage,
		mdbCardBody,
		mdbCardTitle,
		mdbCardText,
		mdbBtn,
		mdbTabs
	},
	data() {
		return {
			items: [
				{
					name: 'CGV',
					img_path: 'https://membership.kt.com/pc/images/ollehktclub/event/banner/0001_CGV.png',
					vvip_contents: '1Day 무비패스',
					vip_contents: '영화예매 무료',
					normal_contents: '최대 8000원 할인(동반1인 포함시)',
					vvip_point: 12000,
					vip_point: 12000,
					normal_point: 8000,
					month_count: 1
				},
				{
					name: '롯데시네마',
					img_path: 'https://membership.kt.com/pc/images/ollehktclub/event/banner/club/195x98_%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88_%EC%9B%B9.png',
					vvip_contents: '',
					vip_contents: '영화예매 무료',
					normal_contents: '최대 7000원 할인(동반1인 포함시)',
					vvip_point: 12000,
					vip_point: 12000,
					normal_point: 7000,
					month_count: 1
				},
				{
					name: '메가박스',
					img_path: 'https://membership.kt.com/pc/images/ollehktclub/event/banner/club/megaboxnew.png',
					vvip_contents: '',
					vip_contents: '영화예매 무료',
					normal_contents: '',
					vvip_point: 12000,
					vip_point: 12000,
					normal_point: 0,
					month_count: 1
				},
				{
					name: '메가박스',
					img_path: 'https://membership.kt.com/pc/images/ollehktclub/event/banner/club/megaboxnew.png',
					vvip_contents: '',
					vip_contents: '영화예매 무료',
					normal_contents: '',
					vvip_point: 12000,
					vip_point: 12000,
					normal_point: 0,
					month_count: 1
				},
				{
					name: '메가박스',
					img_path: 'https://membership.kt.com/pc/images/ollehktclub/event/banner/club/megaboxnew.png',
					vvip_contents: '',
					vip_contents: '영화예매 무료',
					normal_contents: '',
					vvip_point: 12000,
					vip_point: 12000,
					normal_point: 0,
					month_count: 1
				}
			],
			user_class: '일반'
		};
	},
	methods: {
		async getItems() {
			const response = await getItemsInfoList();
		},
		usePoint(item) {
			var message = '[ ' + item.name + ' 할인 내역 ]\n';
			message += ' - 멤버십 등급: ' + this.user_class.toUpperCase() + '\n';
			message += ' - 내용: ';

			if (this.user_class.toUpperCase() == 'VVIP') {
				var benefit = item.vvip_contents != '' ? item.vvip_contents : item.vip_contents != '' ? item.vip_contents : item.normal_contents;
				message += benefit;
				message += '\n - 포인트 차감: ' + item.vvip_point + ' P\n';
			} else if (this.user_class.toUpperCase() == 'VIP') {
				var benefit = item.vip_contents != '' ? item.vip_contents : item.normal_contents;
				if (benefit == '') message += '해당 등급 사용 불가';
				else {
					message += benefit;
					message += '\n - 포인트 차감: ' + item.vip_point + ' P\n';
				}
			} else {
				if (item.normal_contents == '') message += '해당 등급 사용 불가';
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
</style>
