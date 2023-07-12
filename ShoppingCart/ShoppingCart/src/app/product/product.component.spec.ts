import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { ProductComponent } from './product.component';
import { ProductService } from '../services/product.service';
import { AdminService } from '../services/admin.service';
import { Product } from '../model/product';

describe('ProductComponent', () => {
  let component: ProductComponent;
  let fixture: ComponentFixture<ProductComponent>;

  let productService: jasmine.SpyObj<ProductService>;
  let adminService: jasmine.SpyObj<AdminService>;

  beforeEach(async () => {
    productService = jasmine.createSpyObj('ProductService', ['getAllProduct']);
    adminService = jasmine.createSpyObj('AdminService', ['deleteProduct']);

    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [ProductComponent],
      providers: [
        { provide: ProductService, useValue: productService },
        { provide: AdminService, useValue: adminService }
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should fetch products from the ProductService', () => {
    const mockProducts: Product[] = [
      {
        productId: 1,
        productType: 'Type 1',
        productName: 'Product 1',
        category: 'Category 1',
        rating: 4.5,
        review: 'Great product',
        price: 99.99,
        image: 'product1.jpg',
        description: 'Product 1 description',
        specification: 'Product 1 specification',
        quantity: 10
      },
      // Add more sample products if needed
    ];
    productService.getAllProduct.and.returnValue(of(mockProducts));

    component.showProducts();

    expect(productService.getAllProduct).toHaveBeenCalled();
    expect(component.products).toEqual(mockProducts);
    expect(console.log).toHaveBeenCalledWith(mockProducts);
    // Additional checks for each property
    expect(component.products[0].productId).toBe(1);
    expect(component.products[0].productType).toBe('Type 1');
    expect(component.products[0].productName).toBe('Product 1');
    expect(component.products[0].category).toBe('Category 1');
    expect(component.products[0].rating).toBe(4.5);
    expect(component.products[0].review).toBe('Great product');
    expect(component.products[0].price).toBe(99.99);
    expect(component.products[0].image).toBe('product1.jpg');
    expect(component.products[0].description).toBe('Product 1 description');
    expect(component.products[0].specification).toBe('Product 1 specification');
    expect(component.products[0].quantity).toBe(10);
  });

  // ...
});

  // it('should delete a product and reload the page', () => {
  //   const sampleId = 1;
  //   spyOn(window.location, 'reload');

  //   this.component.onClickDelete(sampleId);

  //   expect(this.adminService.deleteProduct).toHaveBeenCalledWith(sampleId);
  //   expect(window.location.reload).toHaveBeenCalled();
  //   // Add more expectations for alert() if needed
  // });

