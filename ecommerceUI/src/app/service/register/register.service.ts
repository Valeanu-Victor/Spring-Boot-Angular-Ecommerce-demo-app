import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(
    private http: HttpClient
  ) { }

  register(username: string, password: string, roles: string) {
    return this.http.post<any>(`http://localhost:8080/users/register`,
      {
        username,
        password,
        roles
      });
  }
}
