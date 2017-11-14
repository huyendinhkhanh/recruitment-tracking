import {Component, OnInit} from '@angular/core'
import {UserService} from './user.service';
import {User} from './model/user';

@Component({
    selector: 'user-list',
    templateUrl: 'app/user/user-list.component.html'
})

export class UserListComponent implements OnInit {
    public users: User[];

    constructor(private userService: UserService) {
    }

    ngOnInit() {
        this.userService.getAllUsers().subscribe((_response: any) => {
            this.users = _response;
        });
    }
}