import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiUrl = 'http://localhost:3000';

  constructor(private http: HttpClient,
    private authService: AuthService,
    private router: Router
    ) { }

  getUsers() {
    return this.http.get<any[]>(`${this.apiUrl}/users`);
  }

  deleteUser(userId: number) {
      if (userId === this.authService.getCurrentUserId()) {
        this.authService.logout();
        this.router.navigate(['/login']);

    }
    return this.http.delete(`${this.apiUrl}/users/${userId}`);
  }

  getUser(userId: number) {
    return this.http.get(`${this.apiUrl}/users/${userId}`);
  }
}
