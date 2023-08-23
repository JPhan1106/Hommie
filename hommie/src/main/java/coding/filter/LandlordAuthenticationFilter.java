package coding.filter;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({ "/landlordRoomList/", "/landlordRoom", "/landlordViewStudent", "/newListing", "/updateListing",
		"/landlord-available-room-details.jsp", "/landlord-home.jsp", "/landlord-listing.jsp",
		"/landlord-listing-management.jsp", "/landlord-rented-room-details.jsp", "/landlord-room-list.jsp",
		"/landlord-update-listing.jsp", "/landlord-view-student.jsp", "/payment.jsp", "/payment-history.jsp", "/succesful-payment.jsp" })
public class LandlordAuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {

	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpSession session = httpRequest.getSession(false);

	    boolean isLoggedIn = (session != null && session.getAttribute("landlordId") != null);

	    if (isLoggedIn) {
	        // Landlord is authenticated, allow the request to proceed to the intended
	        // resource.
	        chain.doFilter(request, response);
	    } else {
	        // Landlord is not authenticated, forward to the login page.
	        request.setAttribute("loginAsLandlordMessage", "Please log in as landlord!");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	        dispatcher.forward(request, response);
	    }
	}


	public LandlordAuthenticationFilter() {
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}