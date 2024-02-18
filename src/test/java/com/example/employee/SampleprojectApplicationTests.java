package com.example.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

import java.util.List;

@SpringBootTest
class SampleprojectApplicationTests {
	
	@Autowired
	EmployeeRepository Erepo;

	@Test
	public void testCreate() {
		
		Employee e = new Employee();
		e.setId(1L);
		e.setFirstName("Rahul");
		e.setLastName("Presad");
		e.setEmail("rp@gmail.com");
		Erepo.save(e);
		assertNotNull(Erepo.findById(20L).get());
		
	}
	
	@Test
	public void testReadAll() {
		List<Employee> list = Erepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testSingleEmp()
	{
		Employee emp = Erepo.findById(15L).get();
		assertEquals("Amal",emp.getFirstName());
	}
	
	@Test
	public void testUpdate() {
		Employee e = Erepo.findById(19L).get();
		e.setEmail("nps@gmail.com");
		Erepo.save(e);
		assertNotEquals("rp@gmail.com", Erepo.findById(19L).get().getEmail());	
	}
	
	@Test
	public void testDelete() {
		Erepo.deleteById(14L);
		assertThat(Erepo.existsById(14L)).isFalse();
	}

}
