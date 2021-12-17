import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'project-2';
  isCartOpen: boolean = false

  toggleCart(event: Event){
    event.preventDefault();
    this.isCartOpen = !this.isCartOpen
  }
}


