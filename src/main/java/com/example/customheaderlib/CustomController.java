/**
 * 
 */
package com.example.customheaderlib;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sridhar
 *
 */
@RestController
public class CustomController {

	@GetMapping("/home")
	public String home() {
		return "Home";
	}
}
