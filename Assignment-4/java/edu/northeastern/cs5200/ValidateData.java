package edu.northeastern.cs5200;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.*;
import edu.northeastern.cs5200.daos.UniversityDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateData {
	@Autowired
	UniversityDao ud;
	
	@Test
	public void validationUser() {
		int n = 9;
		List<Person> users = ud.findAllPersons();
		assert(n==users.size());
	}
	
	@Test
	public void validationFaculty() {
		int n = 2;
		List<Faculty> users = ud.findAllFaculty();
		assert(n==users.size());
	}
	
	@Test
	public void validationStudent() {
		int n = 7;
		List<Student> users = ud.findAllStudents();
		assert(n==users.size());
	}
	
	@Test
	public void validationCourse() {
		int n = 4;
		List<Course> users = ud.findAllCourses();
		assert(n==users.size());
	}
	
	@Test
	public void validationSection() {
		int n = 4;
		List<Section> users = ud.findAllSections();
		assert(n==users.size());
	}
	
	@Test
	public void validationAuthor() {
		System.out.println("validationAuthor");
		List<Faculty> faculties = ud.findAllFaculty();
		for(Faculty f:faculties) {
			System.out.printf("Faculty "+ f.getFirstName()+" "+f.getLastName()+
					" authors %d courses.%n",f.getAuthoredCourses().size());
		}
	}
	
	@Test
	public void testSectionEachCourse() {
		System.out.println("testSectionEachCourse");
		List<Course> courses = ud.findAllCourses();
		for(Course c:courses) {
			System.out.printf("Course "+c.getLabel()+" has %d sections%n", c.getCourseSections().size());
		}
	}
	
	@Test
	public void testStudentEachSection() {
		System.out.println("testStudentEachSection");
		List<Section> sections = ud.findAllSections();
		for(Section s:sections) {
			System.out.printf("Section "+s.getTitle()+" is enrolled by %d students%n", s.getHadEnrollments().size());
		}
	}
	
	@Test
	public void testSectionEachStudent() {
		System.out.println("testSectionEachStudent");
		List<Student> students = ud.findAllStudents();
		for(Student s:students) {
			System.out.printf("Student "+s.getFirstName()+" "+s.getLastName()+" has %d sections%n", s.getHadEnrollments().size());
		}
	}
	
	@Test
	public void testSeatsEachSection() {
		System.out.println("testSeatsEachSection");
		List<Section> sections = ud.findAllSections();
		for(Section s:sections) {
			System.out.printf("Section "+s.getTitle()+"has %d seats%n", s.getSeats());
		}
	}
}