import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/http/route-guard.service';
import { ErrorComponent } from './error/error.component';
import { ProductsComponent } from './products/products.component';
import { RegisterComponent } from './register/register.component';
import { OrderComponent } from './order/order.component';
import { SellerComponent } from './seller/seller.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'welcome/:name', component: WelcomeComponent, canActivate: [RouteGuardService] },
  { path: 'logout', component: LogoutComponent, canActivate: [RouteGuardService] },
  { path: 'products', component: ProductsComponent, canActivate: [RouteGuardService] },
  { path: 'order/:name', component: OrderComponent, canActivate: [RouteGuardService] },
  { path: 'seller/:name', component: SellerComponent, canActivate: [RouteGuardService] },

  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
