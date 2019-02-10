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
import sut.se.team11.entity.SavePrice;
import sut.se.team11.repository.CustomerRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.SavePriceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application.properties")
public class SavePriceTest {
    @Autowired
    private SavePriceRepository savePriceRepository;
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
    public void TestSavePriceCorrect() {
        SavePrice savePrice = new SavePrice();
        savePrice.setPriceOne(350);
        savePrice.setPriceTwo(369);

        entityManager.persist(savePrice);
        entityManager.flush();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" 1. SavePrice Information Correct ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

    }
    @Test
    public void TestSavePriceMin() {
        SavePrice savePrice = new SavePrice();
        savePrice.setPriceOne(-369);
        savePrice.setPriceTwo(369);
        try {
            entityManager.persist(savePrice);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" 2. Enter price is lower than min. ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }


    }
    @Test
    public void TestSavePriceMax() {
        SavePrice savePrice = new SavePrice();
        savePrice.setPriceOne(369);
        savePrice.setPriceTwo(369000);
        try {
            entityManager.persist(savePrice);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" 3. Enter price is higher than max. ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }

    }
    @Test
    public void TestSavePriceNotNegative() {
        SavePrice savePrice = new SavePrice();
        savePrice.setPriceOne(-365);
        savePrice.setPriceTwo(-356);

        try {
            entityManager.persist(savePrice);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" 4. Price should be positive ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }

    }
    @Test
    public void TestSavePriceNotZreo() {
        SavePrice savePrice = new SavePrice();
        savePrice.setPriceOne(0);
        savePrice.setPriceTwo(0);

        try {
            entityManager.persist(savePrice);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" 5. Price shouldn't be zero ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }

    }

}
