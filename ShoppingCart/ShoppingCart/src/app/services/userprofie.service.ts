import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserprofieService {

  constructor(private httpClient : HttpClient) { }

  getProfileById(id:any){
    return this.httpClient.get("http://localhost:8081/profile/user/"+id);
  }

  getProfileByName(username:any){
    return this.httpClient.get("http://localhost:8081/profile/userByName/"+username);
  }

  
  demo(){
    return this.httpClient.get('http://localhost:8081/demo');
  }

  addNewProfile(profile:{profileId:any,fullName:any,emailId:any,gender:any,mobileNumber:any}){
    return this.httpClient.post("http://localhost:8081/profile/user",profile);
  }
}
