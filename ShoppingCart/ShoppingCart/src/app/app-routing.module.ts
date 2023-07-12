import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AddNewProductComponent } from './add-new-product/add-new-product.component';
import { ProductComponent } from './product/product.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { AddressDetailsComponent } from './address-details/address-details.component';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { OrderHistoryComponent } from './order-history/order-history.component';


const routes: Routes = [
  {path:"signup",component:RegisterComponent},
  {path:"login",component:LoginComponent},
  {path:"home",component:HomePageComponent},
  {path:"products",component:ProductComponent},
  {path:"cart",component:AddToCartComponent},
  {path:"profile",component:ProfileComponent},
  {path:"add-product",component:AddNewProductComponent},
  {path:'update-product/:id',component:UpdateProductComponent},
  {path:"update-profile",component:UpdateProfileComponent},
  {path:"add-address",component:AddressDetailsComponent},
  {path:"front-page",component:FrontPageComponent},
  {path:"",component:FrontPageComponent},
  {path:"order-history",component:OrderHistoryComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  
 }
