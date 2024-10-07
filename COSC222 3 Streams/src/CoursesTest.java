import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class CoursesTest {
	
	@Test
	public void testMethodsReturnSameResult() {
		Courses courses = new Courses();
		
		List<Course> listAll = courses.listAllStream();
		Iterator<Course> iterator = courses.listAllIter();
		List<Course> listIter = new ArrayList<>();
		iterator.forEachRemaining(listIter::add);
		
		assertEquals(listAll.size(), listIter.size());
		for (int i = 0; i < listAll.size(); i++) {
			assertEquals(listAll.get(i), listIter.get(i));
		}
	}
	
	@Test
	public void testCountCourses() {
		Courses courses = new Courses();
		assertEquals(1, courses.countCourses());
	}
	
	@Test
	public void testListCoursesWithDatabase() {
		Courses courses = new Courses();
		List<Course> databaseCourses = courses.listCoursesWithDatabase();
		assertTrue(databaseCourses.isEmpty());		
	}
	
	@Test
	public void testListAllSortedByNumber() {
		Courses courses = new Courses();
		List<Course> sortedCourses = courses.listAllSortedByNumber();
		assertEquals("COSC 222", sortedCourses.get(0).getNumber());
	}

}
