import { Vehicule } from './../model/vehicule';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VehiculeService {
  private static URL: string = 'http://localhost:8080/centerpark/api/vehicule';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(VehiculeService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(VehiculeService.URL + '/' + id);
  }

  public get(id: number): Observable<Vehicule> {
    return this.http.get<Vehicule>(VehiculeService.URL + '/' + id);
  }

  public create(vehicule: Vehicule): Observable<Vehicule> {
    let obj = {
      model: vehicule.model,
    };
    console.log(vehicule);
    console.log(obj);
    return this.http.post<Vehicule>(VehiculeService.URL, obj);
  }

  public update(vehicule: Vehicule): Observable<Vehicule> {
    console.log(vehicule);
    return this.http.put<Vehicule>(
      VehiculeService.URL + '/' + vehicule.id,
      vehicule
    );
  }
}
