package sut.se.team11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.BuyItem;
import sut.se.team11.repository.BuyItemRepository;

import javax.persistence.PersistenceException;
import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BuyItemTest {
    @Autowired
    private BuyItemRepository buyItemRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

//    บันทึกข้อมูลได้ปกติ
    @Test
    public void testInsertNormalCase(){
        BuyItem b1 = new BuyItem();
        b1.setItemName("AAAAA");
        b1.setPrice(150.0);
        b1.setAmount(10);
        b1.setTotalPrice(1500.0);

        try{
            entityManager.persist(b1);
            entityManager.flush();

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("============Test Insert Normal Sprint1 BuyItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            fail("Should not pass to this line");

            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);
        }
    }

    // ใส่ Null
    @Test
    public void testItemNameMustBeNotNull(){
        BuyItem b2 = new BuyItem();
        b2.setItemName(null);
        b2.setPrice(150.0);
        b2.setAmount(10);
        b2.setTotalPrice(1500.0);

        try{
            entityManager.persist(b2);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test NotNull Sprint1 BuyItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");
        }
    }

    // Pattern ผิด
    @Test
    public void testItemNameIncorrectPattern(){
        BuyItem b3 = new BuyItem();
        b3.setItemName("ASD555");
        b3.setPrice(150.0);
        b3.setAmount(10);
        b3.setTotalPrice(1500.0);

        try{
            entityManager.persist(b3);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test Incorrect Pattern Sprint1 BuyItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");
        }
    }

    //ขนาดเกิน Over Size
    @Test
    public void testItemNameOverSize(){
        BuyItem b4 = new BuyItem();
        b4.setItemName("AAAAAAAAAAAAAAAAA");
        b4.setPrice(150.0);
        b4.setAmount(10);
        b4.setTotalPrice(1500.0);

        try{
            entityManager.persist(b4);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test Over Size Sprint1 BuyItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");
        }
    }

    //ขนาดไม่ถึง Less Size
    @Test
    public void testItemNameLessThanSize(){
        BuyItem b5 = new BuyItem();
        b5.setItemName("AAA");
        b5.setPrice(150.0);
        b5.setAmount(10);
        b5.setTotalPrice(1500.0);

        try{
            entityManager.persist(b5);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test Less Than Size Sprint1 BuyItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");
        }
    }

    // Test ข้อมูลซ้ำ
    @Test(expected=javax.persistence.PersistenceException.class)
    public void testDataUnique(){
        BuyItem b6 = new BuyItem();
        b6.setBuyItemId(50L);
        b6.setItemName("AAAAAA");
        b6.setPrice(150.0);
        b6.setAmount(10);
        b6.setTotalPrice(1500.0);
        entityManager.persist(b6);
        entityManager.flush();

        BuyItem b7 = new BuyItem();
        b7.setBuyItemId(50L);
        b7.setItemName("AAAAA");
        b7.setPrice(1500.0);
        b7.setAmount(100);
        b7.setTotalPrice(15000.0);
        entityManager.persist(b7);
        entityManager.flush();

        System.out.println("\n\n");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("============Test Unique Sprint1 BuyItem============");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\n\n");
        fail("Should not pass to this line");
    }
}
