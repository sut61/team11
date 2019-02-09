package sut.se.team11;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.Checks;
import sut.se.team11.repository.ChecksRepository;

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

public class ChecksTest {
    @Autowired
    private ChecksRepository checksRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testChecks() {
        Checks c = new Checks();

        c.setDate(new Date());
        c.setEvaluate("122313qwedsadAAAAA");
        c.setWeight(35);

        entityManager.persist(c);
        entityManager.flush();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("0. Enter the correct information. ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    @Test
    public void testChecksNull() {
        Checks c = new Checks();

        c.setDate(new Date());
        c.setEvaluate(null);
        c.setWeight(13);

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("1. Enter null values");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test
    public void testChecksSize() {
        Checks c = new Checks();

        c.setDate(new Date());
        c.setEvaluate("122313qwedsadAAAAAqwedasfjhqwjlkjroiquwiorj102384r90iqwopjfasouf9qpueoru19348e9udafihvaslfj9qier9i123peqowjdklasfasfasgf1234rqwfasc");
        c.setWeight(12);

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("2. Enter information that is longer than Size.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test
    public void testChecksSizeNo() {
        Checks c = new Checks();

        c.setDate(new Date());
        c.setEvaluate("12a");
        c.setWeight(5);

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("3. Enter information that is shorter than the size.");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    @Test
    public void testChecksPattern() {
        Checks c = new Checks();

        c.setDate(new Date());
        c.setEvaluate("-122313qwedsadAAAAA");
        c.setWeight(21);

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("4. Enter different data from Pattern");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void testCheckUniqu() {

        Checks c = new Checks();

        c.setChecksId((long) 1);
        c.setEvaluate("122313qwedsadAAAAA");
        c.setWeight(41);
//		entityManager.persist(c);
//		entityManager.flush();

//		Checks c1 = new Checks();
        c.setChecksId((long) 2);
        c.setEvaluate("122313qwedsadAAAAA");
        c.setWeight(41);
//		entityManager.persist(c1);
//		entityManager.flush();


        try {
            entityManager.persist(c);
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


        }


    }
}

