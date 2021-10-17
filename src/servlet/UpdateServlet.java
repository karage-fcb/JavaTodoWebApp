package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.UpdateDAO;
import model.dao.dto.TodoDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends BaseServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	@Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// メソッドの取得
		String method = request.getMethod();

		if (method.equals("GET")) {
			getGetRequest(request, response);
		} else if (method.equals("POST")) {
			getPostRequest(request, response);
		}
	}

	protected void getGetRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// リクエストパラメータからtodoIdを取得する
		int todoId = 0;
		try {
			todoId = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("list-servlet").forward(request, response);
		}

		UpdateDAO dao = new UpdateDAO();
		TodoDTO todo = new TodoDTO();

		// todoの取得
		todo = dao.getTodo(todoId);

		request.setAttribute("todo", todo);
		request.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(request, response);
	}

	protected void getPostRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// リクエストパラメータから値を取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		String todo = request.getParameter(Parameters.TODO);
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));

		// DAOを生成し、Todoを更新する
		UpdateDAO dao = new UpdateDAO();

		// 受け取ったパラメータを元にデータベースを更新する
		dao.updateTodo(id, todo, timeLimit);

		response.sendRedirect("list-servlet");
	}
}
