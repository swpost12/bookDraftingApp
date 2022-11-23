import { Component, OnInit } from '@angular/core';
import { CharacterInterface } from 'src/app/interfaces/character-interface';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-character-view',
  templateUrl: './character-view.component.html',
  styleUrls: ['./character-view.component.css']
})
export class CharacterViewComponent implements OnInit {

  constructor(private http:HttpServiceService) { }

  ngOnInit(): void {
    this.getAllCharacter();
  }

  charArray :any;
  characterDetails:any
  showDetailsFlag:boolean=false
  newName:string="new name"
  newAge:number=0;
  newArchtype:string="new archtype"
  newPhysicalDescription:string="Description"
  newBackstory:string="new backStory"
  newGear:string="gear"
  charId:number=0
  bookId:number=0
  updateFlag:boolean=false
  


  getAllCharacter(){
    this.http.getAllCharacters().subscribe(res=>{
      console.log(res)
      this.charArray=res
    })
  }

  showDetails(character:any){
    this.characterDetails=character;
    this.showDetailsFlag=!this.showDetailsFlag;

  }

  hideDetails(){
    this.showDetailsFlag=!this.showDetailsFlag
  }

  updateDetails(char:any){

    this.newName=char.name;
    this.newAge=char.age;
    this.newArchtype=char.characterType,
    this.newPhysicalDescription=char.physicalDescriptions
    this.newBackstory=char.backStory
    this.charId=char.id;
    this.bookId=char.bookId.id?char.bookId.id:char.bookId
    this.newGear=char.gear
    this.updateFlag=true
   
  }
  saveChanges(){
    let updatedInfo:CharacterInterface={
      age:this.newAge,
      name:this.newName,
      gear:this.newGear,
      physicalDescriptions:this.newPhysicalDescription,
      backStory:this.newBackstory,
      characterType:this.newArchtype,
      bookId:this.bookId
    }

    alert(updatedInfo.backStory)

    this.http.updateCharacter(updatedInfo,this.charId).subscribe(res=>{
      alert('the character has been updated please refresh the page')
       this.updateFlag=false
    },
    err=>{
      alert(err.body)
    })

    
   

  }



}
