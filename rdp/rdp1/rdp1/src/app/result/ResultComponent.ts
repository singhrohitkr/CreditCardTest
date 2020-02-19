import { Component, OnInit } from '@angular/core';
import { DataService } from '../home/data-service';
@Component({
  selector: 'my-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {

  constructor(public dataSvc: DataService) {

  }

  // property to hold the homes list
  listHomes = [];

  // on init, fetch the list of homes which you set from homes component
  //and store in a "listHomes" property  which you can iterate to show in UI
  ngOnInit() {

    // TODO7
    // Fetch the stored results from data service and store in local property "listHomes"
    this.listHomes = this.dataSvc.getHomesData();
    console.log(this.listHomes);

  }

  enqBtn() {
    alert("Your enquiry has been sent and our team will get back to you shortly.");
  }

}
