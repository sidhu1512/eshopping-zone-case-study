import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css'],
})
export class FrontPageComponent implements OnInit {
  constructor(public route: Router) {}

  ngOnInit(): void {}
  images: any = [
    {
      img: 'https://rukminim1.flixcart.com/image/832/832/allinone-desktop/m/x/g/apple-imac-original-imaejxpjgm4xrtym.jpeg?q=70',
      desc: 'Apple Desktop',
    },
    {
      img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGe78dLQwID4qoH7vRAB3PlklDH8Uu8o24DA&usqp=CAU',
      desc: 'Realme 11 pro',
    },
    {
      img: 'https://rukminim1.flixcart.com/image/832/832/xif0q/smart-headphone/y/b/m/liquid-earbuds-madrabbit-original-imagmzgye5rqqkeh.jpeg?q=70',
      desc: 'Boat Earpods',
    },
    {
      img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2ojYClrN4FpNJVsNVAwOM6YvTOze4BRP11A&usqp=CAU',
      desc: 'Shoes',
    },
  ];

  onClick() {
    this.route.navigate(['/home']);
  }
}
