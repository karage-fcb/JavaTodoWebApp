package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.Parameters;
import constant.SessionInfo;
import model.dao.LoginDAO;

/**
 * ログイン画面を制御するサーブレット
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * GETメソッドでリクエストを受け付けた時はログイン画面を表示する
	 * login.jspを画面に表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * POSTメソッドでリクエストを受け付けた時はログイン認証を行う
	 * 成功した時はTodo一覧画面に遷移
	 * 失敗した時はログイン画面に戻す
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストからidとパスワードを取得する
		String id = request.getParameter(Parameters.LOGIN_ID);
		String password = request.getParameter(Parameters.LOGIN_PASSWORD);

		// ログインユーザーのid
		String loginId = "";

		LoginDAO dao = new LoginDAO();

		// データベースに接続し、ログイン認証を行う
		try {
			loginId = dao.LoginAuthenticate(id, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 遷移先のパスを保持する
		String path = "";
		// loginIdが空文字かどうかでログインの成否を判定する
		if (loginId != "") {
			// セッションにログインIDを保持する
			HttpSession session = request.getSession();
			session.setAttribute(SessionInfo.LOGIN_USER_ID, loginId);
			path = "list-servlet";
		} else {
			path = "WEB-INF/jsp/login.jsp";
		}

		// 設定されているパスに遷移する
		request.getRequestDispatcher(path).forward(request, response);
	}

}