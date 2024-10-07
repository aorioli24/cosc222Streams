
public class Course {
	private String number;
	private String title;
	private String description;
	private String prerequisites;
	
	
	public Course(String number, String title, String description, String prerequisites) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.prerequisites = prerequisites;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getPrerequisites() {
		return prerequisites;
	}
	
	public String toString() {
		return number + " " + title + "\n" + description + "\nPrerequisite: " + prerequisites;
	}

}
