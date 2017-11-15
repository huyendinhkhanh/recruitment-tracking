import { Component, OnInit } from '@angular/core'
import { UserService } from '../services/user.service';
import { User } from '../models/user';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'user-update-avatar',
    templateUrl: 'app/user/components/userChangeAvatar.component.html',
    styleUrls: ['app/user/components/userChangeAvatar.component.css']
})

export class UserChangeAvatarComponent implements OnInit {

    constructor() {
    }

    ngOnInit() {
    }

}
