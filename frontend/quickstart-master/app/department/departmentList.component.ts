import {Component, OnInit} from '@angular/core'
import {DepartmentService} from './department.service';
import {Department} from './model/department';

@Component({
    selector: 'department-list',
    templateUrl: 'app/department/departmentList.component.html'
})

export class DepartmentListComponent implements OnInit {
    public departments: Department[];

    constructor(private departmentService: DepartmentService) {
    }

    ngOnInit() {
        this.departmentService.getAllDepartments().subscribe((_response: any) => {
            this.departments = _response;
        });
    }
}