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
import javax.servlet.http.Part;

import coding.db.MyConstant;
import coding.entity.Room;
import coding.service.LandlordRoomService;

/**
 * Servlet implementation class UpdateListingServlet
 */
@WebServlet("/updateListing")
@MultipartConfig
public class UpdateListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateListingServlet() {
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
	
		String idParameter = request.getParameter("id");
	    System.out.println("Raw id parameter value: " + idParameter);

	    int id = Integer.parseInt(idParameter);
	    System.out.println("Parsed id: " + id);
		
	    String title = request.getParameter("title");
		System.out.println("title:" + title);
		
		String description = request.getParameter("description");
		System.out.println("description:" + description);
		
		int price = Integer.parseInt((request.getParameter("price")));
		int bond = Integer.parseInt((request.getParameter("bond")));
		int squareArea = Integer.parseInt((request.getParameter("squareArea")));
		int capacity = Integer.parseInt((request.getParameter("capacity")));
		int countBed = Integer.parseInt((request.getParameter("countBed")));
		int countBath = Integer.parseInt((request.getParameter("countBath")));
		String availableDate = request.getParameter("availableDate");

		String initialImage1 = request.getParameter("initialImage1");
		String initialImage2 = request.getParameter("initialImage2");
		String initialImage3 = request.getParameter("initialImage3");
		String initialImage4 = request.getParameter("initialImage4");
		
		System.out.println("initialImage1:" + initialImage1);
		System.out.println("initialImage2:" + initialImage2);
		System.out.println("initialImage3:" + initialImage3);
		System.out.println("initialImage4:" + initialImage4);

		Part image1 = request.getPart("image1");
		Part image2 = request.getPart("image2");
		Part image3 = request.getPart("image3");
		Part image4 = request.getPart("image4");

		String image1Url;
		String image2Url;
		String image3Url;
		String image4Url;

		String rootPathString = MyConstant.IMAGE_ROOT_PATH;

		if (image1 != null && image1.getSize() > 0) {

			String image1Name = getSubmittedFileName(image1);
			String image1UploadPath = rootPathString + image1Name;
			image1Url = "img/" + image1Name;

			FileOutputStream fos1 = new FileOutputStream(image1UploadPath);
			InputStream is1 = image1.getInputStream();

			byte[] data1 = new byte[is1.available()];
			is1.read(data1);
			fos1.write(data1);
			fos1.close();
			is1.close();

		} else {
			image1Url = initialImage1;

		}

		if (image2 != null && image2.getSize() > 0) {
			String image2Name = getSubmittedFileName(image2);
			String image2UploadPath = rootPathString + image2Name;
			image2Url = "img/" + image2Name;

			FileOutputStream fos2 = new FileOutputStream(image2UploadPath);
			InputStream is2 = image2.getInputStream();

			byte[] data2 = new byte[is2.available()];
			is2.read(data2);
			fos2.write(data2);
			fos2.close();
			is2.close();

		} else {
			image2Url = initialImage2;

		}

		if (image3 != null && image3.getSize() > 0) {
			String image3Name = getSubmittedFileName(image3);
			String image3UploadPath = rootPathString + image3Name;
			image3Url = "img/" + image3Name;

			FileOutputStream fos3 = new FileOutputStream(image3UploadPath);
			InputStream is3 = image3.getInputStream();

			byte[] data3 = new byte[is3.available()];
			is3.read(data3);
			fos3.write(data3);
			fos3.close();
			is3.close();
		} else {
			image3Url = initialImage3;

		}

		if (image4 != null && image4.getSize() > 0) {
			String image4Name = getSubmittedFileName(image4);
			String image4UploadPath = rootPathString + image4Name;
			image4Url = "img/" + image4Name;

			FileOutputStream fos4 = new FileOutputStream(image4UploadPath);
			InputStream is4 = image4.getInputStream();

			byte[] data4 = new byte[is4.available()];
			is4.read(data4);
			fos4.write(data4);
			fos4.close();
			is4.close();

		} else {
			image4Url = initialImage4;

		}

		try {

			Room room = new Room(id, title, description, price, bond, squareArea, capacity, countBed, countBath,
					availableDate, image1Url, image2Url, image3Url, image4Url);

			LandlordRoomService landlordRoomService = new LandlordRoomService();

			if (landlordRoomService.updateRoom(room)) {
				String updateRoomSuccessfulMessage = "Your listing has been successfully updated.";
				request.setAttribute("updateRoomSuccessfulMessage", updateRoomSuccessfulMessage);
				RequestDispatcher rd = request.getRequestDispatcher("landlordRoom?TYPE=AVAILABLE&roomId=" + id);
				rd.forward(request, response);

			} else {
				String updateRoomUnsuccessfulMessage = "There was an error, please try again!";
				request.setAttribute("updateRoomUnsuccessfulMessage", updateRoomUnsuccessfulMessage);
				RequestDispatcher rd = request.getRequestDispatcher("landlord-update-listing.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
