import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }

  private baseUrl = 'http://localhost:8888/voituress'; 
  private baseClientUrl = 'http://localhost:8888/clients';
  private baseUrl1 = 'http://localhost:8888/voitures'; 



  getAllVoitures(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getVoitureById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl1}/${id}`);
  }

  createVoiture(clientId: number, voiture: any): Observable<any> {
    return this.http.post(`${this.baseUrl1}/${clientId}`, voiture);
  }

  updateVoiture(id: number, voiture: any): Observable<any> {
    return this.http.put(`${this.baseUrl1}/${id}`, voiture);
  }

  deleteVoiture(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl1}/${id}`);
  }

  getAllClients(): Observable<any> {
    return this.http.get(`${this.baseClientUrl}`);
  }
}
