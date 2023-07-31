package coding.servlet;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import coding.db.MyConstant;
import coding.entity.Room;
import coding.service.LandlordRoomService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STRIPE_API_KEY = "sk_test_51NZ6VaAbavQCWhXPmCX4I98gOuWjK2OL5YAZn4LYV21srbF1vAauvQek2sITzldjisNSbINZXGmAPpav2ckAWY1V00YYyqczwe";

	public PaymentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LandlordRoomService landlordRoomService = new LandlordRoomService();
		int roomId = Integer.parseInt(request.getParameter("roomId")); // get the roomId from the request
		Room room = null; // Initialize room to null
		try {
			room = landlordRoomService.getAvailableRoomDetails(roomId);
		} catch (SQLException e) {
			e.printStackTrace();
		} // get the room object from the database

		if (room != null) {
			int listingFee = (int) Math.ceil((room.getPrice()) * MyConstant.COMMISSION);
			
			session.setAttribute("listingFee", listingFee);

			try {
				Stripe.apiKey = STRIPE_API_KEY;
				SessionCreateParams params = SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT)
						.setSuccessUrl("http://localhost:8080/hommie/successfulPayment?roomId=" + roomId) // add roomId
																											// as a
																											// parameter
																											// to the
																											// success
																											// URL
						.setCancelUrl("http://localhost:8080/hommie/payment")
						.addLineItem(
								SessionCreateParams.LineItem.builder().setQuantity(1L)
										.setPriceData(SessionCreateParams.LineItem.PriceData.builder()
												.setCurrency("aud").setUnitAmount((long) (listingFee * 100)) // Stripe
																												// uses
																												// cents,
																												// not
																												// dollars
												.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
														.builder().setName("Listing Fee").build())
												.build())
										.build())
						.build();
				Session stripeSession = Session.create(params);

				// Redirect to the Stripe Checkout page
				response.sendRedirect(stripeSession.getUrl());
			} catch (StripeException e) {
				e.printStackTrace();
				String errorMessage = "Error occurred while initiating payment. Please try again.";
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("payment").forward(request, response);
			}
		} else {
			response.sendRedirect("newListing");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
