package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountsDAO;
import beans.Account;
import beans.Cliente;

/**
 * Servlet implementation class InsertAccountServlet
 */
@WebServlet("/InsertAccountServlet")
public class InsertAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAccountServlet() {
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
		String iban = request.getParameter("ibanIns");
		double balance = Double.parseDouble(request.getParameter("balanceIns"));
		Cliente c = (Cliente) request.getSession().getAttribute("clientSession");
		Account account = new Account(iban, c, balance);
		AccountsDAO.insertAccount(account);
		//request.getRequestDispatcher("cuentas.jsp").include(request,response);
		response.sendRedirect("ListAccountsServlet");		
	}

}
