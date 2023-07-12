import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  getProfileByName(username: any): any {
    throw new Error('Method not implemented.');
  }

  constructor(private httpClient:HttpClient) { }

  addNewProfile(profile:{profileId:any,fullName:any,emailId:any,gender:any,mobileNumber:any}){
    console.log(profile);
    return this.httpClient.post('http://localhost:8081/profile/user',profile);
  }

  getProfileById(profileId:any){
    console.log(profileId);
    return this.httpClient.get('http://localhost:8081/profile/user/'+profileId);
  }

  updateProfile(profile:{profileId:any,fullName:any,emailId:any,mobile:any,gender:any,mobileNumber:any},fullName:any){
    return this.httpClient.put('http://localhost:8081/profile/user/update/'+fullName,profile);
  }
}
