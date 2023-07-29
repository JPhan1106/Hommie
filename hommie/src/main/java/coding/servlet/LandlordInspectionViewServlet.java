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

import coding.entity.Inspection;
import coding.service.InspectionService;

/**
 * Servlet implementation class LandlordInspectionView
 */
@WebServlet("/landlordInspectionView")
public class LandlordInspectionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LandlordInspectionViewServlet() {
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
		InspectionService inspectionService = new InspectionService();

		String roomId = request.getParameter("roomId");

		List<Inspection> inspectionList = new ArrayList<>();

		try {
			int roomIdInt = Integer.parseInt(roomId);
			inspectionList = inspectionService.getAllInspectionByRoomId(roomIdInt);

			RequestDispatcher rd = request.getRequestDispatcher("landlord-inspection-list.jsp");
			request.setAttribute("list", inspectionList);
			rd.forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// Handle SQLException
			e.printStackTrace();
		}

	}
}
