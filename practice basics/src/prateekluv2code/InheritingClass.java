package prateekluv2code;

public class InheritingClass {
	private String address;
	public String teamName;
	
	public void hellomethod() {
		System.out.println("hello");
	}
	
	public InheritingClass() {
		
	}
	
	public InheritingClass(String address, String teamName) {
		this.address = address;
		this.teamName = teamName;
	}
	
	public void printing() {
		System.out.println("address: "+ address);
	}
	
	public void adding() {
		int x=5;
		int y=6;
		System.out.println(x+y);
		
	}

}
