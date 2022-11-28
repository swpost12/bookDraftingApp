import { jsDocComment } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { BookInterface } from 'src/app/interfaces/book-interface';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css']
})
export class BookViewComponent implements OnInit {

  constructor(private http:HttpServiceService) { }
  BookList :BookInterface[]=[{id: 0,
    title:"", 
    plot: "", 
    author: "", 
    pageCount:0, 
    genre:"", 
    charactersList:["string", "string"]}, 
                            
                          ];





  ngOnInit(): void {
    this.http.getAllBooks().subscribe(res=>{
      console.log(res)
      this.BookList=res
    })
  }

  title:string="";
  author:string="";
  plot: string="Update Plot"
  update:boolean=false
  id:number=0;
  pageCount:number=0;
  genre:string=""
  
  

  updateBook(id:number){
    console.log(id);
    let book=this.BookList.find(element=>id===element.id)

    this.title=book?.title!;
    this.author=book?.author!;
    this.plot=book?.plot!;
    this.pageCount=book?.pageCount!;
    this.id=book?.id!;
    this.genre=book?.genre!;

    this.update=true;

  }

  saveChanges(){

    let book:BookInterface={
      id:this.id,
      title:this.title,
      plot:this.plot,
      author:this.author,
      pageCount:this.pageCount,
      genre: this.genre,
      charactersList:null
    }
    this.http.updateBook(book).subscribe(res=>{
      
      console.log(res)
      window.alert("updated book\n please refresh the page")
    },
    err=>{
      window.alert(err)
    })



    this.update=false
  }


  stopUpdate(){
    this.update=false
  }
 


}
