package coding.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import coding.db.MyConstant;
import coding.entity.Room;
import coding.service.LandlordRoomService;

@WebServlet("/newListing")
@MultipartConfig
public class NewListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewListingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int price = Integer.parseInt((request.getParameter("price")));
		session.setAttribute("price", price);
		int bond = Integer.parseInt((request.getParameter("bond")));
		int squareArea = Integer.parseInt((request.getParameter("squareArea")));
		int capacity = Integer.parseInt((request.getParameter("capacity")));
		int landlordId = (Integer) session.getAttribute("landlordId");
		String address = request.getParameter("address");

		String stateParam = request.getParameter("state");
		String state = getAbbreviatedState(stateParam);

		String postcode = request.getParameter("postcode");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		int countBed = Integer.parseInt((request.getParameter("countBed")));
		int countBath = Integer.parseInt((request.getParameter("countBath")));
		String availableDate = request.getParameter("availableDate");

		Part image1 = request.getPart("image1");
		Part image2 = request.getPart("image2");
		Part image3 = request.getPart("image3");
		Part image4 = request.getPart("image4");

		String rootPathString = MyConstant.IMAGE_ROOT_PATH;

		String image1Name = getSubmittedFileName(image1);
		String image1UploadPath = rootPathString + image1Name;
		String image1Url = "img/" + image1Name;

		FileOutputStream fos1 = new FileOutputStream(image1UploadPath);
		InputStream is1 = image1.getInputStream();

		byte[] data1 = new byte[is1.available()];
		is1.read(data1);
		fos1.write(data1);
		fos1.close();
		is1.close();

		String image2Name = getSubmittedFileName(image2);
		String image2UploadPath = rootPathString + image2Name;
		String image2Url = "img/" + image2Name;

		FileOutputStream fos2 = new FileOutputStream(image2UploadPath);
		InputStream is2 = image2.getInputStream();

		byte[] data2 = new byte[is2.available()];
		is2.read(data2);
		fos2.write(data2);
		fos2.close();
		is2.close();

		String image3Name = getSubmittedFileName(image3);
		String image3UploadPath = rootPathString + image3Name;
		String image3Url = "img/" + image3Name;

		FileOutputStream fos3 = new FileOutputStream(image3UploadPath);
		InputStream is3 = image3.getInputStream();

		byte[] data3 = new byte[is3.available()];
		is3.read(data3);
		fos3.write(data3);
		fos3.close();
		is3.close();

		String image4Name = getSubmittedFileName(image4);
		String image4UploadPath = rootPathString + image4Name;
		String image4Url = "img/" + image4Name;

		FileOutputStream fos4 = new FileOutputStream(image4UploadPath);
		InputStream is4 = image4.getInputStream();

		byte[] data4 = new byte[is4.available()];
		is4.read(data4);
		fos4.write(data4);
		fos4.close();
		is4.close();

		// Create the room with status 'unpaid'
		Room room = new Room(title, description, price, bond, squareArea, capacity, countBed, countBath, availableDate,
				landlordId, address, state, lat, lng, postcode, image1Url, image2Url, image3Url, image4Url, "unpaid");

		// Save the room to the database
		LandlordRoomService landlordRoomService = new LandlordRoomService();
		int roomId = -1;
		try {
			roomId = landlordRoomService.insertRoom(room);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Check if the room was inserted successfully
		if (roomId > 0) {
			// Room inserted successfully, set roomId in session
			session.setAttribute("roomId", roomId);

			// Redirect the landlord to the payment page
			response.sendRedirect("payment?roomId=" + roomId);
		} else {
			String createRoomUnsuccessfulMessage = "There was an error, please try again!";
			request.setAttribute("createRoomUnsuccessfulMessage", createRoomUnsuccessfulMessage);
			RequestDispatcher rd = request.getRequestDispatcher("landlord-listing.jsp");
			rd.forward(request, response);
		}
	}

	public String getAbbreviatedState(String stateName) {
		switch (stateName) {
		case "New South Wales":
			return "NSW";
		case "Queensland":
			return "QLD";
		case "South Australia":
			return "SA";
		case "Tasmania":
			return "TAS";
		case "Victoria":
			return "VIC";
		case "Western Australia":
			return "WA";
		case "Australian Capital Territory":
			return "ACT";
		case "Northern Territory":
			return "NT";
		default:
			return stateName;
		}
	}

	private String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName;
			}
		}
		return null;
	}
}
