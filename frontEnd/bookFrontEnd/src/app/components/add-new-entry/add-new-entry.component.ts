import { Component, OnInit } from '@angular/core';
import { catchError } from 'rxjs';
import { BookInterface } from 'src/app/interfaces/book-interface';
import { CharacterInterface } from 'src/app/interfaces/character-interface';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-add-new-entry',
  templateUrl: './add-new-entry.component.html',
  styleUrls: ['./add-new-entry.component.css']
})
export class AddNewEntryComponent implements OnInit {

  constructor(private http:HttpServiceService) { }

  ngOnInit(): void {
  }
  title:string="new title"
  plot:string="new plot"
  author:string="new author"
  pageCount:number=0
  genre:string="new Genre"
  addFlag:boolean=false


  age:number=0
  name: string="new name"
  gear: string="new gear"
  physicalDescriptions:string="new description"
  backStory: string="new backStory"
  characterType:string="type"
  bookId:number=0

  addbook(){
    let book:BookInterface={
      author:this.author,
      title:this.title,
      pageCount:this.pageCount,
      genre:this.genre,
      id:0,
      plot:this.plot,
      charactersList:0
    };
    this.http.addBook(book).subscribe(res=>{
     window.alert("added book with id "+res.id)
    },
    res=>{
      window.alert(res.body)
    })
   

  }

  addCharacter(){
    let char:CharacterInterface={
      age:this.age,
      name:this.name,
      gear:this.gear,
      physicalDescriptions:this.physicalDescriptions,
      backStory: this.backStory,
      characterType:this.characterType,
      bookId:this.bookId
    }
    this.http.addCharacter(char)
    .subscribe(res=>{
      alert("added the charachter with name "+res.name)
    },
    ()=>{
      alert("could not add character")
    })
   

  }
  
  

}
