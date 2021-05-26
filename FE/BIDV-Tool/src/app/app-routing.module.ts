import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin/admin.component';
import { ApplicationAddComponent } from './admin/content/application/application-add/application-add.component';
import { ApplicationEditComponent } from './admin/content/application/application-edit/application-edit.component';
import { ApplicationListComponent } from './admin/content/application/application-list/application-list.component';
import { DashboardComponent } from './admin/content/dashboard/dashboard.component';
import { GetOprByServiceComponent } from './admin/content/getElementById/get-opr-by-service/get-opr-by-service.component';
import { GetServiceByAppComponent } from './admin/content/getElementById/get-service-by-app/get-service-by-app.component';
import { OpenissueAddComponent } from './admin/content/openissue/openissue-add/openissue-add.component';
import { OpenissueEditComponent } from './admin/content/openissue/openissue-edit/openissue-edit.component';
import { OpenissueListComponent } from './admin/content/openissue/openissue-list/openissue-list.component';
import { OperationAddComponent } from './admin/content/operation/operation-add/operation-add.component';
import { OperationEditComponent } from './admin/content/operation/operation-edit/operation-edit.component';
import { OperationListComponent } from './admin/content/operation/operation-list/operation-list.component';
import { ServiceAddComponent } from './admin/content/service/service-add/service-add.component';
import { ServiceEditComponent } from './admin/content/service/service-edit/service-edit.component';
import { ServiceListComponent } from './admin/content/service/service-list/service-list.component';
import { TaskAddComponent } from './admin/content/task/task-add/task-add.component';
import { TaskEditComponent } from './admin/content/task/task-edit/task-edit.component';
import { TaskListComponent } from './admin/content/task/task-list/task-list.component';
import { UserAddComponent } from './admin/content/user/user-add/user-add/user-add.component';
import { UserListComponent } from './admin/content/user/user-list/user-list/user-list.component';

const routes: Routes = [
  { path: 'admin', redirectTo: 'admin/dashboard', pathMatch: 'full' },
  { path: 'admin/dashboard', component: DashboardComponent },
  { path: 'admin/application-list', component: ApplicationListComponent },
  { path: 'admin/application-add', component: ApplicationAddComponent },
  { path: 'admin/application-edit/:id', component: ApplicationEditComponent },
  { path: 'admin/service-list', component: ServiceListComponent },
  { path: 'admin/service-add', component: ServiceAddComponent },
  { path: 'admin/service-edit/:id', component: ServiceEditComponent },
  { path: 'admin/operation-list', component: OperationListComponent },
  { path: 'admin/operation-add', component: OperationAddComponent },
  { path: 'admin/operation-edit/:id', component: OperationEditComponent },
  { path: 'admin/openissue-add', component: OpenissueAddComponent },
  { path: 'admin/openissue-list', component: OpenissueListComponent },
  { path: 'admin/openissue-edit/:id', component: OpenissueEditComponent },
  { path: 'admin/task-list', component: TaskListComponent },
  { path: 'admin/task-add', component: TaskAddComponent },
  { path: 'admin/task-edit/:id', component: TaskEditComponent },
  { path: 'admin/user-list', component: UserListComponent },
  { path: 'admin/user-add', component: UserAddComponent },
  { path: 'admin/getOprByService/serviceId/:id', component: GetOprByServiceComponent },
  { path: 'admin/getServiceByApp/appId/:id', component: GetServiceByAppComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
