import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { XyzComponent } from './xyz/xyz.component';

const routes: Routes = [
  { path: 'xyz/:fuck', component: XyzComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
