console.log("hello");

$(function() {
	console.log('hello jquery');

	// Todo登録ボタン押下時処理
	$('#submitButton').on('click', function() {
		console.log('hello');
		const inputTodoContent = ('#todoContent').val();
		const inputTodoTimeLimit = ('#todoTimeLimit').val();

		// 入力値が未入力だった時の処理
//		if ((inputTodoTimeLimit == '') || (inputTodoContent == '')) {
//			alert.('入力してください');
//		}else {
//			$('#todoCreateForm').submit();
//		}

	});
})

console.log("script end");