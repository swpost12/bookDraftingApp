import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookViewComponent } from './components/book-view/book-view.component';
import { CharacterViewComponent } from './components/character-view/character-view.component';
import { AddNewEntryComponent } from './components/add-new-entry/add-new-entry.component';

@NgModule({
  declarations: [
    AppComponent,
    BookViewComponent,
    CharacterViewComponent,
    AddNewEntryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
