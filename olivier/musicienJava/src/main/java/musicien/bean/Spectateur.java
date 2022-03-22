package musicien.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {
	
	@Pointcut("execution(void musicien.bean.Musicien.perform())")
	void performMusicien() {
		
	}
	
	@Pointcut("execution(void musicien.bean.Guitariste.perform())")
	void performGuitariste() {
		
	}
	
	
	//execution( Retour CheminComplet packages.Class.methode(parametre))
	//* substitution d'un niveau
	//@Before("execution(void musicien.bean.Musicien.perform())")
	@Before("performMusicien()")
	public void installation() {
		System.out.println("les spectateurs s'installent");
	}
	
	@AfterReturning(pointcut = "execution(void musicien.bean.Musicien.perform())")
	public void applaudir() {
		System.out.println("bravo");
	}
	
	@AfterThrowing(pointcut = "performMusicien()")
	public void huer() {
		System.out.println("bouhhhh");
	}
	
	@After("performMusicien()")
	public void partir() {
		System.out.println("les spectateurs partent");
	}
}
