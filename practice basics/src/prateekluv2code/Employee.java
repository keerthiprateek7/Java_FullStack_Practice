package prateekluv2code;

public class Employee {
	public int id;
	public String name;
	public InheritingClass inherit;
	
	{
		System.out.println("normal block");
	}
	
	static{
		System.out.println("static block");
	}
	
	public Employee() {
		System.out.println("calling no parameterized constructor");
	}
	
	

	public Employee(int id, String name,String address,String teamName) {
		
		inherit = new InheritingClass();
		//super(address,teamName);
		//super.adding();
		this.id = id;
		this.name = name;
	}
	
	public void printing() {
		//super.printing();
		//System.out.println("id: "+id + "name: "+ name + "teamName: "+ teamName);
	}
	
	public void mult() {
		System.out.println("entering mult method");
		//super.hellomethod();
		inherit.hellomethod();
	}
	
}
