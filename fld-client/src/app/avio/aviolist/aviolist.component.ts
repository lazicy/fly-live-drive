import { Component, OnInit, OnDestroy } from '@angular/core';
import { AvioService } from '../../services/avio.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-aviolist',
  templateUrl: './aviolist.component.html',
  styleUrls: ['./aviolist.component.css']
})
export class AviolistComponent implements OnInit, OnDestroy {
  avioList: any;
  emptyAvioList: boolean = false;
  subscription: Subscription;
  constructor(private avioService: AvioService) { }

	ngOnInit() {
		// console.log("AviolistComponent ngOnInit()");
		// this.avioService.getAvios();
		// // invoked whenever aviosChanged.next() in AvioService is called 
		// this.subscription = this.avioService.aviosChanged
		// 	.subscribe(
		// 		avioList => this.avioList = avioList
		// 	);

		this.avioService.getAvios()
			.subscribe(
				(data) => { 
					this.avioList = data;
					if (this.avioList.length === 0) {
						this.emptyAvioList = true;
					}
				},
				(error) => console.error(error)
			);
	}

	ngOnDestroy() {
		// // HAS TO BE DONE
		// this.subscription.unsubscribe();
    
  	}
}
