package sut.se.team11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.team11.entity.Receipt;
import sut.se.team11.entity.ReportProblem;
import sut.se.team11.repository.ReceiptRepository;
import sut.se.team11.repository.ReportProblemRepository;

import javax.validation.*;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@DataJpaTest
@RunWith(SpringRunner.class)
//@SpringBootTest
public class ReceiptAndReportProblemTests {

	@Autowired
	private ReportProblemRepository reportProblemRepository;

	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
//================================================ Test Sprint 2 ==============================================
//========================================= B5809820 BHUCHIT VONGSRIKHAI ======================================
	@Test
	public void testTextInBetween20to100() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("0126789abcdefghijABCDEFGHIJ345"); //30
		rp1.setDate(new Date());
		entityManager.persist(rp1);
		entityManager.flush();
	}

	@Test
	public void testDetailNull() {
		ReportProblem rp = new ReportProblem();
		rp.setRpDetail(null);
		rp.setDate(new Date());
		try {
			entityManager.persist(rp);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=         - Detail Null -         =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testTextLessThen20() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("0123456789");//10
		rp1.setDate(new Date());
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=       - Text Less Then20 -      =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testTextGreaterThen100() {
		ReportProblem rp1 = new ReportProblem();
		String test = "0123456789";
		for(int i = 0; i < 12; i++){
			test = test.concat("0123456789");
		}
		rp1.setRpDetail(test);
		rp1.setDate(new Date());

		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=     - Text Greater Then100 -    =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testTextNotPatternMatch() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("012345678901234567890123456789@!#$");
		rp1.setDate(new Date());
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=   - Text Not Pattern Match -    =");
			System.out.println("===================================");
		}
	}

//================================================ Test Sprint 1 ==============================================
//========================================= B5809820 BHUCHIT VONGSRIKHAI ======================================
    @Test
    public void testNetPriceInOfBound() {
        Receipt re = new Receipt();
        re.setNetPrice(123);
        re.setDate(new Date());

    }

    @Test
	public void testDoubleOutOfMax() {
		Receipt re = new Receipt();
		re.setNetPrice(1015456.12);
		re.setDate(new Date());
		try {
			entityManager.persist(re);
			entityManager.flush();
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=     - NetPrice Out Of Max -     =");
			System.out.println("===================================");
		}
	}
    @Test
    public void testDoubleNegativeValue() {
        Receipt re = new Receipt();
        re.setNetPrice(-6.12);
        re.setDate(new Date());
        try {
            entityManager.persist(re);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=   - NetPrice Negative Value -   =");
			System.out.println("===================================");
        }
    }

    @Test
    public void testNetPriceOutOfMin() {
        Receipt re = new Receipt();
        re.setNetPrice(7);
        re.setDate(new Date());
		try {
			entityManager.persist(re);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=     - NetPrice Out Of Min -     =");
			System.out.println("===================================");
		}
    }
    @Test
    public void testNetPriceZero() {
        Receipt re = new Receipt();
        re.setNetPrice(0);
        re.setDate(new Date());

        try {
            entityManager.persist(re);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println("===================================");
            System.out.println("=            - S P 1 -            =");
            System.out.println("= ----------- T E S T ----------- =");
            System.out.println("=       - Net Price Zero -        =");
            System.out.println("===================================");

        }
    }


}

