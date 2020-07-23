<template>
	<div class="modal fade" style="color: black" id="addCardModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header justify-content-center">
					<h5 class="modal-title" id="exampleModalLabel"><span class="text-center">멤버십 가입</span></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="defaultUnchecked" />
						<label class="custom-control-label" for="defaultUnchecked">멤버십 이용 약관에 동의합니다.</label>
					</div>
					<div class="container px-3">
						<form class="mt-4">
							<h5 class="text-left">카드 번호</h5>
							<div class="row">
								<div class="col">
									<input type="text" class="form-control" minlength="4" maxlength="4" />
								</div>
								-
								<div class="col">
									<input type="text" class="form-control" minlength="4" maxlength="4" />
								</div>
								-
								<div class="col">
									<input type="text" class="form-control" minlength="4" maxlength="4" />
								</div>
								-
								<div class="col">
									<input type="text" class="form-control" minlength="4" maxlength="4" />
								</div>
							</div>
						</form>
						<form class="my-2">
							<h5 class="text-left">연도 / 월</h5>
							<div class="row">
								<div class="col-2">
									<input type="text" class="form-control" minlength="2" maxlength="2" />
								</div>
								/
								<div class="col-2">
									<input type="text" class="form-control" minlength="2" maxlength="2" />
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary">가입</button>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'AddCardModal'
};
</script>

<style scoped></style>
