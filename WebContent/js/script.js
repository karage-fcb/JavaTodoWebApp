console.log("hello");

$(function() {
	console.log('hello jquery');

	/**
	 * 入力チェックを行う
	 */
	$('#submitButton').on('click', function() {
		console.log('hello');
		const inputTodoContent = $('#todoContent').val();
		const inputTodoTimeLimit = $('#todoTimeLimit').val();

		// 入力値が未入力だった時の処理
		if ((inputTodoContent == '') || (inputTodoTimeLimit == '')) {
		    alert('入力してください')
		} else {
			$('#todoCreateForm').submit();
		}

	});
})

/**
 * Todoを更新する
 */
updateTodo = function (todoId) {
	param = {
		todoId: todoId
	}
	$.get('update-servlet', param)
}

/**
 * Todoを削除する
 */
deleteTodo = function (todoId) {
	alert('Todoを削除しますか？');
	param = {
		todoId: todoId
	};
	$.post('delete-servlet', param);
}