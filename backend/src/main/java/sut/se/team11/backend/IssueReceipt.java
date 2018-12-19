package sut.se.g11.demo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Setter @Getter
public class IssueReceipt {
    @Id
    @SequenceGenerator(name = "issue_receipt_id",sequenceName = "issue_receipt_id")
    @GeneratedValue(generator = "issue_receipt_id",strategy = GenerationType.SEQUENCE)
    private Long irId;
    private Date date;
    private String borisut;

}
