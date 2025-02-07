package com.gmail.yoshzawa.openid;

import java.io.IOException;
import org.apache.geronimo.mail.util.Base64;

import com.gmail.yoshzawa.openid.jwt.JwtHeader;
import com.gmail.yoshzawa.openid.jwt.JwtPayload;
import com.google.gson.Gson;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.Date;
import java.util.logging.Logger;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/msredirect", "/msredirect/" })

public final class Jc21MSRedirectServlet extends HttpServlet {



	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final Logger log = Logger.getLogger(Jc21MSRedirectServlet.class.getName());
		resp.setContentType("text/html");

		String id_token = req.getParameter("id_token");
		String state = req.getParameter("state");
		String error = req.getParameter("error");
		String error_description = req.getParameter("error_description");

		log.info("id_token = " + id_token);
		log.info("state = " + state);
		log.info("error = " + error);
		log.info("error_description = " + error_description);

		String[] tokens = id_token.split("\\.");

		String head = new String(Base64.decode(tokens[0]));
		log.info("head = " + head);
		Gson gson = new Gson();
		JwtHeader header = gson.fromJson(head, JwtHeader.class);
		log.info("typ = " + header.getTyp());
		log.info("alg = " + header.getAlg());
		log.info("kid = " + header.getKid());

		String s = tokens[1];
		switch (s.length() % 4) {
		case 0:
			break;
		case 1:
			s += "===";
			break;
		case 2:
			s += "==";
			break;
		case 3:
			s += "=";
			break;
		}

		String payload = new String(Base64.decode(s));
		log.info("payload = " + payload);
		JwtPayload body = gson.fromJson(payload + "", JwtPayload.class);
		log.info("aud = " + body.getAud());
		log.info("iss = " + body.getIss());
		log.info("iat = " + body.getIat());
		log.info("nbf = " + body.getNbf());
		log.info("name = " + body.getName());
		log.info("exp = " + body.getExp());
		log.info("nonce = " + body.getNonce());
		log.info("oid = " + body.getOid());
		String email = body.getPreferredUsername();
		log.info("preferred_username = " + email);
		log.info("sub = " + body.getSub());
		log.info("tid = " + body.getTid());
		log.info("ver = " + body.getVer());

		HttpSession session = req.getSession();
		session.setAttribute("email", email);

		resp.getWriter().println("<H1>Welcome," + email + "</h1>");
		resp.getWriter().println("<a href= http://localhost:8080/R03Team06/list >Continue</a>");

	}
}
