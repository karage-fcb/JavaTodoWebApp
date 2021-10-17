package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;

/**
 * ログイン認証を行うためにデータベースに接続するクラス
 *
 * @author uhablog
 */
public class LoginDAO {

	/**
	 * idとパスワードによるログイン認証を行う
	 * @param id
	 * @param password
	 * @return 成功: id / 失敗: 空文字
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String LoginAuthenticate(String id, String password) throws SQLException, ClassNotFoundException {
		// 返却用変数
		String resId = "";
		// SQL作成
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("	id ");
		sql.append(" FROM ");
		sql.append("	users ");
		sql.append(" WHERE ");
		sql.append("	id = ? ");
		sql.append(" AND ");
		sql.append("	password = ? ");

		// DBに接続しユーザー情報を取得する
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			// SQLの実行
			ResultSet res = pstmt.executeQuery();

			// idとパスワードが一致するユーザーが存在した時の処理
			if(res.next()) {
				// 返却用変数にデータベースから取得したユーザーIDを設定する
				resId = res.getString("id");
			}
		}

		return resId;
	}
}
