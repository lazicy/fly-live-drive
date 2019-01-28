import { Component, OnInit } from '@angular/core';
import { AvioService } from 'src/app/services/avio.service';

@Component({
  selector: 'app-aviolist-admin',
  templateUrl: './aviolist-admin.component.html',
  styleUrls: ['./aviolist-admin.component.css']
})
export class AviolistAdminComponent implements OnInit {
  avioList: any;
  emptyAvioList: boolean = false;
  constructor(private avioService: AvioService) { }

	ngOnInit() {

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

}
