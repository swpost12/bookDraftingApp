import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNewEntryComponent } from './components/add-new-entry/add-new-entry.component';
import { BookViewComponent } from './components/book-view/book-view.component';
import { CharacterViewComponent } from './components/character-view/character-view.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';

const routes: Routes = [
  {path:"add",component:AddNewEntryComponent},
  {path:"book",component:BookViewComponent},
  {path:"character",component:CharacterViewComponent},
  {path:"home",component:HomeComponentComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
