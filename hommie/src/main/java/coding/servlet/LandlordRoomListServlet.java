package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.entity.Room;
import coding.service.LandlordRoomService;

/**
 * Servlet implementation class LandlordRoomListServlet
 */
@WebServlet("/landlordRoomList")
public class LandlordRoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LandlordRoomListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			Integer landlordId = (Integer) session.getAttribute("landlordId");

			String type = request.getParameter("TYPE");

			if (type.equals("ALL")) {
				LandlordRoomService landlordRoomService = new LandlordRoomService();
				List<Room> availableRoomList = landlordRoomService.getAllAvailableRoomsByLandlordId(landlordId);
				List<Room> rentedRoomList = landlordRoomService.getAllRentedRoomsByLandlordId(landlordId);

				RequestDispatcher rd = request.getRequestDispatcher("landlord-room-list.jsp");
				request.setAttribute("availableRoomList", availableRoomList);
				request.setAttribute("rentedRoomList", rentedRoomList);
				rd.forward(request, response);
			}
			
			else if (type.equals("AVAILABLE")) {
				LandlordRoomService landlordRoomService = new LandlordRoomService();
				List<Room> availableRoomList = landlordRoomService.getAllAvailableRoomsByLandlordId(landlordId);
				
				RequestDispatcher rd = request.getRequestDispatcher("landlord-room-list.jsp");
				request.setAttribute("availableRoomList", availableRoomList);
				rd.forward(request, response);
			}
			
			else if (type.equals("RENTED")) {
				LandlordRoomService landlordRoomService = new LandlordRoomService();
				List<Room> rentedRoomList = landlordRoomService.getAllRentedRoomsByLandlordId(landlordId);

				RequestDispatcher rd = request.getRequestDispatcher("landlord-room-list.jsp");
				request.setAttribute("rentedRoomList", rentedRoomList);
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
