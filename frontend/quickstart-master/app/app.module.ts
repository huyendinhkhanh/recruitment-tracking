import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import { FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import { DepartmentComponent } from './department/department.component';
import { DepartmentListComponent } from './department/departmentList.component';

import {DepartmentService} from './department/department.service';

import{appRoutes} from './app.routes';

import { UserComponent } from './user/components/user.component';
import { UserListComponent } from './user/components/user-list.component';
import { UserService } from './user/services/user.service';

import { UserChangePasswordComponent } from './user/components/userChangePassword.component';
import { UserChangeAvatarComponent } from './user/components/userChangeAvatar.component';

@NgModule({
  imports:      [ BrowserModule, FormsModule, HttpModule, appRoutes],
  declarations: [ AppComponent , 
                DepartmentComponent,
                DepartmentListComponent,
                UserComponent,
                UserListComponent,
                UserChangePasswordComponent,
                UserChangeAvatarComponent],
  bootstrap:    [ AppComponent ],
  providers:    [ DepartmentService,
                UserService]

})
export class AppModule { 

  
}
