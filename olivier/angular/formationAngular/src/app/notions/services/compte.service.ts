import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  constructor(private http: HttpClient) {}

  public inscriptionClient(compte: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/centerpark/api/compte/client/inscription',
      compte
    );
  }

  public findByEmail(email: string): Observable<any> {
    return this.http.get(
      'http://localhost:8080/centerpark/api/compte/search/' + email
    );
  }
}
