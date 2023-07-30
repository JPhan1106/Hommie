package coding.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.entity.Room;
import coding.entity.WishListItem;
import coding.service.RoomService;
import coding.service.WishListService;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/wish-list")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WishListServlet() {
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
			WishListService wishListService = new WishListService();
			int studentId = 0;

	        // Check if the user is logged in
	        if (session.getAttribute("studentId") != null) {
	            studentId = (int) session.getAttribute("studentId");
	        } else {
	            // If the user is not logged in, redirect to the login page
	            response.sendRedirect("login.jsp");
	            return;
	        }

			String command = request.getParameter("command");
			int roomId = 0;
			RoomService roomService = new RoomService();

			// Show wish list
			if (command != null && command.equals("VIEW_WISH_LIST")) {
				List<Room> wishList = wishListService.getWishListByStudentId(studentId);

				request.setAttribute("wishList", wishList);
				request.getRequestDispatcher("wish-list.jsp").forward(request, response);
				return; // Exit the method after displaying the wishlist
			}

			// Add to wish list
			if (command != null && command.equals("ADD_TO_WISH_LIST")) {
				roomId = Integer.parseInt(request.getParameter("roomId"));
				Room room = roomService.getRoomDetails(roomId);

				 //Check if roomId already exists in the wishlist
				Map<Integer, WishListItem> wishListMap = (Map<Integer, WishListItem>) session.getAttribute("wishList");
				if (wishListMap == null) {
			        wishListMap = new HashMap<>();
			    }

				// Check if the room is already in the wishlist for this student
	            if (wishListService.isRoomInWishlist(studentId, roomId)) {
	                // If the room is already in the wishlist, set an error message
	                String errorMessage = "Room is already in the wishlist.";
	                request.setAttribute("errorMessage", errorMessage);
	            } else {
	                // If the room is not in the wishlist, then add it to the wishlist and database
	                WishListItem wishlistItem = new WishListItem(room, studentId);
	                wishListMap.put(room.getId(), wishlistItem);

	                // Insert wishList into database
	                wishListService.insertWishListItems(wishListMap);
	            }
	            
			    session.setAttribute("wishList", wishListMap);
			    request.setAttribute("room", room);

			    // Redirect back to the wishlist after adding an item
			    response.sendRedirect("roomList");

			}

			// Remove from wish list
			if (command != null && command.equals("REMOVE")) {
				roomId = Integer.parseInt(request.getParameter("roomId"));
				wishListService.deleteWishListItem(studentId, roomId);

				// Redirect back to the wishlist after removing an item
				response.sendRedirect("wish-list?command=VIEW_WISH_LIST");
				return;
			}
		} catch (Exception e) {
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
