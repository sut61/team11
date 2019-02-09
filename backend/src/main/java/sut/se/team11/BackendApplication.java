package sut.se.team11;

import sut.se.team11.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.se.team11.entity.*;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	ApplicationRunner init(CustomerRepository customerRepository, BranchRepository branchRepository, CareerRepository careerRepository,
						   ProvinceRepository provinceRepository, CategoryRepository categoryRepository,
						   UnitRepository unitRepository, EducationRepository educationRepository,
						   PositionRepository positionRepository, BuyItemRepository buyItemRepository
						   ,EmployeeRepository employeeRepository,CategorizeRepository categorizeRepository,
						   RepairmanRepository repairmanRepository, StockRepository stockRepository,
						   ChecksRepository checksRepository,UsedItemRepository usedItemRepository, SavePriceRepository savePriceRepository,
						   ProblemTypeRepository problemTypeRepository, DepartmentRepository departmentRepository,
						   TypePromotionRepository typePromotionRepository, CartRepository cartRepository
	){
		return  args -> {



			Stream.of("สาขา 1","สาขา 2","สาขา 3").forEach(bName -> {

				Branch branch = new Branch();
				branch.setBName(bName);
				branchRepository.save(branch);

			});
			Stream.of("Reduce","Reuse","Recycle","Repair").forEach(categorizeName -> {

				Categorize categorize = new Categorize();
				categorize.setCategorizeName(categorizeName);

				categorizeRepository.save(categorize);

			});


			Stream.of("ข้าราชการ/รัฐวิสาหกิจ","ธุรกิจส่วนตัว/ค้าขาย","เกษตรกร","รับจ้าง/พนักงานบริษัทเอกชน","นักเรียน/นักศึกษา","อื่น ๆ").forEach(cName -> {

				Career career = new Career();
				career.setCName(cName);
				careerRepository.save(career);

			});
			Stream.of("กาฬสินธุ์","ขอนแก่น","ชัยภูมิ","นครพนม","นครราชสีมา","บึงกาฬ","บุรีรัมย์","มหาสารคาม","มุกดาหาร","ยโสธร","ร้อยเอ็ด","เลย","ศรีสะเกษ","สกลนคร","สุรินทร์","หนองคาย","หนองบัวลำภู","อุดรธานี","อุบลราชธานี","อำนาจเจริญ").forEach(pName -> {


				Province province = new Province();
				province.setPName(pName);
				provinceRepository.save(province);

			});

			//B5804658
			Stream.of("เครื่องใช้ไฟฟ้า","อุปกรณ์อิเล็คทรอนิกส์").forEach(name -> {
				Category category = new Category();
				category.setCategoryName(name);
				categoryRepository.save(category);
			});
			Stream.of("เครื่อง","ชิ้น").forEach(name -> {
				Unit unit = new Unit();
				unit.setUnitName(name);
				unitRepository.save(unit);
			});
			Stream.of("Customer A").forEach(name -> {
				Customer customer = new Customer();
				Branch branch = branchRepository.findById(1);
				Career career = careerRepository.findById(1);
				Province province = provinceRepository.findById(1);

				customer.setCustomerName(name);
				customer.setAddress("555/55 NYC");
				customer.setTel("0123456789");
				customer.setCareer(career);
				customer.setBranch(branch);
				customer.setProvince(province);

				customerRepository.save(customer);
			});
			//B5804658

			Stream.of("ประถมศึกษา","มัธยมศึกษา","ปวช.","ปวส.","ปริญญาตรี","ปริญญาโท","ปริญญาเอก").forEach(edName ->{

				Education education = new Education();
				education.setEdName(edName);
				educationRepository.save(education);
			});
			Stream.of("พนักงานฝ่ายขนของ","พนักงานฝ่ายบัญชี","พนักงานฝ่ายบุคคล","พนักงานฝ่ายขาย","พนักงานทำความสะอาด").forEach(psName ->{
				Position position = new Position();
				position.setPsName(psName);
				positionRepository.save(position);
			});
			Stream.of("a").forEach(name -> {

				Employee employee = new Employee();
				Branch branch = branchRepository.findById(1);
				Position position = positionRepository.findById(2);
				Education education = educationRepository.findById(5);
				Province province = provinceRepository.findById(3);

				employee.setTitle("นาย");
				employee.setEName("แดง มากมี");
				employee.setAge(55);
				employee.setBDate(new Date());
				employee.setAddress("555/4 ");
				employee.setTel("044555666");
				employee.setProvince(province);
				employee.setBranch(branch);
				employee.setPosition(position);
				employee.setEducation(education);
				employeeRepository.save(employee);

				Employee employee2 = new Employee();
				Branch branch2 = branchRepository.findById(2);
				Position position2 = positionRepository.findById(3);
				Education education2 = educationRepository.findById(5);
				Province province2 = provinceRepository.findById(10);

				employee2.setTitle("นาง");
				employee2.setEName("สง่า รักสวย");
				employee2.setAge(25);
				employee2.setBDate(new Date() );
				employee2.setAddress("848 หมู่ 8  ");
				employee2.setTel("0898882888");
				employee2.setProvince(province2);
				employee2.setBranch(branch2);
				employee2.setPosition(position2);
				employee2.setEducation(education2);
				employeeRepository.save(employee2);

				Employee employee3 = new Employee();
				Branch branch3 = branchRepository.findById(3);
				Position position3 = positionRepository.findById(4);
				Education education3 = educationRepository.findById(4);
				Province province3 = provinceRepository.findById(15);

				employee3.setTitle("นาย");
				employee3.setEName("อรรคพล ใจสู้");
				employee3.setAge(28);
				employee3.setBDate(new Date() );
				employee3.setAddress("99 หมู่ 9  ");
				employee3.setTel("0999999999");
				employee3.setProvince(province3);
				employee3.setBranch(branch3);
				employee3.setPosition(position3);
				employee3.setEducation(education3);
				employeeRepository.save(employee3);

			});

			Stream.of("545").forEach(cName -> {

				Customer customer = new Customer();

				Branch branch = branchRepository.findById(1);
				Career career = careerRepository.findById(5);
				Province province = provinceRepository.findById(10);

				customer.setCustomerName("นายภัทรวิตต์ พรหมเงิน");
				customer.setTel("0854156774");
				customer.setAddress("111/1");
				customer.setBranch(branch);
				customer.setCareer(career);
				customer.setProvince(province);
				customerRepository.save(customer);

			});

			//B5804658
			Stream.of("Robert XML","Jacky Jason").forEach(name -> {
				Repairman repairman = new Repairman();
				repairman.setRepairmanName(name);
				repairmanRepository.save(repairman);
			});
			Stream.of("เก็บสินค้าทีมือสองซ่อมแซมไม่มาก", "เก็บสินค้ามือสองที่ซ่อมแซมหลายจุด").forEach(desc -> {
				if (desc == "เก็บสินค้าทีมือสองซ่อมแซมไม่มาก"){
					Stock s = new Stock();
					s.setStockName("สินค้า Grade A");
					s.setDescription(desc);
					stockRepository.save(s);
				}else{
					Stock s = new Stock();
					s.setStockName("สินค้า Grade B");
					s.setDescription(desc);
					stockRepository.save(s);
				}
			});
			Stream.of("Good").forEach(el -> {
				Checks c = new Checks();
				Categorize cr = categorizeRepository.findById(1);
				Employee e = employeeRepository.findById(1);
				BuyItem b = buyItemRepository.findById(1);
				c.setBuyItem(b);
				c.setCategorize(cr);
				c.setEmployee(e);
				c.setEvaluate(el);
				c.setWeight("3333");

				checksRepository.save(c);
			});
			Stream.of("Pending").forEach(status -> {
				Cart c = new Cart();
				Customer cus = customerRepository.findById(1);
				c.setPaymentStatus(status);
				c.setDate(new Date());
				c.setCustomer(cus);

				cartRepository.save(c);
			});
			Stream.of("Radio").forEach(name -> {
				BuyItem b = new BuyItem();
				Cart c = cartRepository.findById(1);
				Category cate = categoryRepository.findById(1);
				Unit u = unitRepository.findById(1);

				b.setItemName(name);
				b.setAmount(1);
				b.setPrice(100);
				b.setTotalPrice(100);
				b.setCart(c);
				b.setCategory(cate);
				b.setUnit(u);

				buyItemRepository.save(b);
			});
			//B5804658

			Stream.of("").forEach(sp -> {
				SavePrice priceTag = new SavePrice();

				Category c1 = categoryRepository.findById(1);
				Category c2 = categoryRepository.findById(2);
				UsedItem ut = usedItemRepository.findById(1);
				Employee emp = employeeRepository.findById(1);

				priceTag.setCategoryOne(c1);
				priceTag.setPriceOne(230);
				priceTag.setCategoryTwo(c2);
				priceTag.setPriceTwo(300);
				priceTag.setUsedItem(ut);
				priceTag.setExplain("Good Quality");
				priceTag.setEmployee(emp);
				savePriceRepository.save(priceTag);

			});

			Stream.of("อุปกรณ์ชำรุด","ระบบอินเทอร์เน็ต","เครื่องจักรชำรุด","ทั่วไป").forEach(ptName -> {
				ProblemType problemType = new ProblemType();
				problemType.setPtName(ptName);
				problemTypeRepository.save(problemType);

			});
			Stream.of("เงินสด","เปอร์เซ็นต์","ฟรีค่าจัดส่ง","เเถมสินค้า").forEach(typePromotionName -> {

				TypePromotion typePromotion = new TypePromotion();
				typePromotion.setTypePromotionName(typePromotionName);
				typePromotionRepository.save(typePromotion);


			});

			Stream.of("แผนกบัญชี","แผนกจัดส่ง","แผนกคลังสินค้า","แผนกขาย","แผนกรับซื้อ").forEach(depName -> {
				Department department = new Department();
				department.setDepName(depName);
				departmentRepository.save(department);

			});
		};
	}
}
