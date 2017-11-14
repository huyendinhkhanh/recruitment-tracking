import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Department } from './model/department';
import 'rxjs/add/operator/map';

@Injectable()
export class DepartmentService {

    private apiAllDepartmentsUrl = "http://localhost:8080/recruitment/departments";

    constructor(private http: Http) {
    }

    //GetAllDepartments
    getAllDepartments(): Observable<Department[]> {
        return this.http.get(this.apiAllDepartmentsUrl)
        .map(this.extractData);
    }

   

    private extractData(res: Response) {
        let body = res.json();
        return body;
    }
    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }

}