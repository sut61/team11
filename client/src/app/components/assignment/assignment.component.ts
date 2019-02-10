import { Component, OnInit } from '@angular/core';
import { Assignment, AssignmentService, Customer, ScoreAssignment } from '../../shared/assignment/assignment.service';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { FindCustomerasService } from 'src/app/shared/find-customeras/find-customeras.service';
import { NotificationService } from 'src/app/shared/notification/notification.service';
import { Employee, Account } from 'src/app/shared/models/model-class';


export interface Animal {
  name: string;
  name1: string;
  name2: string;
  name3: string;
  name4: string;
}
@Component({
  selector: 'app-assignment',
  templateUrl: './assignment.component.html',
  styleUrls: ['./assignment.component.css']
})
export class AssignmentComponent implements OnInit {
account: Account = new Account();
employee: Employee = new Employee();
assignment: Assignment = new Assignment();
form: FormGroup;
scores: Array<ScoreAssignment>;
id: any;
id2: any;
customer: Customer = new Customer();
sub2: Subscription;

animalControl = new FormControl('', [Validators.required]);
selectFormControl = new FormControl('', Validators.required);
animals: Animal[] = [
];

  constructor(
    private fb: FormBuilder,private find: FindCustomerasService,
    private route: ActivatedRoute,
    private saveass: AssignmentService , private httpClient: HttpClient,private router: Router,
    private service: AssignmentService ,
    public notification: NotificationService
  ) { 
    this.account = JSON.parse(localStorage.getItem('account'));
  }

  

  ngOnInit() {
    this.account = JSON.parse(localStorage.getItem('account'));
    this.employee = this.account.employee;
    console.log(this.employee);

    this.service.getScoreAssignment().subscribe(data => {
      this.scores = data;
      console.log(this.scores);
    });

    this.route.params.subscribe(param => {
      this.id2 = param['id'];
      // console.log(this.id3);
      this.find.findCustomeras(this.id2).subscribe((data2) =>{
      // console.log(data2);
      } ) 
       this.find.findCustomeras(this.id2).subscribe((data) => {
       this.customer = data;
     });
  }, err => {
    console.log(err + "Errororororor");
  });


  }

  save(){
    //  console.log("22222222",this.id2);
    this.assignment.employee = this.employee;
    console.log(this.assignment);
    this.httpClient.post('//localhost:8080/Assignment/' + this.id2,this.assignment)
    .subscribe(
        data => {
            console.log('PUT Request is successful', data);
            this.notification.success();
        },
        error => {
            console.log('Rrror', error);
            this.notification.error();
        }
      );
   }


}

