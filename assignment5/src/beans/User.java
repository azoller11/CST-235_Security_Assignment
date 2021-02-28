package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@ManagedBean
@SessionScoped
public class User {
	@NotNull() 
	@Size(min=5, max=15) 
	private String firstName;
	@NotNull() 
	@Size(min=5, max=15) 
	private String lastName;
	
	public User() {
		
		firstName = "Alex";
		lastName = "Zoller";
	}
	
	@PostConstruct
	public void init() {
		// Get the logged in Principle
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if(principle == null)
			{
				setFirstName("Unknown");
				setLastName("");
			}
			else
			{
				setFirstName(principle.getName());
				setLastName("");
			}

	}
	
	public String onFlash() {
		//Get the user value from the input form;
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		System.out.println("You clicked the flash button: " + user.getFirstName() +" " + user.getLastName());
		
		// Send the information to the POST request
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		FacesContext.getCurrentInstance().getExternalContext().getFlash();
		//To open  new page after the button is hit, return the file name of the desired page
		return "TestResponse.xhtml";
		    //return "TestResponse.xhtml?faces-redirect=true";
		}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
