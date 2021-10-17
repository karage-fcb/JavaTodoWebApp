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
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * リクエストパラメータから送られてきたTodoのIDをもとにDBからデータを取得し、画面に表示する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからtodoIdを取得する
		int todoId = Integer.parseInt(request.getParameter(Parameters.TODO_ID));

		UpdateDAO dao = new UpdateDAO();
		TodoDTO todo = new TodoDTO();
		try {
			// todoの取得
			todo = dao.getTodo(todoId);
		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}

		request.setAttribute("todo", todo);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータから値を取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		String todo = request.getParameter(Parameters.TODO);
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));

		// DAOを生成し、Todoを更新する
		UpdateDAO dao = new UpdateDAO();
		try {
			// 受け取ったパラメータを元にデータベースを更新する
			dao.updateTodo(id, todo, timeLimit);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect("list-servlet");
	}

}
