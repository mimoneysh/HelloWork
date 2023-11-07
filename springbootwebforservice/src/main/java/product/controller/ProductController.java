package product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@GetMapping("/prod")
	public ResponseEntity<Integer> multiply(@RequestParam int x,@RequestParam int y)
	{
		ResponseEntity<Integer> responseEntity=new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
		
		int result =0;
		if( x > 0 && y > 0)
		{
			result = x *y;
			responseEntity=new ResponseEntity<Integer>(result,HttpStatus.OK);
		
		}
		return responseEntity;
	}

}
