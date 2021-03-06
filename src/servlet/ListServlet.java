package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TodoListDAO;
import model.dao.dto.TodoDTO;
import model.viewModel.ListViewModel;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list-servlet")
public class ListServlet extends BaseServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
    }

	/**
	 * todoテーブルからtodoを取得し、一覧表示する
	 */
	@Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// todoの一覧を保持する変数を宣言
		List<TodoDTO> todoList = new ArrayList<>();

		// DAOを生成し、Todo一覧を取得する
		TodoListDAO dao = new TodoListDAO();

		// todo一覧を取得する
		todoList = dao.getTodoList();

		// Todo一覧に渡すモデルの生成
		ListViewModel viewModel = new ListViewModel();
		viewModel.setTodoList(todoList);
		viewModel.setLoginUserId(this.getLoginUserId());

		// viewModelをリクエストスコープに設定する
		request.setAttribute("viewModel", viewModel);
		// todo一覧画面に遷移する
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		rd.forward(request, response);
	}
}