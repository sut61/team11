package sut.se.team11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.junit.Before;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Employee;
import sut.se.team11.repository.CustomerRepository;
import sut.se.team11.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application.properties")
public class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("dd-MM-yyyy");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void TestEmployee(){
        Employee employee = new Employee();

        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("0955255545");
        employee.setAddress("NYC");

        entityManager.persist(employee);
        entityManager.flush();

        System.out.println("....................Sprint 1 Test.................");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" 1. Employee Information Correct ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

    }
    @Test
    public void testEmployeeAgeMin() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(8);
        employee.setTel("0955255545");
        employee.setBDate(new Date());
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("2. Enter Age information that is lower than min.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeAgeMax() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(71);
        employee.setTel("0955255545");
        employee.setBDate(new Date());
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("3. Enter Age information that is higher than max.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeAgePositive() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(-71);
        employee.setTel("0955255545");
        employee.setBDate(new Date());
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("4. Enter Age information should be positive.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeTelNotNull() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel(null);
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("5. Warning!!!  Don't enter null");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeWrongPattern() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("08259ddddd");
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("6. Got Wrong Pattern, pleas try again!!!");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeTelSizeShorter() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("08236958");
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("7. Size is shorter than limit");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeTelSizeHigher() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("082369585896");
        employee.setAddress("NYC");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("8. Size is higher than limit");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeAddressNull() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("08236958");
        employee.setAddress(null);
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("9. Should not enter null for Address ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeAddressMin() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("08236958");
        employee.setAddress("ka");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("10. Size of address is shorter than limit ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testEmployeeAddressMax() {
        Employee employee = new Employee();
        employee.setTitle("Mr.");
        employee.setEName("Robert Pattinson");
        employee.setAge(36);
        employee.setBDate(new Date());
        employee.setTel("08236958");
        employee.setAddress("kapppppppppppppppppppppppppppppllpppppp");
        try {
            entityManager.persist(employee);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("11. Size of address is higher than limit ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
}
