package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class NumberBean {

	private int number = 3;
	
	public int getNumber() {
		return number;
	}
	
	public void increase() {
		number++;
	}
}
