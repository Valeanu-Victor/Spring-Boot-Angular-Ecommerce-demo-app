import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LogoutComponent } from './logout/logout.component';
import { ErrorComponent } from './error/error.component';
import { ProductsComponent } from './products/products.component';
import { RegisterComponent } from './register/register.component';
import { OrderComponent } from './order/order.component';
import { JwtInterceptorService } from './service/tokenInterceptor/jwt-interceptor.service';
import { SellerComponent } from './seller/seller.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    WelcomeComponent,
    LogoutComponent,
    ErrorComponent,
    ProductsComponent,
    RegisterComponent,
    OrderComponent,
    SellerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
