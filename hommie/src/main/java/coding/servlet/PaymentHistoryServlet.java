package coding.servlet;

import coding.entity.Payment;
import coding.service.PaymentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/paymentHistory")
public class PaymentHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaymentHistoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int landlordId = Integer.parseInt(request.getParameter("landlordId"));
		PaymentService paymentService = new PaymentService();

		try {
			List<Map<String, Object>> payments = paymentService.getPaymentsByLandlordId(landlordId);
			request.setAttribute("payments", payments);
			request.getRequestDispatcher("payment-history.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
