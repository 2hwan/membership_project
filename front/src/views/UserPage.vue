<template>
	<div>
		<div class="jumbotron z-depth-0">
			<div class="text-white text-center">
				<div>
					<h1 class="card-title h1-responsive mb-2 font-bold"><strong>My 멤버십</strong></h1>
					<p class="mt-5 font-weight-bold">
						한눈에 확인하는 내 멤버십
					</p>
				</div>
			</div>
		</div>
		<mdb-container>
			<mdb-row hover class="rounded z-depth-1-half mb-4 py-5">
				<mdb-col col="4" class="font-weight-bold mx-auto">
					<h1 class="ml-4">
						<strong>윤성*님의 등급은 <br />VIP입니다.</strong>
					</h1>
					<h3 class="ml-4 mt-5">
						<strong>잔여포인트:</strong>
						<strong style="color: red">114,600P</strong>
					</h3>
				</mdb-col>
				<mdb-col col="1"></mdb-col>
				<mdb-col col="2" class="mr-2">
					<mdb-card class="z-depth-0">
						<mdb-view>
							<a href="#!">
								<img width="100%" src="@/assets/boximage.png" alt="" />
								<mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
							</a>
						</mdb-view>
						<mdb-card-body>
							<mdb-card-text class="text-center font-weight-bold">이용 내역 조회</mdb-card-text>
						</mdb-card-body>
					</mdb-card>
				</mdb-col>
				<mdb-col col="2" class="mx-2">
					<mdb-card class="z-depth-0">
						<mdb-view hover>
							<a href="#!">
								<img width="100%" src="@/assets/tipimage.png" alt="" />
								<mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
							</a>
						</mdb-view>
						<mdb-card-body>
							<mdb-card-text class="text-center  font-weight-bold">등급 업그레이드 Tip</mdb-card-text>
						</mdb-card-body>
					</mdb-card>
				</mdb-col>
				<mdb-col col="2" class="ml-2 mr-5">
					<mdb-card class="z-depth-0">
						<mdb-view hover>
							<a href="#!">
								<img width="100%" src="@/assets/chartimage.png" alt="" />
								<mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
							</a>
						</mdb-view>
						<mdb-card-body>
							<mdb-card-text class="text-center  font-weight-bold">등급 기준 안내</mdb-card-text>
						</mdb-card-body>
					</mdb-card>
				</mdb-col>
			</mdb-row>
			<mdb-row hover class="rounded z-depth-1-half mb-4 py-5">
				<mdb-col col="3">
					<mdb-view>
						<img class="justify-content-center mx-auto my-auto" src="@/assets/vipchoiceimage.png" alt="Sample image" width="100px" />
						<a>
							<mdb-mask overlay="white-slight" waves />
						</a>
					</mdb-view>
				</mdb-col>
				<mdb-col col="4" class="my-auto">
					<h2 class="font-weight-bold p-0">
						<strong>VIP CHOICE 잔여횟수</strong>
					</h2>
				</mdb-col>
				<mdb-col class="my-auto p-5">
					<h2 class="text-center mr-5" style="color:orangered;font-weight: bold">5회</h2>
				</mdb-col>
				<mdb-col class="my-auto">
					<mdb-btn outline="primary" size="lg">사용 내역</mdb-btn>
				</mdb-col>
			</mdb-row>
			<mdb-row hover class="rounded z-depth-1-half mb-4 py-5">
				<mdb-col col="3">
					<mdb-view>
						<img class="justify-content-center mx-auto my-auto" src="@/assets/vvipimage.png" alt="Sample image" width="100px" />
						<a>
							<mdb-mask overlay="white-slight" waves />
						</a>
					</mdb-view>
				</mdb-col>
				<mdb-col col="4" class="my-auto">
					<h2 class="font-weight-bold p-0">
						<strong>VVIP CHOICE 잔여횟수</strong>
					</h2>
				</mdb-col>
				<mdb-col class="my-auto">
					<h2 class="text-center mr-5" style="color:orangered;font-weight: bold">3회</h2>
				</mdb-col>
				<mdb-col class="my-auto">
					<mdb-btn outline="primary" size="lg">사용 내역</mdb-btn>
				</mdb-col>
			</mdb-row>
			<mdb-row hover class="rounded z-depth-1-half mb-4 py-5">
				<mdb-col col="3">
					<mdb-view>
						<img class="justify-content-center mx-auto my-auto" src="@/assets/cardimage.png" alt="Sample image" width="100px" />
						<a>
							<mdb-mask overlay="white-slight" waves />
						</a>
					</mdb-view>
				</mdb-col>
				<mdb-col col="4" class="my-auto">
					<h2 class="font-weight-bold p-0">
						<strong>보유 카드</strong>
					</h2>
				</mdb-col>
				<mdb-col class="my-auto">
					<h2 class="text-center mr-5" style="color:orangered;font-weight: bold">1장</h2>
				</mdb-col>
				<mdb-col class="my-auto">
					<mdb-btn outline="primary" size="lg">카드 관리</mdb-btn>
				</mdb-col>
			</mdb-row>
		</mdb-container>
	</div>
</template>

<script>
import { mdbContainer, mdbRow, mdbCol, mdbCard, mdbCardBody, mdbCardText, mdbBtn, mdbView, mdbMask } from 'mdbvue';
export default {
	components: {
		mdbContainer,
		mdbRow,
		mdbCol,
		mdbCard,
		mdbCardBody,
		mdbCardText,
		mdbBtn,
		mdbView,
		mdbMask
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
