// event.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  apiUrl = 'http://localhost:3000';

  constructor(private http: HttpClient, private authService: AuthService) { } 

  getEvents(page: number = 1, limit: number = 10) {
    return this.http.get<any[]>(`${this.apiUrl}/events?page=${page}&limit=${limit}`);
  }

  createEvent(event: any) {
    const userId = this.authService.getCurrentUserId();
    let creationDate = new Date().toISOString();
  
    let eventDateObject = new Date(event.eventDate);
    eventDateObject.setHours(0, 0, 0, 0);
    let eventDate: string = new Date(eventDateObject.getTime() - (eventDateObject.getTimezoneOffset() * 60000)).toISOString();
  
    const fullEvent = {
      ...event,
      userId,
      creationDate,
      eventDate  
    };
  
    return this.http.post(`${this.apiUrl}/events`, fullEvent);
  }

  deleteEvent(eventId: number) {
    return this.http.delete(`${this.apiUrl}/events/${eventId}`);
  }

  getEvent(eventId: number) {
    return this.http.get(`${this.apiUrl}/events/${eventId}`);
  }
  updateEvent(eventId: number, event: any) {
    let eventDateObject = new Date(event.eventDate);
    eventDateObject.setHours(0, 0, 0, 0);
    let eventDate: string = new Date(eventDateObject.getTime() - (eventDateObject.getTimezoneOffset() * 60000)).toISOString();
  
    const updatedEvent = {
      ...event,
      eventDate  
    };
  
    return this.http.put(`${this.apiUrl}/events/${eventId}`, updatedEvent);
  }
  
}
