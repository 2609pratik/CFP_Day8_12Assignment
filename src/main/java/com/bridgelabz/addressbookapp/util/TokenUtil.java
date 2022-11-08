package com.bridgelabz.addressbookapp.util;


import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.AssertingParty.Verification;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class TokenUtil {


	private static final String TOKEN_SECRET = "BOND007";


	public String createToken(int id)   {
	       try {
	        //to set algorithm
	        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
	    
	 
	        String token = JWT.create()
	        .withClaim("user_id", id)
	        .sign(algorithm);
	        return token;
	        
	        } catch (JWTCreationException exception) {
	        exception.printStackTrace();
	           //log Token Signing Failed
	        } catch (IllegalArgumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	       return null;
	 }


	/**
	* @param token
	* @return
	*/
	public int decodeToken(String token)
	 {
	 int userid;
	           //for verification algorithm
	           Verification verification = null;
	try {
		verification = (Verification) JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
	} catch (IllegalArgumentException  e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	           JWTVerifier jwtverifier=((com.auth0.jwt.interfaces.Verification) verification).build();
	           //to decode token
	           DecodedJWT decodedjwt=jwtverifier.verify(token);

	           Claim claim=decodedjwt.getClaim("user_id");
	           userid=claim.asInt();    
	           return userid;
	     
	 }


}