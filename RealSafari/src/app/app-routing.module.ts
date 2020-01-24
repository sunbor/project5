import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { EncounterComponent } from './encounter/encounter.component';
import { CollectionComponent } from './collection/collection.component';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent
},
{
  path: 'encounter',
  component: EncounterComponent
}, 
{
  path: 'collection',
  component: CollectionComponent
},
{
  path: '**',
  redirectTo: 'login'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
