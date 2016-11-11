package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import model.Person;

public class DateConvertAction extends ActionSupport implements ModelDriven<Person>{

	private static final long serialVersionUID = 1L;
	private Person person;
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("ƒÍ¡‰"+person.getAge());
		System.out.println("…˙»’"+person.getBirth());
		return SUCCESS;
	}


	@Override
	public Person getModel() {
		person = new Person();
		return person;
	}
	
	
	
}
