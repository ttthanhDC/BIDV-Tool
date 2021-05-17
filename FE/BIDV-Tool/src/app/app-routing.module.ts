import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin/admin.component';
import { ApplicationAddComponent } from './admin/content/application/application-add/application-add.component';
import { ApplicationEditComponent } from './admin/content/application/application-edit/application-edit.component';
import { ApplicationListComponent } from './admin/content/application/application-list/application-list.component';
import { DashboardComponent } from './admin/content/dashboard/dashboard.component';
import { OpenissueComponent } from './admin/content/openissue/openissue.component';
import { OperationComponent } from './admin/content/operation/operation.component';
import { ServiceComponent } from './admin/content/service/service.component';
import { TaskComponent } from './admin/content/task/task.component';
import { UserAddComponent } from './admin/content/user/user-add/user-add/user-add.component';
import { UserListComponent } from './admin/content/user/user-list/user-list/user-list.component';

const routes: Routes = [
    { path: 'admin', redirectTo: 'admin/dashboard', pathMatch: 'full' },
    { path: 'admin/dashboard', component: DashboardComponent},
    { path: 'admin/application-list', component: ApplicationListComponent},
    { path: 'admin/application-add', component: ApplicationAddComponent},
    { path: 'admin/application-edit/:id', component: ApplicationEditComponent},
    { path: 'admin/service-list', component: ServiceComponent},
    { path: 'admin/operation-list', component: OperationComponent},
    { path: 'admin/openissue-list', component: OpenissueComponent},
    { path: 'admin/task', component: TaskComponent},
    { path: 'admin/user-list', component: UserListComponent},
    { path: 'admin/user-add', component: UserAddComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
