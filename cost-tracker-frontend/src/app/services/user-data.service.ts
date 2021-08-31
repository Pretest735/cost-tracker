import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { retry } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable(
  // {
  //   providedIn: 'root'
  // }
)
export class UserDataService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getUserList(): Observable<User[]> {
    let url = `http://localhost:8081/api/users/user-list`;

    return this.httpClient.get<User[]>(url).pipe(
      retry(1)
    )
  }
}

export interface User {
  id: number,
  userName: string,
  passWord: string,
  isAdmin: boolean,
  isActive: boolean
}