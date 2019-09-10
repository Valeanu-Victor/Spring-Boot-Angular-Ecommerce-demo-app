import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from 'src/app/products/products.component';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})

export class ProductsDataService {

  constructor(
    private http: HttpClient,
  ) { }

  retrieveAllProducts() {

    return this.http.get<Product[]>(`${API_URL}/items/all`);
  }

  addProductToOrder(username, idItem, quantity, price) {

    return this.http.post<Product>(`${API_URL}/order/details/additem`,
      {
        username,
        idItem,
        quantity,
        price
      })
  }

}
