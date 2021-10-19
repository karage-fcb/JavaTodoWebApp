package model.viewModel;

import java.util.List;

import model.dao.dto.TodoDTO;

/**
 * Todo一覧画面に渡すビューモデル
 * @author uhablog
 *
 */
public class ListViewModel {

	/**
	 * Todoのリスト
	 */
	private List<TodoDTO> todoList;

	/**
	 * ログインしているユーザーのID
	 */
	private String loginUserId;

	public List<TodoDTO> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoDTO> todoList) {
		this.todoList = todoList;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

}
