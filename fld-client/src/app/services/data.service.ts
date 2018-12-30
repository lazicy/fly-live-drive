import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class DataService {

  ID = new BehaviorSubject("false");
  edit = this.ID.asObservable();
  constructor() { }

  changeID(value){
      this.ID.next(value);
  }

}