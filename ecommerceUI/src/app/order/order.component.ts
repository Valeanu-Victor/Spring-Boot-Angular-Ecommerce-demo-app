import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart/cart.service';

export class Order {
  orderDetailsId: number
  price: number
  quantity: number
  idItem: number
  constructor(
    orderDetailsId: number,
    idItem: number,
    name: string,
    category: string,
    quantity: number,
    price: number
  ) { }
}

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  orders: Order[]
  order: Order
  totalCost: number = 0

  constructor(
    private cartService: CartService,
  ) { }

  ngOnInit() {
    this.refreshCart()
  }

  refreshCart() {
    this.cartService.getCartProducts().subscribe(
      response => {
        this.orders = response;
        if (this.orders != null) {
          this.totalCost = this.orders.reduce(((acc, obj) => acc + obj.price * obj.quantity), 0)
        } else this.totalCost = 0
      },
      error => console.log(error))
  }

  checkoutOrder() {
    return this.cartService.checkout().subscribe(
      () => this.refreshCart()
    )
  }

  removeOrder(order: Order) {
    return this.cartService.removeProduct(order.orderDetailsId).subscribe(
      () => this.refreshCart()
    )
  }
}