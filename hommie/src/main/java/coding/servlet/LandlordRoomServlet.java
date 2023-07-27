package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.entity.Room;
import coding.service.LandlordRoomService;

/**
 * Servlet implementation class LandlordRoomServlet
 */
@WebServlet("/landlordRoom")
public class LandlordRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LandlordRoomServlet() {
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

			LandlordRoomService landlordRoomService = new LandlordRoomService();
			String roomId = request.getParameter("roomId");
			Room availableRoom = new Room();
			Room rentedRoom = new Room();
			String type = request.getParameter("TYPE");

			if (type.equals("AVAILABLE")) {
				availableRoom = landlordRoomService.getAvailableRoomDetails(Integer.parseInt(roomId));
				RequestDispatcher rd = request.getRequestDispatcher("landlord-available-room-details.jsp");
				request.setAttribute("availableRoom", availableRoom);
				rd.forward(request, response);
			}

			else if (type.equals("RENTED")) {
				rentedRoom = landlordRoomService.getRentedRoomDetails(Integer.parseInt(roomId));
				request.setAttribute("rentedRoom", rentedRoom);
				RequestDispatcher rd = request.getRequestDispatcher("landlord-rented-room-details.jsp");
//				System.out.println(rentedRoom.getLeaseStartDate()); 
				rd.forward(request, response);
			}

			else if (type.equals("MAKE_AVAILABLE")) {
				landlordRoomService.makeRentedRoomAvaible(Integer.parseInt(roomId));
				response.sendRedirect("landlordRoomList?TYPE=ALL");

			}

			else if (type.equals("MAKE_OCCUPIED")) {
				landlordRoomService.makeAvaibleRoomOccupied(Integer.parseInt(roomId));
				response.sendRedirect("landlordRoomList?TYPE=ALL");

			}

			else if (type.equals("DELETE")) {
				landlordRoomService.deleteRoom(Integer.parseInt(roomId));
				response.sendRedirect("landlordRoomList?TYPE=ALL");

			}

			else if (type.equals("UPDATE")) {
				Room room = new Room();
				room = landlordRoomService.getAvailableRoomDetails(Integer.parseInt(roomId));
				RequestDispatcher rd = request.getRequestDispatcher("landlord-update-listing.jsp");
				request.setAttribute("room", room);
				rd.forward(request, response);
			}
		}

		catch (SQLException e) {
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
