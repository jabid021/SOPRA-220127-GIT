package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.config.Config;

public class AppTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
		Travailleur emp= ctx.getBean(Travailleur.class);
		System.out.println(emp.getDepartement());
		ctx.close();
	}

}
