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

@WebServlet("/paymentHistory")
public class PaymentHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PaymentHistoryServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int landlordId = (Integer) session.getAttribute("landlordId");
        PaymentService paymentService = new PaymentService();

        try {
            List<Payment> payments = paymentService.getPaymentsByLandlordId(landlordId);
            request.setAttribute("payments", payments);
            request.getRequestDispatcher("paymentHistory.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
