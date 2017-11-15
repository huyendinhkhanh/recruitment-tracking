import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, RequestOptionsArgs, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user';
import { Image } from '../models/image';
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

    getAllUsers(): Observable<User[]> {
        return this.http.get(this.apiAllUsersUrl)
        .map(this.extractData);
    }

    findUserById(userId: number): Observable<User> {
        return this.http.get("http://localhost:8080/recruitment/user/"+userId)
        .map(this.extractData);
    }

    findImageById(imageId: number): Observable<Image> {
        return this.http.get("http://localhost:8080/recruitment/user/avatar-image/"+imageId)
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
            roleId: user.roleId,
            isActive: user.isActive}), {headers: headers}).map((response: Response)=>response.json());
    }    

    changeAvatar(user: User):Observable<User>{
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this.http.post(this.apiChangeAvatarUrl, JSON.stringify({
            userId: user.userId,
            name: user.name,
            avatar: user.avatar,
            password: user.password,
            email: user.email,
            roleId: user.roleId,
            isActive: user.isActive}), {headers: headers}).map((response: Response)=>response.json());
    }    

    private extractData(res: Response) {
        let body = res.json();
        return body;
    }
    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }

    getAllImages(): Observable<string[]> {
        return this.http.get("http://localhost:8080/recruitment/user/all/images")
        .map(this.extractData);
    }
    
}