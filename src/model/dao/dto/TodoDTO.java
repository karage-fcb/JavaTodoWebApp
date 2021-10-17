package model.dao.dto;

import java.sql.Date;

/**
 * Todoを保持するクラス
 * @author yuhablog
 */
public class TodoDTO {
	/**
	 * TodoのIdを保持する
	 */
	private int id;

	/**
	 * Todoの内容を保持する
	 */
	private String todo;

	/**
	 * Todoの期限を保持する
	 */
	private Date timeLimit;

	/**
	 * 引数なしコンストラクタ
	 * 初期化を行う
	 */
	public TodoDTO () {
		id = 0;
		todo = "";
		timeLimit = new Date(System.currentTimeMillis());
	}

	/**
	 * 受け取った引数によって初期化を行う
	 * @param id
	 * @param todo
	 * @param timeLimit
	 */
	public TodoDTO(int id, String todo, Date timeLimit) {
		this.id = id;
		this.todo = todo;
		this.timeLimit = timeLimit;
	}

	/**
	 * idを取得する
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * idを設定する
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Todoの内容を取得する
	 * @return Todoの内容
	 */
	public String getTodo() {
		return todo;
	}

	/**
	 * Todoの内容を設定する
	 * @param todo
	 */
	public void setTodo(String todo) {
		this.todo = todo;
	}

	/**
	 * Todoの期限を取得する
	 * @return
	 */
	public Date getTimeLimit() {
		return timeLimit;
	}

	/**
	 * Todoの期限を設定する
	 * @param timeLimit
	 */
	public void setTimeLimit(Date timeLimit) {
		this.timeLimit = timeLimit;
	}

}
