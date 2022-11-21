import { Component, OnInit } from '@angular/core';
import { BookInterface } from 'src/app/interfaces/book-interface';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css']
})
export class BookViewComponent implements OnInit {

  constructor() { }
  BookList :BookInterface[]=[{id: 1,title:"someTitle", plot: "some plot", author: "a author", pageCount:20, genre:"fiction", charactersList:["string", "string"]}, 
                            {id: 2,title:"someTitle", plot: "some plot", author: "a author", pageCount:20, genre:"fiction", charactersList:["string", "string"]}
                          ];





  ngOnInit(): void {
  }

  title:string="";
  author:string="";
  plot: string="Update Plot"
  update:boolean=false
  pageCount:Number=0;
  

  updateBook(id:number){
    console.log(id);
    let book=this.BookList.find(element=>id===element.id)

    this.title=book?.title;
    this.author=book?.author

    this.update=true;

  }

  saveChanges(){
    this.update=false
  }



}
