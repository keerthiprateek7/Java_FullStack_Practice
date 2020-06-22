package springPractice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FinalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach=context.getBean("trainingTips", Coach.class);
		
		//call method
		System.out.println(theCoach.getDailyWorkouts());
		System.out.println(theCoach.getDailyFortune());
				
				
		// close the context
		context.close();
	}

}
