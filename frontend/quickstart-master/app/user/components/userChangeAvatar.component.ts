import { Component, OnInit } from '@angular/core'
import { UserService } from '../services/user.service';
import { User } from '../models/user';
import { Image } from '../models/image';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'user-update-avatar',
    templateUrl: 'app/user/components/userChangeAvatar.component.html',
    styleUrls: ['app/user/components/userChangeAvatar.component.css']
})

export class UserChangeAvatarComponent implements OnInit {
  user: User;
  userId: number;
  name: string;
  avatar: string;
  password: string;
  email: string;
  roleId: number;
  isActive: number;
  myAlert: string;
  public images: string[];
  public avatarImages: string[];
  
    constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) {
    }

    ngOnInit() {

      this.userId = this.route.snapshot.params['userId'];
      this.userService.findUserById(this.userId).subscribe(user => {
          this.name = user.name;
          this.avatar = user.avatar;
          this.password = user.password;
          this.email = user.email;
          this.roleId = user.roleId;
          this.isActive = user.isActive;
      });
      this.userService.getAllImages().subscribe((_response: any) => {
        this.images = _response;
      });
    }

    saveAvatar(newUrl: string) {
      this.myAlert = "";
      this.user = {
        userId: this.userId,
        name: this.name,
        avatar: this.avatar,
        password: this.password,
        email: this.email,
        roleId: this.roleId,
        isActive: this.isActive
      }
      this.user.avatar = newUrl;
      this.changeAvatar(this.user);
      this.myAlert += "Change avatar successfully";

    }
    changeAvatar(user: User) {
      this.userService.changeAvatar(user).subscribe(data=>{
      });
  }

}
