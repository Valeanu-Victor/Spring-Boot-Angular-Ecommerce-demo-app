import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsDataService } from '../service/data/products-data.service';
import { AUTHENTICATED_USER } from '../app.constants';

export class Product {

  constructor(
    public id: number,
    public name: string,
    public category: string,
    public quantity: number,
    public price: number
  ) { }
}

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})

export class ProductsComponent implements OnInit {

  products: Product[];
  quantityOrdered: number;

  constructor(
    private router: Router,
    private productsDataService: ProductsDataService
  ) { }

  ngOnInit() {
    this.refreshProducts();
  }

  refreshProducts() {

    this.productsDataService.retrieveAllProducts().subscribe(
      response => {
        this.products = response;
      })
  }

  addProductToCart(product: Product) {
    let username = sessionStorage.getItem(AUTHENTICATED_USER);
    this.productsDataService.addProductToOrder(username, product.id, this.quantityOrdered, product.price).subscribe(
      () => this.refreshProducts()
    )
  }
}
