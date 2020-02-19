import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule, FormGroup} from '@angular/forms';
import { DataService } from './data-service';

@Component({
	selector: 'my-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.css']
})

export class HomeComponent {
	// initiate dataservice and router
	constructor(public dataSvc: DataService, public router: Router) {
		console.log("in constructor...");
	}


	// Error keys object to show different kind of errors and info to user
	errorKeys = {
		isCityValid: true,
		isBhkValid: true,
		isMinBudgetValid: true,
		isMaxBudgetValid: true,
		isMaxLessThanMinValid: true,
		isNoResultValid: true
	}

	// property to store/fetch the list of homes
	homes;

	// call this function when you click on view properties button
	// call "this.validateForm" function from here and if it returns true make http request
	// using function of dataService 
	// if homes list if fetched successfully, store it in dataService and navigate to results page
	onSubmit(form) {

		//TODO1
		//1. Validate form

		//2. If form gets validated, make call data service functions to fetch data

		//3. When request is successful, set the list of properties inside a property of �data service� and using router navigate to �results" route
		// console.log(form);
		let isValidForm = this.validateForm(form);

		if (isValidForm) {
			this.dataSvc.getHomes(form.value).subscribe(data => {
				if (data.status == "success") {
					this.dataSvc.setHomesData(data.data);
					this.router.navigate(['/results']);
				} else {
					this.errorKeys.isNoResultValid = false;
				}
			});
			this.router.navigate(['/result']);

		}
	}

	// call this function from "onSubmit" function to validate if form is valid or not
	// do all validations from here and show and hide the error messages in UI
	// return false if form is invalid, return true if form is valid
	validateForm(form) {
		this.errorKeys = {
			isCityValid: true,
			isBhkValid: true,
			isMinBudgetValid: true,
			isMaxBudgetValid: true,
			isMaxLessThanMinValid: true,
			isNoResultValid: true
		}

		let isValidForm = true;
		//TODO2
		//1. do all validations and return false if there is any error
		//2. set error key to true according to the invalid field

		// else return true

		// else{
		// 	return true;
		// }
		let formObj = form.value;
		// console.log(formObj);
		if (!formObj.city) {
			this.errorKeys.isCityValid = false;
			isValidForm = false;
		}

		if (!formObj.home) {
			this.errorKeys.isBhkValid = false;
			isValidForm = false;
		}
		if (formObj.minBudget === '') {
			this.errorKeys.isMinBudgetValid = false;
			isValidForm = false;
		}

		if (!formObj.maxBudget) {
			this.errorKeys.isMaxBudgetValid = false;
			isValidForm = false;
		} else if (formObj.maxBudget > 10000000000) {
			this.errorKeys.isMaxBudgetValid = false;
			isValidForm = true;
		}

		if (formObj.maxBudget > -1 && formObj.minBudget > -1 && (formObj.maxBudget < formObj.minBudget)) {
			this.errorKeys.isMaxLessThanMinValid = false;
			isValidForm = false;
		}

		if (isValidForm) {
			return true;
		} else {
			return false;
		}
	}

}