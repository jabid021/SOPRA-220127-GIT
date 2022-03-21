package musicien;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musicien.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run();
		ctx.close();

	}

}
