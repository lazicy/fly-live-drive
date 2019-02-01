import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class DataService {

  ID = new BehaviorSubject("");
  edit = this.ID.asObservable();

  username = new BehaviorSubject("");
  changed = this.username.asObservable();

  constructor() { }

  changeID(value){
      this.ID.next(value);
  }

  changeUsername(value){
    this.username.next(value);
  }

}