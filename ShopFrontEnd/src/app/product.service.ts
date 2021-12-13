import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  apiUrl = "http://localhost:4200/api/products"

  constructor(private httpClient: HttpClient) { }

  getProducts() {
    return this.httpClient
      .get(this.apiUrl)
  }

}
