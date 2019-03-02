package sut.se.team11;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.Category;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.Quotation;
import sut.se.team11.repository.CategoryRepository;
import sut.se.team11.repository.CustomerRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.QuotationRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application.properties")

public class QuotationTest {

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    private Employee employee1;

    private Customer customer1;

    private Category category1;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test // ตรวจสอบว่าใส่ข้อมูลครบถ้วน  ------------------- ฟิลด์ Quotation -------------------------
    public void testQuotation() {
        Quotation quotation = new Quotation();

        quotation.setDate(new Date());
        quotation.setDetail("MMMMM");
        quotation.setPrice(98.12);


        entityManager.persist(quotation);
        entityManager.flush();


        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ================== Sprint1 TEST 1 ====================  ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    @Test // ตรวจสอบว่าใส่ข้อมูลผิดพลาด  ------------------- ฟิลด์ Detail -------------------------
    public void testQuotationNull() {
        Quotation quotation = new Quotation();


        quotation.setDate(new Date());
        quotation.setDetail(null);
        quotation.setPrice(98.12);


        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 2 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }


    @Test //test Double > 1,000,000  ------------------- ฟิลด์ Price -------------------------
    public void testDoubleOutOfBoundQuotation() {
        Quotation quotation = new Quotation();


        quotation.setDate(new Date());
        quotation.setDetail("MMMM");
        quotation.setPrice(9814253673539.12);

        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 3 ==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // test Double ติดลบ หรือ น้อยกว่า 0  ------------------- ฟิลด์ Price -------------------------
    public void testDoubleNegativeValueQuotation() {
        Quotation quotation = new Quotation();


        quotation.setDate(new Date());
        quotation.setDetail("MMMM");
        quotation.setPrice(-1.12);

        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 4 ==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test //test Double ทศนิยมเป็น 2 ตำเเหน่ง  ------------------- ฟิลด์ Price -------------------------
    public void testDecimalOutOfBoundQuotation() {
        Quotation quotation = new Quotation();

        quotation.setDate(new Date());
        quotation.setDetail("MMMM");
        quotation.setPrice(1234567.9871);


        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 5 ==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    @Test // ตรวจสอบ Null Employee   ------------------- ฟิลด์ Employee -------------------------
    public void testEmployee() {
        Quotation quotation = new Quotation();

        quotation.setDate(new Date());
        quotation.setDetail("MMMM");
        quotation.setPrice(1234567.9871);
        quotation.setEmployee(null);


        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 6 ==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    @Test // ตรวจสอบ Null Category   ------------------- ฟิลด์ Category -------------------------
    public void testCategory() {
        Quotation quotation = new Quotation();

        quotation.setDate(new Date());
        quotation.setDetail("MMMM");
        quotation.setPrice(1234567.9871);
        quotation.setCategory(null);


        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 7 ==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    @Test // ตรวจสอบ Null  Customer   ------------------- ฟิลด์ Customer -------------------------
    public void testCustomer() {
        Quotation quotation = new Quotation();

        quotation.setDate(new Date());
        quotation.setDetail("MMMM");
        quotation.setPrice(1234567.9871);
        quotation.setCustomer(null);


        try {
            entityManager.persist(quotation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint1 TEST 8 ==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }









}
