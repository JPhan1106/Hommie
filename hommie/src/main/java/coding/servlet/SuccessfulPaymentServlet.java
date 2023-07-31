package coding.servlet;

import coding.entity.Room;
import coding.service.LandlordRoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/successfulPayment")
public class SuccessfulPaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LandlordRoomService landlordRoomService;

    public SuccessfulPaymentServlet() {
        super();
    }

    public void init() {
        landlordRoomService = new LandlordRoomService();
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
        } catch (SQLException e) {
            e.printStackTrace();
            String errorMessage = "Error occurred while fetching or updating room details";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            return;
        }

        // After successfully fetching and updating room details, redirect to successful payment page
        response.sendRedirect(request.getContextPath() + "/successful-payment.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
