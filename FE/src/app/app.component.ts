import { Component, OnInit } from '@angular/core';
import { Phone } from './Phone';
import { PhoneService } from './phone.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'PhoneValidation';

  phones: Phone[] = [];
  country:string='';
  state:string='';

  constructor(
    private phoneService: PhoneService,
  ) { }

  ngOnInit(): void {

    this.phoneService.getPhones(this.country, this.state).subscribe(res => {
      this.phones = res;
    });
  }
  }


