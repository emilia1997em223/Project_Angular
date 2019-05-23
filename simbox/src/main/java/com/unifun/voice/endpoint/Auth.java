package com.unifun.voice.endpoint;

import java.util.StringJoiner;

import javax.json.bind.JsonbBuilder;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.commons.codec.binary.Base64;
import org.jboss.logging.Logger;

@Path("/auth")
public class Auth {
	private static final Logger logger = Logger.getLogger(Auth.class);
	private String json_field = "\"%s\":\"%s\"";
	@POST
		public String getPost(String reqBody) {
			byte[] decoded = Base64.decodeBase64(reqBody);
			reqBody = new String(decoded).substring(3);
			int index = reqBody.indexOf(":");
			String username = reqBody.substring(0,index);
			String password = reqBody.substring(index+1);


			System.out.println("username: " + username);
			System.out.println("password: " + password);

			//TODO check if user and password is ok
			StringJoiner sj = new StringJoiner(",","{","}");
			sj.add(String.format(json_field, "status","ok"));
			sj.add(String.format(json_field, "token","123"));
			return JsonbBuilder.create().toJson(sj.toString());
	}

}
