package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.InsertDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertServlet extends BaseServlet {
    /**
     * コンストラクタ
     */
    public InsertServlet() {
        super();
    }

    /**
     * Todoをデータベースに登録する
     */
	@Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータのname属性がtodoの値を受け取る
		String todo = (String) request.getParameter(Parameters.TODO);
		// リクエストパラメータのname属性がtimeLimitの値を受け取る
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));

		// DAOを生成し、Todoをデータベースに登録する
		InsertDAO dao = new InsertDAO();

		// 受け取ったパラメータを引数に渡す
		dao.insertTodo(todo, timeLimit, this.getLoginUserId());

		response.sendRedirect("list-servlet");
	}
}
