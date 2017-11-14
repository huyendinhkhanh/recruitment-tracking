import {Component, OnInit} from '@angular/core'
import {UserService} from './user.service';
import {User} from './model/user';
import {Router, ActivatedRoute, Params} from '@angular/router';

@Component({
    selector: 'user-view',
    templateUrl: 'app/user/user.component.html',
    styleUrls: ['app/user/user.component.css']
})

export class UserComponent implements OnInit {
    userId: number;
    name: string;
    avatar: string;
    password: string;
    email: string;
    departmentId: number;
    roleId: number;
    isActive: number;

    constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.userId = this.route.snapshot.params['userId'];
        this.userService.findUserById(this.userId).subscribe(user =>{
            this.name = user.name;
            this.avatar = user.avatar;
            this.password = user.password;
            this.email = user.email;
            this.departmentId = user.departmentId;
            this.roleId = user.roleId;
            this.isActive = user.isActive;
        });
    }    
}
