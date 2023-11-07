package add.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Controller is a slave to the service..

@RestController // this is a cousin of @component.
public class AddController {
	
	//kids likes always logic first.. adults tell logic last..
	
	@GetMapping("/stepbystep")  // app.get("/stepbystep",(req,res)=>{});
	public int sum(@RequestParam int x,@RequestParam int y)  //req.query.x ..  
	{
		
		System.out.println(x+  " did we get input correct " +y);
		return 44;//kid is screaming
		//how can you tell 44, x and y should
		//be added hey kid relax for sometime..just see 44 reaches
		//as http esponse first.
		
		
	}

}
