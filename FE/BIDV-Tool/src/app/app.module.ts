
import { AppComponent } from './app.component';
import { HeaderComponent } from './admin/header/header.component';
import { MenuComponent } from './admin/menu/menu.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AdminComponent } from './admin/admin/admin.component';
import { DashboardComponent } from './admin/content/dashboard/dashboard.component';
import { UserAddComponent } from './admin/content/user/user-add/user-add/user-add.component';
import { UserListComponent } from './admin/content/user/user-list/user-list/user-list.component';
import { ApplicationAddComponent } from './admin/content/application/application-add/application-add.component';
import { ApplicationListComponent } from './admin/content/application/application-list/application-list.component';
import { ApplicationEditComponent } from './admin/content/application/application-edit/application-edit.component';
import { ServiceListComponent } from './admin/content/service/service-list/service-list.component';
import { ServiceAddComponent } from './admin/content/service/service-add/service-add.component';
import { ServiceEditComponent } from './admin/content/service/service-edit/service-edit.component';
import { OperationListComponent } from './admin/content/operation/operation-list/operation-list.component';
import { OperationAddComponent } from './admin/content/operation/operation-add/operation-add.component';
import { OperationEditComponent } from './admin/content/operation/operation-edit/operation-edit.component';
import { OpenissueListComponent } from './admin/content/openissue/openissue-list/openissue-list.component';
import { OpenissueAddComponent } from './admin/content/openissue/openissue-add/openissue-add.component';
import { OpenissueEditComponent } from './admin/content/openissue/openissue-edit/openissue-edit.component';
import { TaskListComponent } from './admin/content/task/task-list/task-list.component';
import { TaskAddComponent } from './admin/content/task/task-add/task-add.component';
import { TaskEditComponent } from './admin/content/task/task-edit/task-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    AdminComponent,
    DashboardComponent,
    UserAddComponent,
    UserListComponent,
    ApplicationAddComponent,
    ApplicationListComponent,
    ApplicationEditComponent,
    ServiceListComponent,
    ServiceAddComponent,
    ServiceEditComponent,
    OperationListComponent,
    OperationAddComponent,
    OperationEditComponent,
    OpenissueListComponent,
    OpenissueAddComponent,
    OpenissueEditComponent,
    TaskListComponent,
    TaskAddComponent,
    TaskEditComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule, 
    FormsModule, 
    HttpClientModule, 
    ReactiveFormsModule, 
    FormsModule, 
    ReactiveFormsModule,
    NgbModule
    
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
