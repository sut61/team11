package sut.se.team11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.BuyItem;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.SaleItem;
import sut.se.team11.repository.SaleItemRepository;

import javax.validation.*;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SaleItemTest {
    @Autowired
    private SaleItemRepository saleItemRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private Customer customer;
    private Employee employee;
    private BuyItem buyItem;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //    บันทึกข้อมูลได้ปกติ
    @Test
    public void testInsertNormalCase(){
        SaleItem s1 = new SaleItem();
        s1.setPrice(100.0);
        s1.setAmount(10);
        s1.setTotalPrice(1000.0);
        s1.setCustomer(customer);
        s1.setDate(new Date());

        entityManager.persist(s1);
        // entityManager.flush();

        System.out.println("\n");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("============Test1 Insert Normal Sprint1 SaleItem============");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\n");
    }



    // Test ข้อมูลซ้ำ
    @Test(expected=javax.persistence.PersistenceException.class)
    public void testDataUnique(){
        SaleItem s2 = new SaleItem();
        s2.setSaleItemId(50L);
        s2.setPrice(100);
        s2.setAmount(10);
        s2.setTotalPrice(1000);
        s2.setCustomer(customer);
        entityManager.persist(s2);
        entityManager.flush();

        SaleItem s3 = new SaleItem();
        s3.setSaleItemId(50L);
        s3.setPrice(100);
        s3.setAmount(10);
        s3.setTotalPrice(1000);
        s3.setCustomer(customer);
        entityManager.persist(s3);
        entityManager.flush();

        System.out.println("\n");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("============Test2 Unique Sprint1 SaleItem============");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\n");
        fail("Should not pass to this line");
    }

    @Test //test Double > 1,000,000
    public void testDoubleOutOfBoundSaleItem() {
        SaleItem s4 = new SaleItem();
        s4.setPrice(102213522152.20);
        s4.setAmount(10);
        s4.setCustomer(customer);
        try {
            entityManager.persist(s4);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ==================Test3 DoubleOutOfBoundSaleItem Sprint1 SaleItem==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }



    @Test // test Double ติดลบ หรือ น้อยกว่า 0
    public void testDoubleNegativeValueSaleItem() {
        SaleItem s5 = new SaleItem();
        s5.setPrice(-1.12);
        s5.setAmount(10);
        s5.setCustomer(customer);
        try {
            entityManager.persist(s5);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ==================TEST 4 testDoubleNegativeValueSaleItem Sprint1 SaleItem==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test //test Double ทศนิยมเป็น 2 ตำเเหน่ง
    public void testDecimalOutOfBoundSaleItem() {
        SaleItem s6 = new SaleItem();
        s6.setPrice(1234567.9871);
        s6.setAmount(10);
        s6.setCustomer(customer);

        try {
            entityManager.persist(s6);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ==================TEST 5 testDecimalOutOfBoundSaleItem Sprint1 SaleItem==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }


    @Test //testCustomerNotNull
    public void testCustomerNotNull() {
        SaleItem s7 = new SaleItem();
        s7.setPrice(100.0);
        s7.setAmount(10);
        s7.setCustomer(null);
        try {
            entityManager.persist(s7);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ==================TEST 6 testCustomerNotNull Sprint1 SaleItem==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test //testEmployeeNotNull
    public void testEmployeeNotNull() {
        SaleItem s8 = new SaleItem();
        s8.setPrice(100.0);
        s8.setAmount(10);
        s8.setEmployee(null);
        try {
            entityManager.persist(s8);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ==================TEST 6 testEmployeeNotNull Sprint1 SaleItem==================== ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }
}
