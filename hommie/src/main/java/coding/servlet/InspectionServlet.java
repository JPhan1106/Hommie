package coding.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.entity.Inspection;
import coding.entity.Room;
import coding.entity.User;
import coding.service.InspectionService;
import coding.service.RoomService;
import coding.service.UserService;

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
		
		Room room = new Room();
		RoomService roomService = new RoomService();
		
		User landlord = new User();
		UserService userService = new UserService();
		

		if (session == null || session.getAttribute("studentId") == null) {
	        response.sendRedirect("login.jsp");
	        return;
		}
		
		int studentId = (Integer) session.getAttribute("studentId");
	    int roomId = Integer.parseInt(request.getParameter("roomId"));
	    String enquiryType = request.getParameter("enquiryType");
	    String message = request.getParameter("message");
	    
	 // Validate message
	 		List<String> errors = validateMessage(message);
	 		if (!errors.isEmpty()) {
	 			RequestDispatcher rd = request.getRequestDispatcher("room?roomId=" + roomId);
	 			request.setAttribute("errorMessage", errors);
	 			rd.forward(request, response);
	 		}
	    
	    Inspection inspection = new Inspection(studentId, roomId, enquiryType, message);
			
		try {
				
			int	insertedInspectionId = inspectionService.insertInspection(inspection);
			room = roomService.getRoomDetails(roomId);
			int landlordId = room.getLandlordId();
			landlord = userService.getUserByUserId(landlordId);
			
			
			// Send email using EmailUtility
		    String to = landlord.getEmail();
		    String subject = "Hommie - New message from your potential roomie - " + enquiryType;
		    String content = message;

		    EmailUtility.sendEmail(to, subject, content);
						
		    
			response.sendRedirect("inspection-request-success.jsp");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
	
//	function to send email to landlord:
	
	public class EmailUtility {
	    public static void sendEmail(String to, String subject, String content) {
	    	
	    	final String username = "jenny@workvisalawyers.com.au";
	        final String password = "Bluebike27!";
	    	
	        
	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); 
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            MimeMessage message = new MimeMessage(session);

	            message.setFrom(new InternetAddress(username));

	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            message.setSubject(subject);


	            message.setText(content);

	            Transport.send(message);
	            System.out.println("Done");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	    }
	}
	
	private List<String> validateMessage(String message) {
	    List<String> errors = new ArrayList<>();

	    // Validate message length
	    if (message == null || message.trim().isEmpty() || message.length() > 300) {
	        errors.add("Invalid message. Message cannot be empty and must be at most 300 characters long!");
	    }

	    return errors;
	}

	
	
	}

