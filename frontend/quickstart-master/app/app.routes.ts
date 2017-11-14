import { RouterModule, Routes } from '@angular/router';

import { DepartmentComponent } from './department/department.component';
import { DepartmentListComponent } from './department/departmentList.component';

import { UserComponent } from './user/components/user.component';
import { UserListComponent } from './user/components/user-list.component';
import { UserChangePasswordComponent } from './user/components/userChangePassword.component';
import { UserChangeAvatarComponent } from './user/components/userChangeAvatar.component';

const routing : Routes = [
    { path: 'departments', pathMatch: 'full', component: DepartmentListComponent },
    { path: 'department/add', pathMatch: 'full', component: DepartmentComponent },

    { path: 'user/all', pathMatch: 'full', component: UserListComponent },
    { path: 'user/:userId', pathMatch: 'full', component: UserComponent },
    { path: 'user/:userId/update/change-password', pathMatch: 'full', component: UserChangePasswordComponent },
    { path: 'user/:userId/update/change-avatar', pathMatch: 'full', component: UserChangeAvatarComponent }
]

export const appRoutes = RouterModule.forRoot(routing);