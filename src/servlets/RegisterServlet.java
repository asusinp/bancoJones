package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import beans.Cliente;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		String pass = request.getParameter("pass");
		String surname = request.getParameter("surname");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String password = request.getParameter("password");
		String address = request.getParameter("address"); 
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		Cliente c = ClienteDAO.regValid(dni,pass,surname,birthday,sex.charAt(0),password,address,name,phone);
		if (c.isValid()) {
			request.getRequestDispatcher("loginok.jsp").include(request,response);
		} else {
			request.getRequestDispatcher("loginko.jsp").include(request,response);
		}
	}

}
