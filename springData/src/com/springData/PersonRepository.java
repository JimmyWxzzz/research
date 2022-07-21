package com.springData;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@RepositoryDefinition(domainClass=Person.class, idClass=Integer.class)
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>, PersonDAO{
	
	Person getByLastName(String lastName);
	
	List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);
	
	List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);
	
	List<Person> getByEmailInAndBirthLessThan (List<String> emails, Date birth);
	
	List<Person> getByAddressIdGreaterThan(Integer id);
	
	@Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2)")
	Person getMaxIdPerson();
	
	@Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
	List<Person> testQueryAnnotationOrdered(String lastName, String email);
	
	@Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
	List<Person> testQueryAnnotation(@Param("email")String e, @Param("lastName")String l);
	
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2%")
	List<Person> testQueryAnnotationLike(String lastName, String email);
	
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %:lastName% OR p.email LIKE %:email%")
	List<Person> testQueryAnnotationLikeWithPerc(@Param("email")String e, @Param("lastName")String l);
	
	@Query(value="SELECT count(id) FROM jpa_persons", nativeQuery=true)
	long getTotalCount();
	
	@Modifying
	@Query("UPDATE Person p Set p.email= :email WHERE id = :id")
	void updatePersonEmail(@Param("id")Integer id,@Param("email") String email);

}
