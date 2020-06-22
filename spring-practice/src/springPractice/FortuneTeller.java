package springPractice;

import org.springframework.stereotype.Component;

@Component
public class FortuneTeller implements FortuneService {

	@Override
	public String FortuneTeller() {
		return "Try hard until u succeed";
	}

}
