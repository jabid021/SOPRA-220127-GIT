package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		Travailleur emp= ctx.getBean(Travailleur.class);
		System.out.println(emp.getDepartement().getNom());
		ctx.close();
	}

}
