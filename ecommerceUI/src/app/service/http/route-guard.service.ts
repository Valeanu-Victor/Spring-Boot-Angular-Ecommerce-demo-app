import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {
  canActivate(route: import("@angular/router").ActivatedRouteSnapshot, state: import("@angular/router").RouterStateSnapshot): boolean | import("@angular/router").UrlTree | import("rxjs").Observable<boolean | import("@angular/router").UrlTree> | Promise<boolean | import("@angular/router").UrlTree> {
    if (this.basicAuthenticationService.isUserLoggedIn()) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }

  constructor(
    private basicAuthenticationService: BasicAuthenticationService,
    private router: Router
  ) { }
}
