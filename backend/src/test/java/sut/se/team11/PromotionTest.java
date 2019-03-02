package sut.se.team11;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.Promotion;
import sut.se.team11.repository.PromotionRepository;


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

public class PromotionTest {
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test // ตรวจสอบว่าใส่ข้อมูลครบถ้วน
    public void testPromotion() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("ยิ่งซื้อยิ่งลด");
        promotion.setNumberOfTime(1);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());



        entityManager.persist(promotion);
        entityManager.flush();


        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ================== Sprint2 TEST 1 ====================  ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    @Test // ตรวจสอบว่าใส่ข้อมูลผิดพลาด
    public void testPromotionNull() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName(null);
        promotion.setNumberOfTime(1);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());



        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 2 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // ตรวจสอบว่าใส่ตัวเลขเกิน
    public void testOverNumberOfTime() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("ยิ่งซื้อยิ่งลด");
        promotion.setNumberOfTime(200);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());

        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 3 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // ตรวจสอบว่าใส่ตัวเลขเติดลบ
    public void testNumberOfTimeNegative() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("ยิ่งซื้อยิ่งลด");
        promotion.setNumberOfTime(-50);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());

        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 4 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // ตรวจสอบว่าใส่ตัวเลขเเป็น 0
    public void testNumberOfTimeZero() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("ยิ่งซื้อยิ่งลด");
        promotion.setNumberOfTime(0);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());

        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 5 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // ตรวจสอบว่าลืมใส่ตัวเลข
    public void testOverNumberNull() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("ยิ่งซื้อยิ่งลด");
        promotion.setNumberOfTime(null);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());

        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 6 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // ตรวจสอบว่าใส่ข้อมูลไม่ครบ
    public void testDetailPromotionNull() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("ยิ่งซื้อยิ่งลด");
        promotion.setNumberOfTime(1);
        promotion.setDetailPromotion(null);
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());

        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 7 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }

    @Test // ตรวจสอบรูปเเบบ
    public void testPromotionNamePattern() {
        Promotion promotion = new Promotion();

        promotion.setPromotionName("?-;abcdefgh");
        promotion.setNumberOfTime(1);
        promotion.setDetailPromotion("ซื้อสองชิ้นในราคารวม 200 บาทลด 30 บาท");
        promotion.setDateIn(new Date());
        promotion.setDateOut(new Date());



        try {
            entityManager.persist(promotion);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ================== Sprint2 TEST 8 ====================  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

        }
    }



}
