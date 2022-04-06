import { Safari } from './../model/safari';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Activite } from '../model/activite';

@Injectable({
  providedIn: 'root',
})
export class ActiviteService {
  private static URL: string = 'http://localhost:8080/centerpark/api/activite';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(ActiviteService.URL);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${ActiviteService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${ActiviteService.URL}/${id}`);
  }

  public create(activite: Activite): Observable<any> {
    return this.http.post(ActiviteService.URL, this.activiteToJson(activite));
  }

  public update(activite: Activite): Observable<any> {
    console.log(this.activiteToJson(activite));
    return this.http.put(
      `${ActiviteService.URL}/${activite.id}`,
      this.activiteToJson(activite)
    );
  }

  private activiteToJson(activite: Activite): any {
    let obj = {
      id: activite.id,
      meteo: activite.meteo,
      date: activite.date,
      heure: activite.heure,
      prix: activite.prix,
    };
    if (activite instanceof Safari) {
      Object.assign(obj, {
        type: 'safari',
        vehicule: { id: activite.vehicule?.id },
      });
    } else {
      Object.assign(obj, { type: 'aquatique' });
    }
    return obj;
  }
}
