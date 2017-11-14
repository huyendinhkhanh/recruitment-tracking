import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from './model/user';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class UserService {

    private apiAllUsersUrl = "http://localhost:8080/recruitment/user/all";
    private apiChangePasswordUrl = "http://localhost:8080/recruitment/user/update/change-password";
    private apiChangeAvatarUrl = "http://localhost:8080/recruitment/user/update/change-avatar";
    private userList = this.http.get(this.apiAllUsersUrl).map(this.extractData);
    
    constructor(private http: Http) {
    }

    //GetAllUsers
    getAllUsers(): Observable<User[]> {
        return this.http.get(this.apiAllUsersUrl)
        .map(this.extractData);
    }

    //findUserById
    findUserById(userId: number): Observable<User> {
        return this.http.get("http://localhost:8080/recruitment/user/"+userId)
        .map(this.extractData);
    }
  
    changePassword(user: User):Observable<User>{
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this.http.post(this.apiChangePasswordUrl, JSON.stringify({
            userId: user.userId,
            name: user.name,
            avatar: user.avatar,
            password: user.password,
            email: user.email,
            departmentId: user.departmentId,
            roleId: user.roleId,
            isActive: user.isActive}), {headers: headers}).map((response: Response)=>response.json());
    }    
    getImage(user: User):Observable<User>{
        return this.http.get("http://localhost:8080/recruitment/user/"+userId)
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