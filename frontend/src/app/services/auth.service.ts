import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:3000/auth';

  constructor(private http: HttpClient) { }

  register(username: string, password: string) {
    return this.http.post(`${this.apiUrl}/register`, { username, password });
  }

  login(username: string, password: string) {
    return this.http.post(`${this.apiUrl}/login`, { username, password })
      .pipe(
        tap((user) => localStorage.setItem('user', JSON.stringify(user)))
      );
  }

  get isLoggedIn(): boolean {
    return !!localStorage.getItem('user');
  }

  get loggedInUser() {

    return JSON.parse(localStorage.getItem('user') || '{}');
  }
  
  getCurrentUserId(): number | null {
    const user = this.loggedInUser;
    return user && user.userId ? user.userId : null;
  }

  logout() {
    localStorage.removeItem('user');
  }
  
}
