package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class DeleteDAO {

	/**
	 * Todoを削除する
	 * @return 削除した行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteTodo(int id) throws SQLException, ClassNotFoundException {
		int processingNumber = 0;

		// SQL文
		String sql = "DELETE FROM todo WHERE id = ?";

		// DBに接続し、Todoを削除する
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			// idを設定する
			pstmt.setInt(1, id);

			// SQLを実行する
			processingNumber = pstmt.executeUpdate();
		}

		return processingNumber;
	}
}
