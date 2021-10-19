package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.dao.dto.TodoDTO;

/**
 * Todoの一覧を取得するクラス
 *
 * @author uhablog
 */
public class TodoListDAO {

	/**
	 * Todoの一覧を取得する
	 * @return todoの一覧
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<TodoDTO> getTodoList() throws ClassNotFoundException, SQLException {
		// 返却用Listの初期化
		List<TodoDTO> todoList = new ArrayList<>();

		// 実行するSQL
		String sql = "SELECT id, todo, timeLimit, userid from todo";

		// DBに接続し、Todo一覧を取得する
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLの実行
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String todoContent = res.getString("todo");
				Date timeLimit = res.getDate("timeLimit");
				String userId = res.getString("userid");

				// 取得したid, todo, timeLimitでTodoDTOを初期化してListに追加
				TodoDTO todo = new TodoDTO();
				todo.setId(id);
				todo.setTodo(todoContent);
				todo.setTimeLimit(timeLimit);
				todo.setUserId(userId);
				todoList.add(todo);
			}
		}

		return todoList;
	}
}
