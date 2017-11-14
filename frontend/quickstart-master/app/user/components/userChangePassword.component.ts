import { Component, OnInit } from '@angular/core'
import { UserService } from '../services/user.service';
import { User } from '../models/user';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'user-update-password',
    templateUrl: 'app/user/components/userChangePassword.component.html',
    styleUrls: ['app/user/components/user.component.css']
})

export class UserChangePasswordComponent implements OnInit {
    user: User;
    userId: number;
    name: string;
    avatar: string;
    password: string;
    email: string;
    departmentId: number;
    roleId: number;
    isActive: number;
    oldPassword: string;
    newPassword: string;
    reEnterNewPassword: string;
    myAlert: string;
    myAlert1: string;
    myAlert2: string;
    myAlert3: string;

    constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.userId = this.route.snapshot.params['userId'];
        this.userService.findUserById(this.userId).subscribe(user => {
            this.name = user.name;
            this.avatar = user.avatar;
            this.password = user.password;
            this.email = user.email;
            this.departmentId = user.departmentId;
            this.roleId = user.roleId;
            this.isActive = user.isActive;
        });
    }

    savePassword() {
        this.myAlert = "";
        this.myAlert1 = "";
        this.myAlert2 = "";
        this.myAlert3 = "";
        this.user = {
            userId: this.userId,
            name: this.name,
            avatar: this.avatar,
            password: this.password,
            email: this.email,
            departmentId: this.departmentId,
            roleId: this.roleId,
            isActive: this.isActive
        }
        if (this.password != this.oldPassword) {
            this.myAlert1 += "Invalid old password";
        }
        if (this.newPassword == this.oldPassword) {
            this.myAlert2 += "New password mustn't be match old password";
        }
        if (this.newPassword != this.reEnterNewPassword) {
            this.myAlert3 += "Re-enter password must be match new password";
        }
        if (this.myAlert1 == "" && this.myAlert2 == "" && this.myAlert3 == "") {
            this.user.password = this.newPassword;
            this.changePassword(this.user);
            this.myAlert += "Change password successfully";
        }




/*         this.userService.update(this.userId, user);
        this.router.navigate(['/user']);
 */    }
    changePassword(user: User) {
        this.userService.changePassword(user).subscribe(data=>{
        });
    }

}
