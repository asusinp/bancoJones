package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.TransaccionesDAO;
import beans.Transaccion;

/**
 * Servlet implementation class JsonDownloadServlet
 */
@WebServlet("/JsonDownloadServlet")
public class JsonDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JsonDownloadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String iban = request.getParameter("iban");		
		List<Transaccion> listTransactions = TransaccionesDAO.listaTransacciones(iban);
        String filename = "json_transacciones_" + iban + ".json";
        File file = new File(filename);
        PrintWriter bw = new PrintWriter(new FileWriter(filename));
		for (Transaccion t : listTransactions) {
			Gson gson = new Gson();
			String json = gson.toJson(t);			
			bw.println(json);
		}        
		bw.close();        
        response.setContentType("application/plain-text");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);        
        @SuppressWarnings("resource")
		FileInputStream fileIn = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] outputByte = new byte[(int)file.length()];
        while(fileIn.read(outputByte, 0, (int)file.length()) != -1) {
        	out.write(outputByte, 0, (int)file.length());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
