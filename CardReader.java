package cardReader;

public class CardReader {
	//Attributes
	private String lastName;
	private String firstName;
	private int studentNumber;
	
	

	//Constructor with four parameters for arguments.
	public CardReader(String lastName, String firstName,  int studentNumber){
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentNumber = studentNumber;
		
	}

	
	//All setters and getters.
	

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

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	//Override with a String
	@Override
	public String toString(){
		return "Card Information [First Name]: " + firstName + ",  [Last Name]: " + lastName + ", [Student CIN]:" + studentNumber;
	}
	
}
