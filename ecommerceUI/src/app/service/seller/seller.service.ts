import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(
    private http: HttpClient
  ) { }

  insertOne(name, category, price, quantity) {
    return this.http.post<any>(`${API_URL}/items/seller`, { name, category, price, quantity })
  }
}
