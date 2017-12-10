package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountsDAO;
import DAO.TransaccionesDAO;
import beans.Account;
import beans.Cliente;
import beans.Transaccion;

/**
 * Servlet implementation class InsertTransactionServlet
 */
@WebServlet("/InsertTransactionServlet")
public class InsertTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTransactionServlet() {
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
		String ibanOrigen = request.getParameter("ibanOrig");
		String ibanDestino = request.getParameter("ibanDest");
		double cantidad = Double.parseDouble(request.getParameter("cantidad"));
		TransaccionesDAO.realizaTransaccion(ibanOrigen, ibanDestino, cantidad);
		//request.getRequestDispatcher("AccountDetailsServlet").forward(request, response); grande ricard
		response.sendRedirect("listaTransacciones.jsp?account=" + ibanOrigen + "&page=1&size=10");
	}

}
