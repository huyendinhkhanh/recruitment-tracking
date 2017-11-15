import {Component, OnInit} from '@angular/core'
import {UserService} from '../services/user.service';
import {User} from '../models/user';
import {Router, ActivatedRoute, Params} from '@angular/router';

@Component({
    selector: 'user-view',
    templateUrl: 'app/user/components/user.component.html',
    styleUrls: ['app/user/components/user.component.css']
})

export class UserComponent implements OnInit {
    userId: number;
    name: string;
    avatar: string;
    password: string;
    email: string;
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
            this.roleId = user.roleId;
            this.isActive = user.isActive;
        });
    }    
}
