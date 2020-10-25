import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {ProductModel} from "../model/ProductModel";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class CatalogueService {

  private CATALOGUE_URL = "localhost:8080/products";

  constructor(private http: HttpClient) {
  }

  getAllProducts():Observable<HttpResponse<ProductModel[]>>{
    return this.http.get<ProductModel[]>(this.CATALOGUE_URL, { observe: 'response' });
  }
}
