import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Courses {
	private List<Course> courses;
	
	public Courses() {
		this.courses = new ArrayList<>();
		loadSampleData();
	}
	
	private void loadSampleData() {
		courses.add(new Course("COSC 222", 
				"Data Strcutures", 
				"Introduction to the design, implementation and analysis of data structures. " 
				+ "Topics will include lists, stacks, queues, trees, and graphs. [3-2-0]", 
				"A score of 60% or higher in COSC 121."));
	}
	
	public void displayCourse(String number) {
		courses.stream()
		.filter(course -> course.getNumber().equals(number))
		.findFirst()
		.ifPresent(System.out::println);
	}
	
	public Iterator<Course> listAllIter(){
		return courses.iterator();
	}
	
	public List<Course> listAllStream(){
		return courses.stream().collect(Collectors.toList());
	}
	
	public long countCourses() {
		return courses.stream().count();
	}
	
	public List<Course> listCoursesWithDatabase() {
		return courses.stream()
				.filter(course -> course.getDescription().toLowerCase().contains("database"))
				.collect(Collectors.toList());
	}
	
	public List<Course> listAllSortedByNumber() {
		return courses.stream()
				.sorted((c1, c2) -> c1.getNumber().compareTo(c2.getNumber()))
				.collect(Collectors.toList());
		
	}
	

}
