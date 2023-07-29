package coding.servlet;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import coding.db.MyConstant;
import coding.entity.Room;
import coding.service.LandlordRoomService;

/**
 * Servlet implementation class NewListingServlet
 */
@WebServlet("/newListing")
@MultipartConfig
public class NewListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewListingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		System.out.println("Get to do post successfully");

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int price = Integer.parseInt((request.getParameter("price")));
		int bond = Integer.parseInt((request.getParameter("bond")));
		int squareArea = Integer.parseInt((request.getParameter("squareArea")));
		int capacity = Integer.parseInt((request.getParameter("capacity")));
		int landlordId = (Integer) session.getAttribute("landlordId");
		System.out.println("landlordId:" + landlordId);
		String address = request.getParameter("address");

		// getAbbreviatedState
		String stateParam = request.getParameter("state");
		String state = getAbbreviatedState(stateParam);

		String postcode = request.getParameter("postcode");
		String lat = request.getParameter("lat");
		System.out.println("lat:" + lat);
		String lng = request.getParameter("lng");
		System.out.println("lng:" + lng);
		int countBed = Integer.parseInt((request.getParameter("countBed")));
		int countBath = Integer.parseInt((request.getParameter("countBath")));
		String availableDate = request.getParameter("availableDate");
		System.out.println("Available date:" + availableDate);

		try {

			Part image1 = request.getPart("image1");
			Part image2 = request.getPart("image2");
			Part image3 = request.getPart("image3");
			Part image4 = request.getPart("image4");

			String rootPathString = MyConstant.IMAGE_ROOT_PATH;

			String image1Name = getSubmittedFileName(image1);
			System.out.println("Image1's name: " + image1Name);
			String image1UploadPath = rootPathString + image1Name;
			String image1Url = "img/" + image1Name;
			System.out.println(image1UploadPath);

			FileOutputStream fos1 = new FileOutputStream(image1UploadPath);
			InputStream is1 = image1.getInputStream();

			byte[] data1 = new byte[is1.available()];
			is1.read(data1);
			fos1.write(data1);
			fos1.close();
			is1.close();

			String image2Name = getSubmittedFileName(image2);
			System.out.println("Image2's name: " + image2Name);
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
			System.out.println("Image3's name: " + image3Name);
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
			System.out.println("Image4's name: " + image4Name);
			String image4UploadPath = rootPathString + image4Name;
			String image4Url = "img/" + image4Name;

			FileOutputStream fos4 = new FileOutputStream(image4UploadPath);
			InputStream is4 = image4.getInputStream();

			byte[] data4 = new byte[is4.available()];
			is4.read(data4);
			fos4.write(data4);
			fos4.close();
			is4.close();

			Room room = new Room(title, description, price, bond, squareArea, capacity, countBed, countBath,
					availableDate, landlordId, address, state, lat, lng, postcode, image1Url, image2Url, image3Url,
					image4Url);

			LandlordRoomService landlordRoomService = new LandlordRoomService();

			if (landlordRoomService.insertRoom(room)) {
				String createRoomSuccessfulMessage = "Your new listing has been successfully added.";
				request.setAttribute("createRoomSuccessfulMessage", createRoomSuccessfulMessage);
				RequestDispatcher rd = request.getRequestDispatcher("landlordRoomList?TYPE=AVAILABLE");
				rd.forward(request, response);

			} else {
				String createRoomUnsuccessfulMessage = "There was an error, please try again!";
				request.setAttribute("createRoomUnsuccessfulMessage", createRoomUnsuccessfulMessage);
				RequestDispatcher rd = request.getRequestDispatcher("landlord-listing.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
			return stateName; // Return the original state name if no abbreviation is found
		}
	}

	// Method to extract the submitted file name from the Part object
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
