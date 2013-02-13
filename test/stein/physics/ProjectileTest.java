package stein.physics;

//import static is to call static methods of class without specifying class
//put cursor on assertEquals and do ctrl-shift-m to import static methods of class...
import static org.junit.Assert.*;

import org.junit.Test;

//same package, different folders

public class ProjectileTest {
	
	//test methods, not getters and setters
	//test with different kinds of input
	
	@Test//annotations, the @ symbol
	public void testGetX(){
		Projectile p=new Projectile(37,73);
		assertEquals(291.5,p.getX(5),.1);
		
		Projectile p2=new Projectile(-323,73);
		assertEquals(291.5,p2.getX(5),.1);
	}
	
	@Test
	public void testGetY(){
		Projectile p=new Projectile(37,73);
		assertEquals(97.1,p.getY(5),.1);
		
		Projectile p2=new Projectile(-323,73);
		assertEquals(97.1,p2.getY(5),.1);
	}
}
