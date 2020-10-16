/**
 * 
 */
package com.example.customheaderlib;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomOncePerRequestFilter extends OncePerRequestFilter{

	private static final String HEADER = "veryimportantheader";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterchain)
			throws ServletException, IOException {
		Optional<String> header = Optional.ofNullable(request.getHeader(HEADER));
		System.out.println(header.toString());
		if(header.isEmpty()) {
			response.addHeader(HEADER, UUID.randomUUID().toString());
		}
		filterchain.doFilter(request, response);
	}

}
