package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete-servlet")
public class DeleteServlet extends BaseServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
    }

	/**
     * Getリクエストを受け付けてTodoを削除する
     */
	@Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// リクエストパラメータから削除するTodoのidを取得する
		int id = Integer.parseInt(request.getParameter(Parameters.TODO_ID));

		DeleteDAO dao = new DeleteDAO();

		// todoを削除する
		dao.deleteTodo(id);

		response.sendRedirect("list-servlet");
	}
}
