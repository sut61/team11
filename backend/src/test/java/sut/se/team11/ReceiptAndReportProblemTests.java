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
import java.text.SimpleDateFormat;
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
	public void testTextInOfBound() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("0126789LoveOwnJamExportDecay");
		rp1.setDate(new Date());
		entityManager.persist(rp1);
//		entityManager.flush();
	}

	@Test
	public void testDetailNotNull() {
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
			assertEquals(violations.size(), 4);
			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=       - Detail Not Null -       =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testTextOutOfBoundMin() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("012345678");
		rp1.setDate(new Date());
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=    - Text Out Of Bound Min -    =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testTextOutOfBoundMax() {
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
			assertEquals(violations.size(), 4);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=    - Text Out Of Bound Max -    =");
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
			assertEquals(violations.size(), 4);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=   - Text Not Pattern Match -    =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testReportDateNotNull() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("01234567890123456789");
		rp1.setDate(null);
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=     - Report Date Not Null -    =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testReportDate() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("01234567890123456789");
		rp1.setDate(new Date());
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=     - Report Date Not Null -    =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testProblemTypeNotNull() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("01234567890123456789");
		rp1.setDate(new Date());
		rp1.setProblemType(null);
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=    - Problem Type Not Null -    =");
			System.out.println("===================================");
		}
	}
	@Test
	public void testDepartmentNotNull() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("01234567890123456789");
		rp1.setDate(new Date());
		rp1.setDepartment(null);
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=     - Department Not Null -     =");
			System.out.println("===================================");
		}
	}
	@Test
	public void testReportEmployeeNotNull() {
		ReportProblem rp1 = new ReportProblem();
		rp1.setRpDetail("01234567890123456789");
		rp1.setDate(new Date());
		rp1.setProblemType(null);
		try {
			entityManager.persist(rp1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);

			System.out.println("===================================");
			System.out.println("=            - S P 2 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=  - Report Employee Not Null -   =");
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
	public void testReceiptDateNotNull() {
		Receipt re = new Receipt();
		re.setNetPrice(1);
		re.setDate(null);
		try {
			entityManager.persist(re);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=    - Receipt Date Not Null -    =");
			System.out.println("===================================");

		}
	}
	@Test
	public void testReceiptDate() {
		Receipt re = new Receipt();
		re.setNetPrice(1);
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
			System.out.println("=        - Receipt Date -         =");
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
			assertEquals(violations.size(), 5);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=       - Net Price Zero -        =");
			System.out.println("===================================");

		}
	}

	@Test
	public void testDoubleNegativeValue() {
		Receipt re = new Receipt();
		re.setNetPrice(-7.77);
		re.setDate(new Date());
		try {
			entityManager.persist(re);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=   - NetPrice Negative Value -   =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testOutOfBoundMin() {
		Receipt re = new Receipt();
		re.setNetPrice(0.77);
		re.setDate(new Date());
		try {
			entityManager.persist(re);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);
			System.out.println("===================================");
			System.out.println("=            - S P 1 -            =");
			System.out.println("= ----------- T E S T ----------- =");
			System.out.println("=       - Out Of Bound Min -      =");
			System.out.println("===================================");
		}
	}

	@Test
	public void testBranchNotNull() {
		Receipt re = new Receipt();
		re.setNetPrice(7);
		re.setDate(new Date());
		re.setBranch(null);
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
			System.out.println("=       - Branch Not Null -       =");
			System.out.println("===================================");
		}
	}

    @Test
    public void testReceiptEmployeeNotNull() {
        Receipt re = new Receipt();
        re.setNetPrice(7);
        re.setDate(new Date());
        re.setEmployee(null);
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
			System.out.println("=  - Receipt Employee Not Null -  =");
			System.out.println("===================================");
		}
    }

	@Test
	public void testCartNotNull() {
		Receipt re = new Receipt();
		re.setNetPrice(7);
		re.setDate(new Date());
		re.setCart(null);
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
			System.out.println("=        - Cart Not Null -        =");
			System.out.println("===================================");
		}
	}
}

