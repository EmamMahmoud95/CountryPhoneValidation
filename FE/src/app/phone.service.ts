import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Phone } from './Phone';

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  constructor(private http: HttpClient) { }

  getPhones(country, state): Observable<Phone[]> {
    
    let params = {
      'county-filter': country,
      'state-filter': state,
    };
    return this.http.get<Phone[]>('http://localhost:8080/api/customer',{
      params: params
    });
  }
}
