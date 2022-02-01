package com.gmail.yoshzawa.openid;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/openidSignIn" })

public final class Jc21MSOpenidSigninServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String url = null;
		String localAddr = req.getLocalAddr();
		if(localAddr.substring(0,3).contentEquals("192")) {
			// Production
			url = getProductionLoginUrl();
		} else {
			// Local development server
			url = getDevelopLoginUrl();

		}

		if (url != null) {
			resp.sendRedirect(url);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp5/property/propertyError.jsp");
			rd.forward(req, resp);
		}

	}

	private String getDevelopLoginUrl() {
		String url = null;
		String AzureAppIdLocal = "d4da0c84-8f9e-400c-bbcb-fa6dcc59bbfd";
		if (AzureAppIdLocal != null) {
			url = "https://login.microsoftonline.com/organizations/oauth2/v2.0/authorize";
			url += "?client_id=" + AzureAppIdLocal;
			url += "&response_type=id_token";
			url += "&redirec_uri=http%3A%2F%2Flocalhost%3A8080%2FR03Team06%2Fmsredirect";
			url += "&response_mode=form_post";
			url += "&scope=openid%20profile";
			url += "&state=12345";
			url += "&nonce=678910";
		}
		return url;
	}

	private String getProductionLoginUrl() {
		String url = null;
		String AzureAppId = null;
		if (AzureAppId != null) {
			url = "https://login.microsoftonline.com/organizations/oauth2/v2.0/authorize";
			url += "?client_id=" + AzureAppId;
			url += "&response_type=id_token";
			url += "&redirec_uri=https%3A%2F%2Ffegogo.fivepro.xyz%2Fmsredirect";
			url += "&response_mode=form_post";
			url += "&scope=openid%20profile";
			url += "&state=12345";
			url += "&nonce=678910";
		}
		return url;
	}
}
