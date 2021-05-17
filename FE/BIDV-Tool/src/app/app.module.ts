
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
import { ServiceComponent } from './admin/content/service/service.component';
import { OperationComponent } from './admin/content/operation/operation.component';
import { OpenissueComponent } from './admin/content/openissue/openissue.component';
import { TaskComponent } from './admin/content/task/task.component';
import { UserAddComponent } from './admin/content/user/user-add/user-add/user-add.component';
import { UserListComponent } from './admin/content/user/user-list/user-list/user-list.component';
import { ApplicationAddComponent } from './admin/content/application/application-add/application-add.component';
import { ApplicationListComponent } from './admin/content/application/application-list/application-list.component';
import { ApplicationEditComponent } from './admin/content/application/application-edit/application-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    AdminComponent,
    DashboardComponent,
    ServiceComponent,
    OperationComponent,
    OpenissueComponent,
    TaskComponent,
    UserAddComponent,
    UserListComponent,
    ApplicationAddComponent,
    ApplicationListComponent,
    ApplicationEditComponent
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
