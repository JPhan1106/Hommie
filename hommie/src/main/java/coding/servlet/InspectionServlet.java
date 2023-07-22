package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.entity.Inspection;
import coding.service.InspectionService;

/**
 * Servlet implementation class InspectionServlet
 */
@WebServlet("/inspection")
public class InspectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InspectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		InspectionService inspectionService = new InspectionService();
		

		if (session == null || session.getAttribute("studentId") == null) {
	        response.sendRedirect("login.jsp");
	        return;
		}
		
		int studentId = (Integer) session.getAttribute("studentId");
	    int roomId = Integer.parseInt(request.getParameter("roomId"));
	    String enquiryType = request.getParameter("enquiryType");
	    String message = request.getParameter("message");
	    
	    
	    System.out.println(studentId);

	    Inspection inspection = new Inspection(studentId, roomId, enquiryType, message);
			
			try {
				
			int	insertedId = inspectionService.insertInspection(inspection);
//			functions to send notification to landlord here
			response.sendRedirect("inspection-request-success.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

