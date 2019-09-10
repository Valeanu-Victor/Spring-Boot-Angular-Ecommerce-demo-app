import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http'
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class JwtInterceptorService implements HttpInterceptor {

  constructor(
    private injector: Injector
  ) { }

  intercept(req, next) {
    let authService = this.injector.get(BasicAuthenticationService)

    if(authService.getAuthenticatedToken() != null){
    let tokenizedRequest = req.clone({
      setHeaders: {
        Authorization: authService.getAuthenticatedToken()
      }
    })
    return next.handle(tokenizedRequest)
  }
    
    return next.handle(req)
  }
}
