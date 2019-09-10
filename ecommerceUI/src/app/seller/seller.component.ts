import { Component, OnInit } from '@angular/core';
import { SellerService } from '../service/seller/seller.service';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.scss']
})
export class SellerComponent implements OnInit {

  name: string
  category: string
  price: number
  quantity: number

  constructor(
    private sellerService: SellerService
  ) { }

  ngOnInit() {
  }

  insertItem() {
    return this.sellerService.insertOne(this.name, this.category, this.price, this.quantity).subscribe()
  }

}