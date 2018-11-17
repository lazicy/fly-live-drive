import { Component, OnInit, OnDestroy } from '@angular/core';
import { AvioService } from '../avio.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-aviolist',
  templateUrl: './aviolist.component.html',
  styleUrls: ['./aviolist.component.css']
})
export class AviolistComponent implements OnInit, OnDestroy {
  avioList: any;
  subscription: Subscription;
  constructor(private avioService: AvioService) { }

	ngOnInit() {
		console.log("AviolistComponent ngOnInit()");
		this.avioService.getAvios();
		// invoked whenever aviosChanged.next() in AvioService is called 
		this.subscription = this.avioService.aviosChanged
			.subscribe(
				avioList => this.avioList = avioList
			);
	}

	ngOnDestroy() {
		// HAS TO BE DONE
		this.subscription.unsubscribe();
    
  	}
}
