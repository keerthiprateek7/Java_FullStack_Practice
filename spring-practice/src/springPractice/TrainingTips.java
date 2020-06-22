package springPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("trainingTips")
public class TrainingTips implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	public TrainingTips(FortuneService thefortuneService) {
		fortuneService=thefortuneService;
	}
	
	//define my init method
	public void Starting() {
		System.out.println("inside startin function");
	}
	
	//define my init method
	public void ending() {
		System.out.println("inside startin function");
	}

	@Override
	public String getDailyWorkouts() {
		return "Practice makes man perfect";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.FortuneTeller();
	
	/* this method is used when ur using prototype scope
	@Override
	public void destroy() throws Exception {
	System.out.println(">> TennisCoach: inside destroy()");
	} */
	}
}
