package sut.se.team11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.*;
import sut.se.team11.repository.*;

import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
@RunWith(SpringRunner.class)
@DataJpaTest
public class AssignmentTest {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //    บันทึกข้อมูลได้ปกติ
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testInsertNormalCase(){
        Assignment a1 = new Assignment();

        a1.setComment("AAAASSSD");

        a1.setAssignmentId((long)1);


        entityManager.persist(a1);
        entityManager.flush();
        fail("Should not pass to this line");


    }

    // ใส่ Null
    @Test
    public void testCommentMustBeNotNull(){
        Assignment a2 = new Assignment();
        a2.setComment(null);
//        a2.setAssignmentId((long)3);
        try{
            entityManager.persist(a2);
            entityManager.flush();


            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),4);


        }
    }

    // Pattern ผิด
    @Test
    public void testCommentIncorrectPattern(){
        Assignment a3 = new Assignment();
        a3.setComment("Adsdsdsd***");
//        a3.setAssignmentId((long)1);
        try{
            entityManager.persist(a3);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),4);


        }
    }

    //ขนาดเกิน Over Size
    @Test
    public void testCommentOverSize(){
        Assignment a4 = new Assignment();
        a4.setComment("AAAAAAAAAAAAAAAAA");


        try{
            entityManager.persist(a4);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),4);
        }
    }

    //ขนาดไม่ถึง Less Size
    @Test
    public void testCommentLessThanSize(){
        Assignment a5 = new Assignment();
        a5.setComment("AAA");


        try{
            entityManager.persist(a5);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(),false);
            assertEquals(violations.size(),4);

        }
    }

}
