import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CursoIndexComponent } from './pages/curso/curso-index/curso-index.component';
import { CursoNewComponent } from './pages/curso/curso-new/curso-new.component';
import { EstudanteIndexComponent } from './pages/estudante/estudante-index/estudante-index.component';
import { EstudanteNewComponent } from './pages/estudante/estudante-new/estudante-new.component';
import { InfraestruturaIndexComponent } from './pages/infraestrutura/infraestrutura-index/infraestrutura-index.component';
import { InfraestruturaNewComponent } from './pages/infraestrutura/infraestrutura-new/infraestrutura-new.component';
import { InstituicaoIndexComponent } from './pages/instituicao/instituicao-index/instituicao-index.component';
import { InstituicaoNewComponent } from './pages/instituicao/instituicao-new/instituicao-new.component';
import { InstituicaoCursoIndexComponent } from './pages/instituicao-curso/instituicao-curso-index/instituicao-curso-index.component';
import { InstituicaoCursoNewComponent } from './pages/instituicao-curso/instituicao-curso-new/instituicao-curso-new.component';
import { PublicacaoIndexComponent } from './pages/publicacao/publicacao-index/publicacao-index.component';
import { PublicacaoNewComponent } from './pages/publicacao/publicacao-new/publicacao-new.component';
import { HeaderComponent } from './shared/header/header.component';
import { MenuComponent } from './shared/menu/menu.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ContainerComponent } from './shared/container/container.component';
import { FormsModule } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CursoIndexComponent,
    CursoNewComponent,
    EstudanteIndexComponent,
    EstudanteNewComponent,
    InfraestruturaIndexComponent,
    InfraestruturaNewComponent,
    InstituicaoIndexComponent,
    InstituicaoNewComponent,
    InstituicaoCursoIndexComponent,
    InstituicaoCursoNewComponent,
    PublicacaoIndexComponent,
    PublicacaoNewComponent,
    HeaderComponent,
    MenuComponent,
    FooterComponent,
    ContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideHttpClient(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
