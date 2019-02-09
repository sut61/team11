import { Component, OnInit } from '@angular/core';
import { Assignment, AssignmentService, Customer } from '../../shared/assignment/assignment.service';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { FindCustomerasService } from 'src/app/shared/find-customeras/find-customeras.service';
import { NotificationService } from 'src/app/shared/notification/notification.service';


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


assignment: Assignment = new Assignment();
form: FormGroup;
assignments: Array<any>;
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
  ) { }

  

  ngOnInit() {

    this.service.getScoreAssignment().subscribe(data => {
      this.assignments = data;
      console.log(this.assignments);
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

    console.log(this.assignment);
    this.httpClient.post('//localhost:8080/Assignment/' + this.id2,this.assignment)
    .subscribe(
        data => {
            console.log('PUT Request is successful', data);
            this.notification.success();
        },
        error => {
            console.log('Rrror', error);
        }
      );
   }


}

