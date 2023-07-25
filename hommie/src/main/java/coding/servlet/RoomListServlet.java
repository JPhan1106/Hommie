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
 * Servlet implementation class RoomServlet
 */
@WebServlet("/roomList")
public class RoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int currentPage = 1;
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			RoomService roomService = new RoomService();
			List<Room> roomList = roomService.getRoomsByPage(currentPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("room-list.jsp");
			request.setAttribute("roomList", roomList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", roomService.getTotalPage());
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
