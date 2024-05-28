let model;

$(document).ready(function() {	
	$('#checkButton').click(function() {
		handleEvent();
	});
	$('#tableName').keydown(function(event) {
		if(event.key === 'Enter'){
			handleEvent();
		}
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
//application/x-www-form-urlencoded;charset=UTF-8
const maxPointDiff = (tablename) => {
	const data = {'name' : tablename};
	return new Promise((resolve, reject) => {
		$.ajax({
			type: 'POST',
			url: '/maxPointDiff',
			contentType: 'application/json; charset=UTF-8',
			data: JSON.stringify(data),
			success: function(response){
				let data = [];
				let olProj = ol.proj;
				let pointA = olProj.transform([response[0], response[1]], 'EPSG:4326', 'EPSG:3857');
				let pointB = olProj.transform([response[2], response[3]], 'EPSG:4326', 'EPSG:3857');
				data = [pointA, pointB];
				resolve(data);
			},
			error: function(xhr, status, error){
				console.error("AJAX status: " + status);
				console.error("AJAX error: " + error);
				reject(error);
			}
		});
	});
}


const showLoadingSpinner = () => {
	$('#loading-spinner').show();
}

const hideLoadingSpinner = () => {
	$('#loading-spinner').hide();
}

const handleEvent = () => {
	const $maxPointText = $('#maxPoint');
	const $result = $('#result');
	$maxPointText.empty();
	$result.empty();
	let tablename = $('#tableName').val();

	showLoadingSpinner();
	checkMoel(tablename)
		.then((data) => {
			$result.empty();
			let answer = data ? "테이블이 존재합니다" : "테이블이 존재하지않습니다.";
			$result.append(answer);
			// true 일 때 p태그에서 있는거 확인시킨 후 계산 실행
			if(data){
				return maxPointDiff(tablename);
			}
			hideLoadingSpinner();
		})
		.then((resultB) => {
			hideLoadingSpinner();
			$maxPointText.empty();
			$maxPointText.append(resultB[0] + ", " + resultB[1]);
		})
		.catch((error) => {
			hideLoadingSpinner();
			console.error("AJAX error : " + error);
		});
}