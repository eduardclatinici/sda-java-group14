import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {ProductModel} from '../model/ProductModel';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable()
export class CatalogueService {

  private CATALOGUE_URL = '/api/products';

  constructor(private http: HttpClient) {
  }

  getAllProducts(): Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>(this.CATALOGUE_URL);
  }
}
