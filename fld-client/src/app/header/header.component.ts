import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn: boolean = false;
  name: any;
  constructor(private service: AuthService, private router: Router,private dataService: DataService) { }

  ngOnInit() {
    
  }

  logOut(){
    this.service.logout();
    
  }
}
