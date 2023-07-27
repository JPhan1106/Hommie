package coding.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.entity.Room;
import coding.service.LandlordRoomService;

/**
 * Servlet implementation class UpdateListingServlet
 */
@WebServlet("/updateListing")
public class UpdateListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateListingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt((request.getParameter("id")));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int price = Integer.parseInt((request.getParameter("price")));
		int bond = Integer.parseInt((request.getParameter("bond")));
		int squareArea = Integer.parseInt((request.getParameter("squareArea")));
		int capacity = Integer.parseInt((request.getParameter("capacity")));
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String postcode = request.getParameter("postcode");
		int countBed = Integer.parseInt((request.getParameter("countBed")));
		int countBath = Integer.parseInt((request.getParameter("countBath")));
		String availableDate = request.getParameter("availableDate");
		
		try {


			Room room = new Room(id, title, description, price, bond, squareArea, capacity, countBed, countBath,
					availableDate, address, state, postcode);

			LandlordRoomService landlordRoomService = new LandlordRoomService();

			if (landlordRoomService.updateRoom(room)) {
				String updateRoomSuccessfulMessage = "Your listing has been successfully updated.";
				request.setAttribute("updateRoomSuccessfulMessage", updateRoomSuccessfulMessage);
				RequestDispatcher rd = request.getRequestDispatcher("landlordRoom?TYPE=AVAILABLE&roomId=" + id);
				rd.forward(request, response);

			} else {
				String updateRoomUnsuccessfulMessage = "There was an error, please try again!";
				request.setAttribute("updateRoomUnsuccessfulMessage", updateRoomUnsuccessfulMessage);
				RequestDispatcher rd = request.getRequestDispatcher("landlord-update-listing.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
