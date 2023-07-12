import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatRadioModule} from '@angular/material/radio';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatBadgeModule} from '@angular/material/badge';
import {MatCardModule} from '@angular/material/card';
import { FooterComponent } from './footer/footer.component';
import { ProductComponent } from './product/product.component';
import { AddNewProductComponent } from './add-new-product/add-new-product.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { AddressDetailsComponent } from './address-details/address-details.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { OrderHistoryComponent } from './order-history/order-history.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    HomePageComponent,
    FooterComponent,
    ProductComponent,
    AddNewProductComponent,
    FrontPageComponent,
    AddToCartComponent,
    AddressDetailsComponent,
    ProfileComponent,
    UpdateProductComponent,
    UpdateProfileComponent,
    OrderHistoryComponent,
 
  

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSlideToggleModule,
    MatButtonModule,
    MatToolbarModule,
    MatSelectModule,
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatGridListModule,
    MatTableModule,
    MatIconModule,
    MatDialogModule,
    MatGridListModule,
    MatRadioModule,
    MatSidenavModule,
    MatListModule,
    MatBadgeModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
   
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
