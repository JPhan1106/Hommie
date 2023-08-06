package coding.servlet;

import coding.entity.Payment;
import coding.entity.Room;
import coding.service.LandlordRoomService;
import coding.service.PaymentService;
import coding.db.MyConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/successfulPayment")
public class SuccessfulPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LandlordRoomService landlordRoomService;
	private PaymentService paymentService; // Add PaymentService

	public SuccessfulPaymentServlet() {
		super();
	}

	public void init() {
		landlordRoomService = new LandlordRoomService();
		paymentService = new PaymentService(); // Initialize the PaymentService
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomId = -1;
		try {
			roomId = Integer.parseInt(request.getParameter("roomId"));
		} catch (NumberFormatException e) {
			String errorMessage = "Invalid room id";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}

		Room room = null;
		try {
			room = landlordRoomService.getAvailableRoomDetails(roomId);
			room.setPaymentStatus("paid");
			landlordRoomService.updateRoomStatus(room); // Assume this method updates the payment status

			// Now, create a new Payment
			Payment payment = new Payment();
			payment.setRoomId(room.getId());
			payment.setLandlordId(room.getLandlordId());
			int listingFee = (int) Math.ceil((room.getPrice()) * MyConstant.COMMISSION);
			payment.setListingFee(listingFee);
			payment.setListingDate(new Timestamp(System.currentTimeMillis()));

			// Now, save the Payment to the database
			paymentService.insertPayment(payment);

		} catch (SQLException e) {
			e.printStackTrace();
			String errorMessage = "Error occurred while fetching or updating room details";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}

		request.setAttribute("room", room);
		RequestDispatcher rd = request.getRequestDispatcher("successful-payment.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
