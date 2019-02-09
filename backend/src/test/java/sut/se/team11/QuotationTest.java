package sut.se.team11;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.Quotation;
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
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test // ตรวจสอบว่าใส่ข้อมูลครบถ้วน
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

    @Test // ตรวจสอบว่าใส่ข้อมูลผิดพลาด
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


    @Test //test Double > 1,000,000
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

    @Test // test Double ติดลบ หรือ น้อยกว่า 0
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

    @Test //test Double ทศนิยมเป็น 2 ตำเเหน่ง
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


}
