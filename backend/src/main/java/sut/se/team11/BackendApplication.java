package sut.se.team11;

import sut.se.team11.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.se.team11.entity.*;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	ApplicationRunner init(CustomerRepository customerRepository, BranchRepository branchRepository, CareerRepository careerRepository,
						   ProvinceRepository provinceRepository
	){
		return  args -> {

			Stream.of("สาขา 1","สาขา 2","สาขา 3").forEach(bName -> {

				Branch branch = new Branch();
				branch.setBName(bName);
				branchRepository.save(branch);

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

		};
	}
}
