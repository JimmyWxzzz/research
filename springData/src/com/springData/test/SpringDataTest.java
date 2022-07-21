package com.springData.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.springData.Person;
import com.springData.PersonRepository;
import com.springData.PersonService;

class SpringDataTest {
	
	private ApplicationContext ctx = null;
	private PersonRepository rep = null;
	private PersonService service;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rep = ctx.getBean(PersonRepository.class);
		service = ctx.getBean(PersonService.class);
	}
	
	@Test
	public void testManyToOne() {
		
		List<Person> persons = rep.getByAddressIdGreaterThan(0);
		
		System.out.println(persons);
		
	}
	
	@Test
	public void testNativeQuery() {
		long count = rep.getTotalCount();
		System.out.println(count);
	}
	@Test
	public void testQuery() {
		Person persons = rep.getMaxIdPerson();
		System.out.println(persons);
	}
	
	@Test
	public void testQueryWithParamOrdered() {
		List<Person> persons = rep.testQueryAnnotation("bb@gmail.com", "bb");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryWithLike() {
//		List<Person> persons = rep.testQueryAnnotationLike("a", "bb");
//		System.out.println(persons);
//		
		List<Person> persons = rep.testQueryAnnotationLikeWithPerc("bb", "a");
		System.out.println(persons.size());
	}
	
	@Test
	public void testQueryWithParam() {
		List<Person> persons = rep.testQueryAnnotationOrdered("bb", "bb@gmail.com");
		System.out.println(persons);
	}
	
	@Test
	public void testKeyWords() {
		List<Person> persons = rep.getByLastNameStartingWithAndIdLessThan("c", 5);
		System.out.println(persons);
		persons = rep.getByLastNameEndingWithAndIdLessThan("f", 8);
		System.out.println(persons);
		persons = rep.getByEmailInAndBirthLessThan(Arrays.asList("aa@gmail.com","cc@gmail.com", "gg@gmail.com"), new Date());
		System.out.println(persons);
	}
	@Test
	public void testAccessEntry() {
		
		System.out.println(rep.getClass().getName());
		Person person = rep.getByLastName("a");
		System.out.println(person);
	}
	@Test
	public void testJpa() {
		
	}
	@Test
	void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testModifying() {
		//rep.updatePersonEmail(2, "aaaa@gmail.com");
		service.updatePersonEmail("aaaa@gmail.com", 2);
	}
	
	@Test
	public void testCrudRepository() {
		
		List<Person> persons = new ArrayList<>();
		
		for (int i = 'a'; i <= 'z'; i++) {
			Person person = new Person();
			person.setAddressID(i+1);
			person.setBirth(new Date());
			person.setEmail((char)i+ (char)i + "@gmail.com");
			person.setLastName((char)i + "" + (char)i);
			persons.add(person);
		}
		service.savePersons(persons);
	}
	
	@Test
	public void testPagingAndSortingRepository() {
		
		int pageNo = 3;
		int pageSize = 5;
		Order order1 = new Order(Direction.DESC,"id");
		Order order2 = new Order(Direction.ASC,"email");
		
		Sort sort = new Sort(order1, order2);
		
		PageRequest pageable = new PageRequest(pageNo, pageSize, sort);
		Page<Person> page = rep.findAll(pageable);
		
		System.out.println(page.getTotalElements());
		System.out.println(page.getNumber());
		System.out.println(page.getTotalPages());
		System.out.println(page.getContent());
		System.out.println(page.getNumberOfElements());
	}
	
	@Test
	public void testJpaRepository() {
		Person person = new Person();
		person.setBirth(new Date());
		person.setEmail("X13312@gmail.com");
		person.setLastName("XXXXXYYYZZZZ");
		person.setId(79);
		
		Person person2 = rep.saveAndFlush(person);
		
		System.out.println(person == person2);
	}
	
	@Test
	public void testJpaSpecificationExecutor() {
		
		int pageNo = 3;
		int pageSize = 5;
		PageRequest pageable = new PageRequest(pageNo, pageSize);
		
		Specification<Person> specification = new Specification<Person>() {

			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Path path = root.get("id");
				Predicate predicate = cb.gt(path, 5);
				return predicate;
			}
		};
			
		
		Page<Person> page = rep.findAll(specification, pageable);
		
		System.out.println(page.getTotalElements());
		System.out.println(page.getNumber());
		System.out.println(page.getTotalPages());
		System.out.println(page.getContent());
		System.out.println(page.getNumberOfElements());
	}
	
	@Test
	public void testCustomRepositoryMethod() {
		rep.test();
	}
}
