import {Component, OnInit} from '@angular/core'
import {DepartmentService} from './department.service';
import {Department} from './model/department';

@Component({
    selector: 'department-add',
    templateUrl: 'app/department/department.component.html',
    styleUrls: ['app/department/department.component.css']
})

export class DepartmentComponent implements OnInit {
    public departments: Department[];

    constructor(private departmentService: DepartmentService) {
    }

    ngOnInit() {
        this.departmentService.getAllDepartments().subscribe((_response: any) => {
            this.departments = _response;
        });
    }
    
}
