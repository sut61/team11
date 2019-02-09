import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FindChecksService {

  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  findChecks(checksId: any): Observable<any>{
    return this.http.get(this.API + '/findChecks/' + checksId);
  }
}
