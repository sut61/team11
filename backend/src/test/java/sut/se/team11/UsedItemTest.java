package sut.se.team11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.UsedItem;
import sut.se.team11.repository.UsedItemRepository;

import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsedItemTest {
    @Autowired
    private UsedItemRepository usedItemRepository;
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
        UsedItem u1 = new UsedItem();
        u1.setPrice(100.0);
        u1.setDetails("AAAAAAAAAAA");

        try{
            entityManager.persist(u1);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("============Test Insert Normal Sprint2 UsedItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");

            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);
        }
    }

    // Pattern ผิด
    @Test
    public void testDetailsIncorrectPattern(){
        UsedItem u2 = new UsedItem();
        u2.setPrice(100.0);
        u2.setDetails("AAAAAAAAAAA*****");

        try{
            entityManager.persist(u2);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test Incorrect Pattern Sprint2 UsedItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");

            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);
        }
    }

    //ขนาดเกิน Over Size
    @Test
    public void testDetailsOverSize(){
        UsedItem u3 = new UsedItem();
        u3.setPrice(100.0);
        u3.setDetails("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");

        try{
            entityManager.persist(u3);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test Over Size Sprint2 UsedItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");

            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),2);
        }
    }

    //ขนาดไม่ถึง Less Size
    @Test
    public void testDetailsLessThanSize(){
        UsedItem u4 = new UsedItem();
        u4.setPrice(100.0);
        u4.setDetails("AAA");

        try{
            entityManager.persist(u4);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test Less Than Size Sprint2 UsedItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");

            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),2);
        }
    }

    // ใส่ Null
    @Test
    public void testDetailsMustBeNotNull(){
        UsedItem u5 = new UsedItem();
        u5.setPrice(100.0);
        u5.setDetails(null);

        try{
            entityManager.persist(u5);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(e + "============Test NotNull Sprint2 UsedItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");

            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),1);
        }
    }

    // Test ข้อมูลซ้ำ
    @Test(expected=javax.persistence.PersistenceException.class)
    public void testDataUnique(){
        UsedItem u6 = new UsedItem();
        u6.setUsedItemId(55L);
        u6.setPrice(100.0);
        u6.setDetails("AAAAAAAAAAA");
        entityManager.persist(u6);
        entityManager.flush();

        UsedItem u7 = new UsedItem();
        u7.setUsedItemId(55L);
        u7.setPrice(100.0);
        u7.setDetails("AAAAAAAAAAA");
        entityManager.persist(u7);
        entityManager.flush();

        System.out.println("\n\n");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("============Test Unique Sprint2 UsedItem============");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\n\n");
        fail("Should not pass to this line");
    }
}
