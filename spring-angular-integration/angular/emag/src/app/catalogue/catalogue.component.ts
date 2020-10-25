import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../services/catalogue.service";
import {ProductModel} from "../model/ProductModel";

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})
export class CatalogueComponent implements OnInit {

  private catalogueService: CatalogueService

  products: ProductModel[]

  constructor(catalogueService: CatalogueService) {
    this.catalogueService = catalogueService;
  }

  ngOnInit(): void {
    this.catalogueService.getAllProducts().subscribe(response => this.products = response.body)
  }

}
