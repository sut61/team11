package sut.se.team11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.junit.Before;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.team11.entity.Branch;
import sut.se.team11.entity.Career;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Province;
import sut.se.team11.repository.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application.properties")
public class CustomerTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private CareerRepository careerRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testCustomer() {

        Customer customer = new Customer();
        Branch branch = branchRepository.findById(1);
        Career career = careerRepository.findById(5);
        Province province = provinceRepository.findById(10);

        customer.setAddress("211/11 หมู่ 11 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        customer.setTel("0215487562");
        customer.setCustomerName("AAAA");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);

        entityManager.persist(customer);
        entityManager.flush();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("0. Enter the correct information Customer. ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");


    }

    @Test
    public void testCustomerNull() {
        Customer customer = new Customer();
        Branch branch = branchRepository.findById(1);
        Career career = careerRepository.findById(5);
        Province province = provinceRepository.findById(10);
        customer.setCustomerName(null);
        customer.setAddress("211/11 หมู่ 11 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        customer.setTel("0215487562");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);



        try {
            entityManager.persist(customer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("1. Enter CustomerName null values");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test
    public void testCustomerSize() {
        Customer customer = new Customer();
        Branch branch = branchRepository.findById(1);
        Career career = careerRepository.findById(5);
        Province province = provinceRepository.findById(10);
        customer.setCustomerName("AAAA");
        customer.setAddress("211/11 หมู่ 11 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        customer.setTel("01251554151515");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);
        try {
            entityManager.persist(customer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("2. Enter Tel information that is longer than Size.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test
    public void testCustomerSizeNo() {
        Customer customer = new Customer();
        Branch branch = branchRepository.findById(1);
        Career career = careerRepository.findById(5);
        Province province = provinceRepository.findById(10);
        customer.setCustomerName("AAAA");
        customer.setAddress("211/11 หมู่ 11 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        customer.setTel("012");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);

        try {
            entityManager.persist(customer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("3. Enter Tel information that is shorter than the size.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    @Test
    public void testCustomerPattern() {
        Customer customer = new Customer();
        Branch branch = branchRepository.findById(1);
        Career career = careerRepository.findById(5);
        Province province = provinceRepository.findById(10);
        customer.setCustomerName("AAAA");
        customer.setAddress("211/11 หมู่ 11 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        customer.setTel("05sadasdasdg");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);

        try {
            entityManager.persist(customer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("4. Enter Tel different data from Pattern");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testCustomerUniqu() {

        Customer customer = new Customer();
        Branch branch = branchRepository.findById(1);
        Career career = careerRepository.findById(5);
        Province province = provinceRepository.findById(10);
        customer.setCustomerId((long)1);
        customer.setCustomerName("AAAA");
        customer.setAddress("211/11 หมู่ 11 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        customer.setTel("0215487562");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);

        customer.setCustomerId((long)2);
        customer.setCustomerName("AAAA");
        customer.setAddress("211/11");
        customer.setTel("0215487562");
        customer.setBranch(branch);
        customer.setCareer(career);
        customer.setProvince(province);

        try {
            entityManager.persist(customer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("5. Enter duplicate data");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }

    }


}
