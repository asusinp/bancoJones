package servlets;

import java.io.IOException;
import beans.Cliente;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.ws.runtime.dev.Session;

import DAO.ClienteDAO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
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
		String dni = request.getParameter("dniUpd");
		//String pass = request.getParameter("passUpd");
		String surname = request.getParameter("surnameUpd");
		String birthday = request.getParameter("birthdayUpd");
		String sex = request.getParameter("sexUpd");
		String address = request.getParameter("addressUpd");
		String name = request.getParameter("nameUpd");
		String phone = request.getParameter("phoneUpd");
		boolean result = ClienteDAO.updateValid(dni, surname, birthday, sex, address, name, phone);
//		boolean result = ClienteDAO.updateValid(dni, surname, birthday, pass, sex, address, name, phone);		
		if (result) {
//			HttpSession session = request.getSession();
//			Cliente c = (Cliente)session.getAttribute("clientSession");
//			c.setApellidos(surname);
			request.getRequestDispatcher("update.jsp").include(request,response);							
		} else {
			request.getRequestDispatcher("loginko.jsp").include(request,response);
		}
	}

}
