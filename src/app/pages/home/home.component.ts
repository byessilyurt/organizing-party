import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../../services/user.service';
import { EventService } from '../../services/event.service';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users: any[] = [];
  selectedUser: any;
  events: any[] = [];
  selectedEvent: any;
  showEditForm = false;
  selectedEventDetail: any = null;
  
  newEvent = {
    title: '',
    description: '',
    imageUrl: '',
    eventDate: ''
  }

  constructor(
    private userService: UserService,
    private eventService: EventService,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getUsers();
    this.getEvents();
  }

  getUsers() {
    this.userService.getUsers().subscribe(users => this.users = users);
  }

  deleteUser(userId: number) {
    this.userService.deleteUser(userId).subscribe(() => this.getUsers());
  }

  selectUser(userId: number) {
    this.userService.getUser(userId).subscribe(user => this.selectedUser = user);
  }

  createEvent() {
    this.eventService.createEvent(this.newEvent).subscribe(() => {
      this.getEvents();
      this.newEvent = {
        title: '',
        description: '',
        imageUrl: '',
        eventDate: ''
      }
    });
  }

  getEvents() {
    this.eventService.getEvents().subscribe(events => this.events = events);
  }
  getEventDetail(eventId: number) {
    this.eventService.getEvent(eventId).subscribe((event: any) => {
      this.selectedEventDetail = event;
    });
  }
  selectEvent(eventId: number) {
    this.eventService.getEvent(eventId).subscribe((event: any) => {
      this.selectedEvent = event;
      this.showEditForm = true; 
    });
  }
  
  updateEvent() {
    this.eventService.updateEvent(this.selectedEvent.id, this.selectedEvent)
      .subscribe(() => {
        this.showEditForm = false;  
        this.selectedEvent = null;  
      }, (error) => {
        console.error(error);
      });
  }
  
  deleteEvent(eventId: number) {
    this.eventService.deleteEvent(eventId).subscribe(() => {
      if (this.selectedEvent && this.selectedEvent.id === eventId) {
        this.showEditForm = false;
        this.selectedEvent = null;
      }
      this.events = this.events.filter(e => e.id !== eventId);
    });
  }
  logout() {
    this.authService.logout();
    this.router.navigate(['/login']); 
  }
}
