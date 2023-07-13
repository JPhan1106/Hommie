package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.entity.Room;
import coding.service.RoomService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String searchInput = request.getParameter("searchInput");
            String weeklyPrice = request.getParameter("weeklyPrice");
            String state = request.getParameter("state");
            String availableDate = request.getParameter("availableDate");

            System.out.println("search: " + searchInput);
            System.out.println("price: " + weeklyPrice);
            System.out.println("date: " + availableDate);
            System.out.println("state: " + state);

            RoomService roomService = new RoomService();
            
            List<Room> roomList;

            if (state != null) {
                roomList = roomService.getRoomsBySearchWithState(searchInput, weeklyPrice, state, availableDate);
            } else {
                roomList = roomService.getRoomsBySearchWithoutState(searchInput, weeklyPrice, availableDate);
            }



            request.setAttribute("roomList", roomList);
            request.setAttribute("searchInput", searchInput);
            request.setAttribute("weeklyPrice", weeklyPrice);
            request.setAttribute("state", state);
            request.setAttribute("availableDate", availableDate);

            RequestDispatcher rd = request.getRequestDispatcher("room-list.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
		
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
