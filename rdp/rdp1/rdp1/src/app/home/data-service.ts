import { Injectable, Inject } from '@angular/core';
import { Http, URLSearchParams, Jsonp, Headers } from '@angular/http';
import { Observable } from 'rxjs';
// import { toPromise } from 'rxjs/operators';
import { map } from 'rxjs/operators';
// import { catch } from 'rxjs/operators';
import 'rxjs/Rx';

@Injectable()
export class DataService {


  // inject http service and create object
  constructor(private http: Http) {

  }

  //property to hold homes list
  homes;

  // store data set into a homes property 
  setHomesData(homes) {
    // TODO3
    //Set homes data to local Homes property
    this.homes = homes;
  }

  // return data set from the homes property
  getHomesData() {
    // TODO4 
    //return homes
    return this.homes;
  }


  // make service request to fetch homes list along with URL parameters
  // home, city, minBudget and maxBudget.
  //If there is an error in request, use Observable for error. The response should be return in json format.
  getHomes(form) {
    const body = JSON.stringify(form);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    let params = new URLSearchParams();
    //TODO5 set search params for home, city, minBudget, maxBudget
    // Example: params.set( 'home', form.home );

    // TODO6
    //Make http request to URL: http://localhost:3000/homes
    // example URL : http://localhost:3000/homes?home=2BHK&city=Bangalore&minBudget=1&maxBudget=100000000

    params.set('city', form.city);
    params.set('home', form.home);
    params.set('minBudget', form.minBudget);
    params.set('maxBudget', form.maxBudget);

    // console.log(params);

    let URL = "http://localhost:3000/homes?home=" + form.home + "&city=" + form.city + "&minBudget=" + form.minBudget + "&maxBudget=" + form.maxBudget;

    return this.http.get(URL).map(res => res.json());

  }

}