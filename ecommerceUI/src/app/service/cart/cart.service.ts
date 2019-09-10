import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL, AUTHENTICATED_USER } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(
    private http: HttpClient,
  ) { }

  getCartProducts() {
    let username = sessionStorage.getItem(AUTHENTICATED_USER)
    return this.http.post<any>(`${API_URL}/order/details/cart`, { username })
  }

  checkout() {
    let username = sessionStorage.getItem(AUTHENTICATED_USER)
    return this.http.post<any>(`${API_URL}/orders/checkout`, { username })
  }

  removeProduct(idOrderDetails: number) {
    let username = sessionStorage.getItem(AUTHENTICATED_USER)
    return this.http.post<any>(`${API_URL}/order/details/removeOne`, { idOrderDetails, username })
  }

}
