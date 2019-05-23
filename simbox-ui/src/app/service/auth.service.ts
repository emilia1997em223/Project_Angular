import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import {  map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient,
    private router:Router) {

     }

  login(username:string, password:string){
    let data = {auth: username.concat(':',password)};
    console.log("Invoke http post request",data);
    return this.http.post<any>(environment.apiUrl,data).pipe(
      map(data => {
        let tmp = JSON.parse(data);
        console.log(tmp && tmp['"status"'],tmp , tmp['status'])
        if (tmp && tmp['status']) {
          console.log('token', JSON.stringify(tmp['token']));
          localStorage.setItem('authtoken', JSON.stringify(tmp['token']));
          //localStorage.setItem('user', JSON.stringify(data['user']));
          this.router.navigate(['']);

      }
      
      return data;
        console.log(data);
      })
    );
  }

  checktokeStatus(){
    if (localStorage.getItem("authtoken")) {
      return true;
    }
    return false;
  }
}
