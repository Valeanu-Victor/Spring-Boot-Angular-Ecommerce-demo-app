import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { API_URL, AUTHENTICATED_USER, TOKEN } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(
    private http: HttpClient
  ) { }

  executeJWTAuthenticationService(username: string, password: string) {
    return this.http.post<any>(
      `${API_URL}/login`, {
        username,
        password
      },
      {
        observe: 'response'
      }).pipe(
        map(
          data => {
            sessionStorage.setItem(AUTHENTICATED_USER, username);
            sessionStorage.setItem(TOKEN, data.headers.get('authorization'));
            return data;
          }
        )
      );
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER)
  }

  getAuthenticatedToken() {
    if (this.getAuthenticatedUser())
      return sessionStorage.getItem(TOKEN)
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    let jwtToken = sessionStorage.getItem(TOKEN);
    return (!(user === null) && !(jwtToken === null));
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER)
    sessionStorage.removeItem(TOKEN)
  }

}

export class AuthenticationBean {
  constructor(public message: string) { }
}