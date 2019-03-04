package sut.se.team11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.Checks;
import sut.se.team11.entity.Repairman;
import sut.se.team11.entity.Stock;
import sut.se.team11.entity.UsedItem;
import sut.se.team11.repository.ChecksRepository;
import sut.se.team11.repository.RepairmanRepository;
import sut.se.team11.repository.StockRepository;
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

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private RepairmanRepository repairmanRepository;
    @Autowired
    private ChecksRepository checksRepository;

    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //    บันทึกข้อมูลได้ปกติ
    @Test
    public void testInsertNormalsCase(){
        UsedItem u11 = new UsedItem();
        Checks cks = checksRepository.findById(1);
        Repairman rpm = repairmanRepository.findById(1);
        Stock st = stockRepository.findById(1);
        u11.setPrice(500.0);
        u11.setDetails("AAAAAAAAAA");
        u11.setChecks(cks);
        u11.setRepairman(rpm);
        u11.setStock(st);

        try{

            entityManager.persist(u11);

            System.out.println("\n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("============Test Insert Normal Sprint2 UsedItem============");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("\n");

        }catch (javax.validation.ConstraintViolationException e){
            fail("Should not pass to this line");

        }
    }

    // Pattern ผิด
    @Test
    public void testDetailsIncorrectPattern(){
        UsedItem u2 = new UsedItem();
        Checks cks = checksRepository.findById(1);
        Repairman rpm = repairmanRepository.findById(1);
        Stock st = stockRepository.findById(1);
        u2.setPrice(500.0);
        u2.setChecks(cks);
        u2.setRepairman(rpm);
        u2.setStock(st);
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
        Checks cks = checksRepository.findById(1);
        Repairman rpm = repairmanRepository.findById(1);
        Stock st = stockRepository.findById(1);
        u3.setPrice(500.0);
        u3.setChecks(cks);
        u3.setRepairman(rpm);
        u3.setStock(st);
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
            assertEquals(violations.size(),1);
        }
    }

    //ขนาดไม่ถึง Less Size
    @Test
    public void testDetailsLessThanSize(){
        UsedItem u4 = new UsedItem();
        Checks cks = checksRepository.findById(1);
        Repairman rpm = repairmanRepository.findById(1);
        Stock st = stockRepository.findById(1);
        u4.setPrice(500.0);
        u4.setDetails("AAA");
        u4.setChecks(cks);
        u4.setRepairman(rpm);
        u4.setStock(st);

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
            assertEquals(violations.size(),1);
        }
    }

    // ใส่ Null
    @Test
    public void testStockMustBeNotNull(){
        UsedItem u5 = new UsedItem();
        Checks cks = checksRepository.findById(1);
        Repairman rpm = repairmanRepository.findById(1);
        u5.setPrice(500.0);
        u5.setDetails("AAAAAAAAAA");
        u5.setChecks(cks);
        u5.setRepairman(rpm);
        u5.setStock(null);

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
        Checks cks = checksRepository.findById(1);
        Repairman rpm = repairmanRepository.findById(1);
        Stock st = stockRepository.findById(1);
        u6.setUsedItemId(55L);
        u6.setPrice(100.0);
        u6.setDetails("AAAAAAAAAAA");
        u6.setChecks(cks);
        u6.setRepairman(rpm);
        u6.setStock(st);
        entityManager.persist(u6);
        entityManager.flush();

        UsedItem u7 = new UsedItem();
        Checks cks1 = checksRepository.findById(1);
        Repairman rpm1 = repairmanRepository.findById(1);
        Stock st1 = stockRepository.findById(1);
        u6.setUsedItemId(55L);
        u6.setPrice(100.0);
        u6.setDetails("AAAAAAAAAAA");
        u6.setChecks(cks1);
        u6.setRepairman(rpm1);
        u6.setStock(st1);
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
