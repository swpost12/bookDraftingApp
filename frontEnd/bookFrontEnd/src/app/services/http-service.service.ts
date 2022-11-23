import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { BookInterface } from '../interfaces/book-interface';
import { CharacterInterface } from '../interfaces/character-interface';
import { jsDocComment } from '@angular/compiler';


@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private http:HttpClient) { }

baseUrl: string="http://localhost:5001/api/"
httpOptions={headers:new HttpHeaders({"Content-type": "application/json"})}


  getAllBooks(){

    return this.http.get<BookInterface[]>(`${this.baseUrl}books`)

  }

  addBook(book:BookInterface){
    let body=JSON.stringify(book)
    return this.http.post<BookInterface>(`${this.baseUrl}books`,body,this.httpOptions)

  }

  updateBook(book:BookInterface){
    let body=JSON.stringify(book)
    return this.http.patch(`${this.baseUrl}books/${book.id}`,body,this.httpOptions)
  }

  getAllCharacters(){
    return this.http.get<CharacterInterface>(`${this.baseUrl}character`)
  }

  updateCharacter(character:CharacterInterface,id:number){
    let body=JSON.stringify(character);
    console.log(body)
    return this.http.put<CharacterInterface>(`${this.baseUrl}character/${id}`,body,this.httpOptions)
  }

  addCharacter(character:CharacterInterface){
    let body=JSON.stringify(character)
    return this.http.post<CharacterInterface>(`${this.baseUrl}character`,body,this.httpOptions);
  }


}
