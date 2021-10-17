package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

/**
 * Todoをデータベースに登録するクラス
 * @author yuhablog
 */
public class InsertDAO {

	/**
	 * Todoをデータベースに登録する
	 *
	 * @param todoの内容
	 * @param 期限
	 * @return 登録数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insertTodo(String todo, Date timeLimit)throws ClassNotFoundException, SQLException {
		// 更新した行数を返却するための変数
		int processingNumber = 0;

		// 実行するSQL
		String sql = "INSERT INTO todo (todo, timeLimit) VALUES (?, ?)";

		// SQLを実行する
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			// パラメータに値を設定する
			// 1つ目のパラメータにtodoの内容を設定
			pstmt.setString(1, todo);
			// 2つ目のパラメータにtimeLimitの内容を設定
			pstmt.setDate(2, timeLimit);
			// SQLを実行し、実行行数を受け取る
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}
