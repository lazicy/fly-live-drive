import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appLoading]'
})
export class LoadingDirective {

  constructor(el: ElementRef) {
    el.nativeElement.src = "/src/img/loading.gif";
  }

}
