let model;

$(document).ready(function() {	
	$('#checkButton').click(function() {
		let tablename = $('#tableName').val();
		checkMoel(tablename)
			.then((data) => {
				const $result = $('#result');
				$result.empty();
				let answer = data ? "테이블이 존재합니다" : "테이블이 존재하지않습니다.";
				$result.append(answer);
				// true 일 때 p태그에서 있는거 확인시킨 후 계산 실행
				if(data){
					return maxPointDiff(tablename);
				}
			})
			.then((resultB) => {
				const $maxPointText = $('#maxPoint');
				$maxPointText.empty();
				$maxPointText.append(resultB);
			})
			.catch((error) => {
				console.error("AJAX error : " + error);
			});
	});
})

// 모델 테이블이 존재하는지 여부 확인
const checkMoel = (tablename) => {
	return new Promise((resolve, reject) => {
		$.ajax({
			type: 'POST',
			url: '/check_table',
			data: {name: tablename},
			success: function(response){
				resolve(response);
			},
			error: function(xhr, status, error){
				console.error("AJAX ERROR: " + error);
				reject(error);
			}
		})
	});
}

// 모델 데이터의 포인트 최대 차 구하기
const maxPointDiff = (tablename) => {
	console.log(tablename);
	return new Promise((resolve, reject) => {
		$.ajax({
			url: 'maxPointDiff',
			type: 'POST',
			data: {name: tablename},
			success: function(response){
				resolve(response);
			},
			error: function(xhr, status, error){
				reject(error);
			}
		})
	});
}