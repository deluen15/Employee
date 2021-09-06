import {Component} from "@angular/core";
import {Employees} from "./Employees";

@Component({
  selector: 'em-employees',
  templateUrl: "./app/employee/employee-list.component.html"
})
export class EmployeeList {
  pageTitle: string ='Employee List';
  listFilter: string= 'count';
  showImage: boolean = false;
  employees: Employees[]=[];
  imageWidth: number = 50;
  imageMargin: number = 2;

  toggleImage() {
    this.showImage = !this.showImage;
  }
}
